package com.Dimcooo;

import com.Dimcooo.util.Encryptor;

public class Main {
    public static void main(String args[]){
        try {
            System.out.println(Encryptor.EncryptString("37529"));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
