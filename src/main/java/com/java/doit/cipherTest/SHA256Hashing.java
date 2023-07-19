package com.java.doit.cipherTest;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SHA256Hashing {
    public static String hash(String data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(data.getBytes(StandardCharsets.UTF_8));

        // Convert the byte array to a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : encodedHash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static void main(String[] args) throws Exception {
        String originalData = "Hello, this is the data to be hashed!";
        System.out.println(">> original: " + originalData);

        String hashedData = hash(originalData);
        System.out.println("Hashed data: " + hashedData);
    }
}
