/**
 * 지역 이너 클래스 - 클래스의 멤버가 아닌 '메서드' 내에서 정의되는 클래스
 */

package com.java.doit._13.sec01;

class AAA {
    int a = 3;  // 필드
    void abc() {
        final int b = 5;  // 지역 변수

        // 지역 이너 클래스
        class B {
            void bcd() {
                System.out.println(a);
                System.out.println(b);
                a = 5;
//                b = 7;  // 지역 이너 클래스에서 사용하는 '지역 변수'는 final 로 선언어되어 함

                System.out.println(a);
                System.out.println(b);
            }
        }
        B bb = new B();
        bb.bcd();

    }
}

public class AccessMemberAndLocalVariable {
    public static void main(String[] args) {
        // 객체 생성 및 메서드 호출
        AAA a = new AAA();
        a.abc();
    }
}
