package com.java.doit.cipherTest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * 양방향 암호화 알고리즘
 * - AES, RSA, ECC, Blowfish, Triple DES, ChaCha20
 * - 동일한 암호화 키를 사용해서 암호화/복호화 처리 가능
 * - 단, 암호화 키가 유출되면 암호화/복호화 모두 가능하기 때문에 암호화 키를 보호하기 위해 아래의 접근 방식을 사용함
 *   1) 키 관리: 암호화 키를 안전하게 보관하고, 불필요한 접근을 막는 키 관리 시스템을 사용. 키를 규칙적으로 변경해서 무단 접근 방지
 *   2) 암호화 키 생성: 암호화 키 생성 시, 무작위성과 높은 엔트로피를 갖는 '랜덤 키'를 사용하여 예측 불가한 키 생성
 */
public class AESEncryption {
    private static final String AES_ALGORITHM = "AES";
    private static final String SECRET_KEY = "mysecretkey12345";    // 암호화 키

    public static String encrypt(String data) throws Exception {
        System.out.println(">> encrypt: " + data);
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] encryptedData = cipher.doFinal(data.getBytes());
//        System.out.println(">> encryptedData: " + encryptedData);
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static String decrypt(String encryptedData) throws Exception {
        System.out.println(">> decrypt: " + encryptedData);
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
//        System.out.println(">> decodedData: " + decodedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }

    public static void main(String[] args) throws Exception {
        String originalData = "Hello, this is a secret message!";
        System.out.println("Original: " + originalData);

        String encryptedData = encrypt(originalData);
        System.out.println("Encrypted: " + encryptedData);

        String decryptedData = decrypt(encryptedData);
        System.out.println("Decrypted: " + decryptedData);
    }
}
