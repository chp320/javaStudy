package com.java.doit._13.sec02;

/**
 * 인터페이스를 매개변수로 갖는 메소드가 포함된 클래스 다루는 예제
 */

interface A3 {
    public abstract void abc();
}

// 자식 클래스 생성
class B3 implements A3 {
    public void abc() {
        System.out.println("입력매개변수 전달");
    }
}

class C3 {
    void cde(A3 a) {
        a.abc();
    }
}

public class AnonymousClass_3 {
    public static void main(String[] args) {
        C3 c = new C3();

        // 방법1. 참조변수명을 생성하여 매개변수로 전달
        A3 a = new B3();
        c.cde(a);

        // 방법2. 자식클래스의 생성자를 바로 전달
        c.cde(new B3());
    }
}
