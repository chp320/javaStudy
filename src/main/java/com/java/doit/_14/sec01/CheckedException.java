package com.java.doit._14.sec01;

import java.io.FileInputStream;
import java.io.InputStreamReader;

class A141 implements Cloneable {
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CheckedException {
    public static void main(String[] args) {
        // Checked Exception (일반 예외)
//
//        // 1. Interrupted Exception - 반드시 예외처리 필요!
//        Thread.sleep(1000);
//
//        // 2. ClassNotFoundException - 클래스를 메모리에 동적으로 로딩하는 메서드로, 로딩 시 해당 클래스 미존재 시 오류 발생 -> 예외 처리
//        Class cls = Class.forName("java.lang.Object");
//
//        // 3. IOException - read or write 시 발생하며, 반드시 예외 처리 필요!
//        InputStreamReader in = new InputStreamReader(System.in);
//        in.read();
//
//        // 4. FileNotFoundException - 파일 read 시 해당 파일이 미존재 가능서 있기 때문에 반드시 예외 처리 필요!
//        FileInputStream fis = new FileInputStream("text.txt");
//
//        // 5. CloneNotSupportedException - ??
//        A141 a1 = new A141();
//        A141 a2 = (A141) a1.clone();
//
    }
}
