package com.java.doit._15.sec03;

class MyThread_3_3 extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + ": " + (isDaemon()? "데몬 쓰레드" : "일반 쓰레드"));
        for(int i=0; i<6; i++) {
            System.out.println(getName() + ": " + i + "초");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }
}

public class ThreadProperties_3_3 {
    public static void main(String[] args) {

        // 일반 쓰레드
        Thread thread1 = new MyThread_3_3();
        thread1.setDaemon(false);   // 일반 쓰레드
        thread1.setName("thread1");
        thread1.start();

        // 데몬 쓰레드
        Thread thread2 = new MyThread_3_3();
        thread2.setDaemon(true);    // 데몬 쓰레드
        thread2.setName("thread2");
        thread2.start();

        // 3.5초 후 main 쓰레드 종료
        try { Thread.sleep(3500); } catch (InterruptedException e) {}
        System.out.println("main Thread 종료");
    }
}
