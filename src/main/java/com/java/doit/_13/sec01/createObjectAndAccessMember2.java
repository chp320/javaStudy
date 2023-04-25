package com.java.doit._13.sec01;

class AA {
    // 필드
    int a = 3;
    static int b = 4;

    // 메서드
    void method1() {
        System.out.println("instance method");
    }
    static void method2() {
        System.out.println("static method");
    }

    // 정적 이너 클래스
    static  class B {
        void bcd() {
            // 필드 사용
//            System.out.println(a);  /* 오류 - 정적 이너 클래스는 아우터 클래스의 "정적 멤버"만 사용 가능! */
            System.out.println(b);

            // 메서드 호출
//            method1();      /* 오류 - 정적 이너 클래스는 아우터 클래스의 "정적 멤버"만 사용 가능! */
            method2();
        }
    }
}
public class createObjectAndAccessMember2 {
    public static void main(String[] args) {
        // 정적 이너 클래스의 객체 생성
        AA.B b = new AA.B();

        // 메서드 호출
        b.bcd();
    }
}
