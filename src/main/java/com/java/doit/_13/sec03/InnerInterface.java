/**
 * 이너 인터페이스
 * - 특이하게 클래스 내부에 존재하는 인터페이스로 반드시 "정적(static)" 형태로만 존재한다.
 * - 사용 시, "아우터 클래스명.이너 인터페이스명" 의 형태로 사용해야 한다.
 */

package com.java.doit._13.sec03;

class A31 {             // 아우터 클래스
    interface B31 {     // 이너 인터페이스는 자동으로 'static' 지정됨!
        public abstract void bcd();
    }
}

class C31 implements A31.B31 {      // 이너 인터페이스를 구현한 구현 클래스 생성. 객체 타입은 아'우터클래스명.이너인터페이스명' 인 A31.B31 로 표기
    public void bcd() {
        System.out.println("이너 인터페이스 구현 클래스 생성");
    }
}


public class InnerInterface {
    public static void main(String[] args) {
        // 객체 생성 방법 1 (자식 클래스 직접 생성)
//        A31.B31 ab = new C31();
        C31 c = new C31();
        c.bcd();

        // 객체 생성 방법 2 (익명 이너 클래스 생성)
        A31.B31 b = new A31.B31() {
            @Override
            public void bcd() {
                System.out.println("익명 이너 클래스로 객체 생성");
            }
        } ;

        b.bcd();
    }
}
