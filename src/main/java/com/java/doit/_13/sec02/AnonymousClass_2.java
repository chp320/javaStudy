package com.java.doit._13.sec02;

interface CC {
    public abstract void bcd();
}

class AA {
    CC cc = new CC() {
        public void bcd() {
            System.out.println("익명 이너 클래스");
        }
    } ;

    void abc() {
        cc.bcd();
    }
}

public class AnonymousClass_2 {
    public static void main(String[] args) {
        // 객체 생성 및 메서드 호출
        AA aa = new AA();
        aa.abc();
    }
}
