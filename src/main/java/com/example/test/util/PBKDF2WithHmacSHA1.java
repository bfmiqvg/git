package com.example.test.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * @Date:Created by luzy on 2018/5/18.
 * @Description: 较高密码安全实现使用 PBKDF2WithHmacSHA1 算法
 */
public class PBKDF2WithHmacSHA1 {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String  originalPassword = "123456luzy";
        String generatedSecuredPasswordHash = generateStorngPasswordHash(originalPassword,getSalt());
        System.out.println(generatedSecuredPasswordHash);

        Encrypt encrypt=new Encrypt();
        System.out.println(encrypt.MD5(generatedSecuredPasswordHash)+"    "+encrypt.MD5(generatedSecuredPasswordHash).length());
    }
    public static String generateStorngPasswordHash(String password,String saltStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = saltStr.getBytes();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return toHex(hash);
      //  return iterations + ":" + toHex(salt) + ":" + toHex(hash)+"  "+toHex(hash).length();
    }

    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }

    private static String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }
}
