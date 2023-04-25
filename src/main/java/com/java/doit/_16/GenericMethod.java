package com.java.doit._16;

// 일반 클래스 안에 제너릭 메서드 3개 존재
class GenericMethods {
    public <T> T method1(T t) {
        return t;
    }

    public <T> boolean method2(T t1, T t2) {
        return t1.equals(t2);
    }

    public <K, V> void method3(K k, V v) {
        System.out.println(k + ":" + v);
    }
}

public class GenericMethod {
    public static void main(String[] args) {

        GenericMethods gm = new GenericMethods();

        String str1 = gm.<String>method1("안녕");
        String str2 = gm.method1("안녕");     // 매개변수에 String 타입이 대입되어 있고, 이를 통해 '제너릭 타입 변수의 실제 타입 예측 가능'하기 때문에 '제너릭 타입 변수' 생략 가능
        System.out.println(str1);
        System.out.println(str2);

        boolean bool1 = gm.<Double>method2(2.5, 2.5);
        boolean bool2 = gm.method2(2.5, 2.5);
        System.out.println(bool1);
        System.out.println(bool2);

        gm.<String, Integer>method3("국어", 80);
        gm.method3("국어", 80);
    }
}
