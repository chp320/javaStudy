package com.java.doit._16;
/* 제너릭 타입 변수 1개를 가진 제너릭 클래스의 선언 및 활용 */

class MyClass<T> {
    private T t;
    public T get() {
        return t;
    }
    public void set(T t) {
        this.t = t;
    }
}

public class SingleGenericArgument {
    public static void main(String[] args) {
        MyClass<String> mc1 = new MyClass<String>();        // String 타입을 저장(set)하거나 꺼내올(get) 수 있는 객체로 지정
        mc1.set("안녕");
        System.out.println(mc1.get());

        MyClass<Integer> mc2 = new MyClass<Integer>();      // Integer 타입을 저장(set)하거나 꺼내올(get) 수 있는 객체로 지정
        mc2.set(100);
        System.out.println(mc2.get());
    }
}
