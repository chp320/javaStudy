package com.java.doit.cipherTest;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * RSA 암호화 알고리즘
 * - 공개키 암호화 알고리즘으로 '대칭키 암호화'와는 다른 방식으로 데이터를 암호화/복호화 수행
 * - key size 는 최소.. 512 bits 되어야 하......나?
 */
public class RSACryptography {

    /*
     * [ KeyPairGenerator에 대해서 ]
     * - 공개키/개인키 쌍인 키 쌍을 생성하는데 사용됨.
     * - 공개키/개인키 쌍은 '비대칭키 암호화'에 사용되며, 암/복호화 시 서로 다른 키를 사용하는 방식
     */
    public static KeyPair generateRSAKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);  // Key size: 2048 bits
        return keyPairGenerator.generateKeyPair();
    }

    public static String encryptWithPublicKey(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decryptWithPrivateKey(String encryptedData, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedData);

        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws Exception {
        // generate RSA key pair
        KeyPair keyPair = generateRSAKeyPair();

        // get public and private keys from key pair
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        String originalData = "Hello, this is a secret message!";
        System.out.println("Original data: " + originalData);

        // encrypt data using public key
        String encryptedData = encryptWithPublicKey(originalData, publicKey);
        System.out.println("Encrypted data: " + encryptedData);

        // decrypt data using private key
        String decryptedData = decryptWithPrivateKey(encryptedData, privateKey);
        System.out.println("Decrypted data: " + decryptedData);
    }
}
