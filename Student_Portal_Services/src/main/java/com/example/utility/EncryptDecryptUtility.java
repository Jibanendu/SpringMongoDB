package com.example.utility;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptDecryptUtility {
	private static final String key="STUDENTPORTALSERVICES";
	private static final byte[] randomkey= {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'};
	
	
	public static String encrypt( String value) {
        try {
        	//SecureRandom random = new SecureRandom();
        //byte[] iv = random.generateSeed(16);

            IvParameterSpec ivs = new IvParameterSpec(randomkey);
            
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec,ivs);
            byte[] encrypted = cipher.doFinal(value.getBytes());
            System.out.println("encrypted text: "  + Base64.encodeBase64String(encrypted));
            return Base64.encodeBase64String(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	public static String decrypt( String value) {
        try {
       //	SecureRandom random = new SecureRandom();
       // System.out.println(value);
       // byte[] iv = random.generateSeed(16);

          IvParameterSpec ivs = new IvParameterSpec(randomkey);
            
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec,ivs);
            byte[] decrypt=Base64.decodeBase64(value);
            String str =new String( cipher.doFinal((decrypt)));
            
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
