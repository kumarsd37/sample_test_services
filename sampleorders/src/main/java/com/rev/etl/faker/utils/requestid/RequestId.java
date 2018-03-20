package com.rev.etl.faker.utils.requestid;

import com.google.common.io.BaseEncoding;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base32;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.nio.ByteBuffer;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * RequestId Builder
 */

@Slf4j
public class RequestId {
    private static final String CHARSTRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz12345678";

    private static class State {
        private final int epochInSec;

        // seqCounter is purposefully kept as an integer to allow for overflows.
        // If we have kept it as 'short', then because of parallelism, it may happen that the
        // short value overflows and the condition 'greater than Short.MAX_VALUE' may never succeed.
        // seqCounter is like a semaphore stating that these many threads can process a request in a second
        private final AtomicInteger seqCounter;

        private State(int epochInSec, int seqCounter) {
            this.epochInSec = epochInSec;
            this.seqCounter = new AtomicInteger(seqCounter);
        }

        public static State create(int epochInSec) {
            return new State(epochInSec, 0);
        }

        public static State create() {
            return create(getCurrentSeconds());
        }

        public int getEpochInSec() {
            return epochInSec;
        }

        public int nextSeq() {
            return seqCounter.incrementAndGet();
        }
    }

    private static final AtomicReference<State> state = new AtomicReference<State>(State.create());

    private int machineIp;

    /**
     * @param machineIp
     */
    public RequestId(int machineIp) {
        this.machineIp = machineIp;
    }

    /**
     * @param adIndex
     * @return
     * @throws Exception
     */
    public String getRequestId(int adIndex) throws Exception {
        int attempt = 1;

        do {
            final State lastState = state.get();
            final int currentSec = getCurrentSeconds();

            final int nextSeq = lastState.nextSeq();
            final int epochInSec = lastState.getEpochInSec();

            if (epochInSec == currentSec) {
                if (nextSeq > Short.MAX_VALUE) {
                    ++attempt;
                    if (attempt > 2) {
                        throw new RuntimeException("Too fast - Counter is increasing short limit");
                    }
                } else {
                    final String retVal = encodeState(epochInSec, (short) nextSeq);
                    return getAdIndexChars(adIndex) + retVal;
                }
            } else {
                final State newState = State.create(currentSec);
                if (state.compareAndSet(lastState, newState)) {
                    // TODO: loggging
                    //log.debug("Resetting state");
                }
            }

        } while (true);
    }

    private String encodeState(int epochInSec, short seq) {
        final ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.putInt(epochInSec);
        buffer.putInt(machineIp);
        buffer.putShort(seq);

        return BaseEncoding.base32().omitPadding().encode(buffer.array());
    }


    private static int getCurrentSeconds() {
        return (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }


    /**
     * @return reqid parameters
     * @throws Exception
     */

    public static String getRequestIdFields(String requestId) throws Exception {
        StringJoiner retVal = new StringJoiner(":");
        if (requestId != null) {
            char c = requestId.charAt(0);
            int groupId = CHARSTRING.indexOf(c);
            String reqId = requestId.substring(1);
            byte[] bytes = new Base32().decode(reqId);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            int epoch = dataInputStream.readInt();
            int machineIp = dataInputStream.readInt();
            short counter = dataInputStream.readShort();
            retVal.add(String.valueOf(groupId));
            retVal.add(String.valueOf(epoch));
            retVal.add(String.valueOf(machineIp));
            retVal.add(String.valueOf(counter));
            return retVal.toString();
        }
        return null;
    }

    /**
     * @param adIndex
     * @return
     */

    private char getAdIndexChars(int adIndex) {
        return CHARSTRING.charAt(adIndex);
    }
}