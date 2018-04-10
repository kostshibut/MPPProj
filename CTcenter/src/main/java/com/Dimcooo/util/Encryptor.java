package com.Dimcooo.util;

import java.security.MessageDigest;

public  class Encryptor {
    private static MessageDigest messageDigest;

    public static String EncryptString(String pass){
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            messageDigest.reset();
            byte[] digested = messageDigest.digest(passBytes);
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0; i < digested.length; i++){
                stringBuffer.append(Integer.toHexString(0xff & digested[i]));
            }
            return stringBuffer.toString();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
