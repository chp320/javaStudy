package com.java.doit._15.sec03;

// 쓰레드 객체 속성 다루기

public class ThreadProperties_1 {
    public static void main(String[] args) {

        // 객체 참조하기, 쓰레드 개수 가져오기
        Thread curThread = Thread.currentThread();
        System.out.println("현재 쓰레드의 이름 = " + curThread.getName());
        System.out.println("동작하는 쓰레드의 개수 = " + Thread.activeCount());
    }
}
