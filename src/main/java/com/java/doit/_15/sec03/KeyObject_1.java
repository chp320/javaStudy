package com.java.doit._15.sec03;

/* 3개의 동기화 영역이 '동일한 열쇠'로 동기화된 경우 */

// 공유 객체
class MyData_key1 {
    synchronized void abc() {
        for(int i=0; i<3; i++) {
            System.out.println(i + "sec");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }

    synchronized void bcd() {
        for(int i=0; i<3; i++) {
            System.out.println(i + "초");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }

    void cde() {
        synchronized (this) {
            for(int i=0; i<3; i++) {
                System.out.println(i + "번째");
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        }
    }
}
public class KeyObject_1 {
    public static void main(String[] args) {
        // 공유 객체
        MyData_key1 myData = new MyData_key1();

        // 3개의 쓰레드가 각각의 메서드 호출
        new Thread() {
            @Override
            public void run() {
                myData.abc();
            };
        }.start();
        new Thread() {
            @Override
            public void run() {
                myData.bcd();
            };
        }.start();
        new Thread() {
            @Override
            public void run() {
                myData.cde();
            };
        }.start();
    }
}
