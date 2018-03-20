package com.rev.etl.faker.utils.requestid;

import org.apache.commons.codec.binary.Base64;

import java.util.Random;

public class Base64Utils {

    private static String randomString = "WQ9MTY3OTA5MW3M1YTg4MGZhZjZmYjVmcWlk1PTEmcnQ9MTEE4MjIzNTUyNQ2aRIzN";
    private static int randomStringLen = randomString.length();


    /**
     * @param str - String variable to encode
     * @param prefixSize - size of the prefix to add it to the input string (str)
     * @param suffixSize - size of the suffix to add it to the input string (str)
     * @return encoded string in base64
     */

    public static String base64_encode(String str, int prefixSize,
                                       int suffixSize) {
        StringBuilder encodedString = new StringBuilder();
        Random rd = new Random();
        for (int i = 0; i < prefixSize; i++) {
            int rand = rd.nextInt() % (randomStringLen);
            encodedString.append(randomString.charAt(Math.abs(rand)));
        }
        encodedString.append(new String(Base64.encodeBase64URLSafe(str.getBytes())));
        for (int i = 0; i < suffixSize; i++) {
            int rand = rd.nextInt() % (randomStringLen);
            encodedString.append(randomString.charAt(Math.abs(rand)));
        }
        return encodedString.toString();
    }

    /**
     * @param str- Input string to encode
     * @param prefixSize - size of the prefix to remove it from the input string (str)
     * @param suffixSize - size of the suffix to remove it from the input string (str)
     * @return encoded string in base64
     */

    public static String base64_decodeString(String str, int prefixSize,
                                             int suffixSize) {
        String decodedStr = null;
        if (str != null) {
            byte[] decodedBytes = base64_decode(str, prefixSize, suffixSize);
            if (decodedBytes != null) {
                decodedStr = new String(decodedBytes);
            }
        }
        return decodedStr;
    }

    /**
     * @param str- Input string to encode
     * @param prefixSize - size of the prefix to remove it from the input string (str)
     * @param suffixSize - size of the suffix to remove it from the input string (str)
     * @return decoded byte array
     */

    public static byte[] base64_decode(String str, int prefixSize,
                                       int suffixSize) {
        String actualString = str.substring(prefixSize, (str.length() - suffixSize));
        if (actualString.length() > 0) {
            return Base64.decodeBase64(actualString);
        }
        return null;
    }

}