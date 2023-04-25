package com.java.doit._16;

/* 제너릭 클래스에서의 제너릭 타입 제한 범위 설정 */
class A {}
class B extends A {}
class C extends B {}
class D <T extends B> {     // 최상위 클래스를 B로 두고 B 와 그 자식 클래스만을 제너릭 타입으로 제한
    private T t;
    public T get() { return t; }
    public void set(T t) { this.t = t; }
}

public class BoundedTypeOfGenericClass {
    public static void main(String[] args) {
//        D<A> d1 = new D<>();    // 불가능:  not within its bound
    }
}
