package com.java.doit._15.sec03;

/* 동기화 블록을 활용한 '동기화 구현' */

// 공유 객체
class MyData_block {
    int data = 3;

    public void plusData() {
        // 블록 동기화
        synchronized (this) {
            int mydata = data;      // 데이터 가져오기
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            data = mydata + 1;
        }
    }
}

// 공유 객체를 사용하는 쓰레드
class PlusThread_block extends Thread {
    MyData_block myData;

    public PlusThread_block(MyData_block myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        myData.plusData();
        System.out.println(getName() + "실행 결과: " + myData.data);
    }
}

public class SynchronizedBlock {
    public static void main(String[] args) {
        // 공유 객체 생성
        MyData_block myData = new MyData_block();
        System.out.println("작업 전 정보 확인: " + myData.data);

        // plusThread1
        Thread plusThread1 = new PlusThread_block(myData);
        plusThread1.setName("plusThread1");
        plusThread1.start();

        // plusThread2
        Thread plusThread2 = new PlusThread_block(myData);
        plusThread2.setName("plusThread2");
        plusThread2.start();
    }
}
