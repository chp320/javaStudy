package com.java.doit.cipherTest;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * 단방향 암호화 (해시알고리즘)
 * - 해시 함수를 사용해서 암호화 처리할 때, 해시 값만으로 원본 데이터 유추가 가능하다. (레인보우 테이블 공격)
 * - 따라서 해시 함수에 추가적인 임의의 데이터인 salt를 넣어서 원본 데이터를 찾을 수 없도록 하는 방법
 */
public class SHA256HashingWithSalt {
    public static String hashWithSalt(String data) throws Exception {
        byte[] salt = generateSalt();
        System.out.println(">> salt: " + salt);
        byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);

        // Combine data with salt
        System.out.println(">> length: " + dataBytes.length + salt.length);
        byte[] dataWithSalt = new byte[dataBytes.length + salt.length];
        System.arraycopy(dataBytes, 0, dataWithSalt, 0, dataBytes.length);
        System.arraycopy(salt, 0, dataWithSalt, dataBytes.length, salt.length);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(dataWithSalt);

        // Encode hash with salt in Base64 for storage
        return Base64.getEncoder().encodeToString(encodedHash);
    }

    public static boolean verifyHash(String data, String hashedData) throws Exception {
        System.out.println(">> data: " + data + ", hashedData: " + hashedData);
        byte[] decodedHash = Base64.getDecoder().decode(hashedData);
        byte[] salt = new byte[16];
        System.arraycopy(decodedHash, decodedHash.length - 16, salt, 0, 16);

        String newHashedData = hashWithSalt(data);
        System.out.println("newHashedData: " + newHashedData);
        byte[] newDecodedHash = Base64.getDecoder().decode(newHashedData);

        return MessageDigest.isEqual(decodedHash, newDecodedHash);
    }

    private static byte[] generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    public static void main(String[] args) throws Exception {
        String originalData = "Hello, this is the data to be hashed!";
        System.out.println("original: " + originalData);

        String hashedData = hashWithSalt(originalData);
        System.out.println("Hashed data with salt: " + hashedData);

        boolean isMatch = verifyHash(originalData, hashedData);
        System.out.println("Verification result: " + isMatch);
    }

}
