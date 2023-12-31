package com.java.doit._16;

// apple 클래스와 apple 클래스를 담을 수 있는 goods1 클래스
class Apple {}
class Goods1 {
    private Apple apple = new Apple();
    // getter
    public Apple getApple() {
        return apple;
    }
    // setter
    public void setApple(Apple apple) {
        this.apple = apple;
    }
}

// pencil 클래스와 pencil 클래스를 담을 수 있는 goods2 클래스. test
class Pencil {}
class Goods2 {
    private Pencil pencil = new Pencil();
    // getter
    public Pencil getPencil() {
        return pencil;
    }
    // setter
    public void setPencil(Pencil pencil) {
        this.pencil = pencil;
    }
}

public class ProblemsBeforeGeneric {
    public static void main(String[] args) {
        // goods1을 이용해 apple 객체를 추가(set)하거나 가져오기(get)
        Goods1 goods1 = new Goods1();
        goods1.setApple(new Apple());   // Apple 타입만 입력 가능
        Apple apple = goods1.getApple();    // Apple 타입 리턴

        // goods2를 이용해 pencil 객체를 추가(set)하거나 가져오기(get)
        Goods2 goods2 = new Goods2();
        goods2.setPencil(new Pencil());
        Pencil pencil = goods2.getPencil();
    }
}
