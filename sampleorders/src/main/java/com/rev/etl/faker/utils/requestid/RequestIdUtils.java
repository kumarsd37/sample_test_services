package com.rev.etl.faker.utils.requestid;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

@Slf4j
public class RequestIdUtils {

    /**
     * @param adIndex
     * @param machineIp
     * @return
     * @throws Exception
     */

    public static String[] buildRequestId(int adIndex, String machineIp) throws Exception {

        machineIp = StringUtils.replace(machineIp, ".", "");
        int mIp = Integer.parseInt(machineIp);
        String[] reqIdArray = new String[adIndex];
        for (short index = 0; index < adIndex; index++) {
            reqIdArray[index] = new RequestId(mIp).getRequestId(index);
        }
        return reqIdArray;
    }

    public static String buildRequestId(String machineIp) throws Exception
    {
        machineIp = StringUtils.replace(machineIp, ".", "");
        int mIp = Integer.parseInt(machineIp);
        return new RequestId(mIp).getRequestId(1);
    }
    /**
     * @param reqid
     * @return extracts reqid values
     */

    public static String decode_reqid(String reqid) {

        String requestId = null;
        try {
            requestId = RequestId.getRequestIdFields(reqid);
        } catch (Exception e) {
            //log.error("Exception in decoding ReqId: " + reqid);
        }
        return requestId;
    }

}