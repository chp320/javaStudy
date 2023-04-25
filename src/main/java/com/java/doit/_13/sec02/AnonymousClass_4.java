package com.java.doit._13.sec02;

interface A4 {
    public abstract void abc();
}

class C4 {
    void cde(A4 a) {
        a.abc();        // 인터페이스 A4를 매개변수로 받아 A4의 추상 메서드 abc를 구현하고 있다.
    }
}


public class AnonymousClass_4 {
    public static void main(String[] args) {
        C4 c = new C4();

        // A4타입의 생성자 호출 후 내부에 인터페이스 A4의 추상 메서드 구현
        A4 a = new A4() {
            @Override
            public void abc() {
                System.out.println("입력매개변수 전달");
            }
        };
        c.cde(a);

        c.cde(new A4() {
            @Override
            public void abc() {
                System.out.println("입력매개변수 전달");
            }
        });
    }
}
