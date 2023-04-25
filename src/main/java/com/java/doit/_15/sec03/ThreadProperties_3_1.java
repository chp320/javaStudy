package com.java.doit._15.sec03;

/**
 * 일반 쓰레드 예제
 * - 일반 쓰레드는 다른 쓰레드 종료 여부와 무관하게 "자신의 작업이 종료될 때"까지 계속 수행됨
 */

class MyThread3_1 extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + ": " + (isDaemon()? "데몬 쓰레드" : "일반 쓰레드"));
        for (int i = 0; i < 6; i++) {
            System.out.println(getName() + ": " + i + "초");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }
}

public class ThreadProperties_3_1 {
    public static void main(String[] args) {

        // 일반 쓰레드
        Thread thread1 = new MyThread3_1();
        thread1.setDaemon(false);   // 일반 쓰레드로 설정
        thread1.setName("thread1");
        thread1.start();

        // 3.5초 후 main 쓰레드 종료
        try { Thread.sleep(3500); } catch (InterruptedException e) {}
        System.out.println("main Thread 종료");
    }
}
