/**
 * 인터페이스를 상속한 '이너 클래스'를 생성해 인터페이스 객체 생성
 */

package com.java.doit._13.sec02;

interface C {
    public abstract void bcd();
}

class A {
    C c = new B();
    class B implements C {
        public void bcd() {
            System.out.println("인스턴스 이너 클래스");
        }
    }

    void abc() {
        c.bcd();
    }
}


public class AnonymousClass_1 {
    public static void main(String[] args) {
        // 객체 생성 및 메서드 호출
        A a = new A();
        a.abc();
    }
}
