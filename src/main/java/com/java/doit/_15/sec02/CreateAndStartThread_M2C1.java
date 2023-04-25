package com.java.doit._15.sec02;

// Runnable 인터페이스를 구현해 클래스 생성 후, 쓰레드 2개 생성 -> main, SMIFileThread

class SMIFileRunnable implements Runnable {
    @Override
    public void run() {
        // 자막 번호 하나~다섯
        String[] strArray = {"하나", "둘", "셋", "넷", "다섯"};
        try { Thread.sleep(10); } catch (InterruptedException e) {}

        // 자막 번호 출력
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(" - (자막 번호) " + strArray[i]);
            try { Thread.sleep(200); } catch (InterruptedException e) {}
        }
    }
}

public class CreateAndStartThread_M2C1 {
    public static void main(String[] args) {
        // SMIRunnable 객체 생성
        Runnable smiFileRunnable = new SMIFileRunnable();
//        smiFileRunnable.start();    // Runnable 객체에는 start() 메서드 없어서 에러!

        // Thread 생성자에 객체 전달
        Thread thread = new Thread(smiFileRunnable);
        thread.start();

        // 비디오 프레임 번호 1~5
        int[] intArray = {1, 2, 3, 4, 5};

        // 비디오 프레임 번호 출력
        for (int i = 0; i < intArray.length; i++) {
            System.out.println("(비디오 프레임) " + intArray[i]);
            try { Thread.sleep(200); } catch (InterruptedException e) {}
        }
    }
}
