package com.java.doit._17;

/* ArrayList<E>와 LinkedList<E>의 성능 비교 (데이터 추가/검색/삭제) */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ArrayListVsLinkedList {
    public static void main(String[] args) {

        // 1. 데이터 추가 시간 비교
        List<Integer> aList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        long startTime = 0, endtime = 0;

        // 1-1. ArrayList 데이터 추가 시간
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            aList.add(0, i);
        }
        endtime = System.nanoTime();
        System.out.println("ArrayList 데이터 추가 시간 = " + (endtime - startTime) + " ns");

        // 1-2. LinkedList 데이터 추가 시간
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(0, i);
        }
        endtime = System.nanoTime();
        System.out.println("LinkedList 데이터 추가 시간 = " + (endtime - startTime) + " ns");

        System.out.println("-----------------------------------------------------------");

        // 2-1. ArrayList 데이터 검색(get) 시간
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            aList.get(i);
        }
        endtime = System.nanoTime();
        System.out.println("ArrayList 데이터 검색 시간 = " + (endtime - startTime) + " ns");

        // 2-2. LinkedList 데이터 검색(get) 시간
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.get(i);
        }
        endtime = System.nanoTime();
        System.out.println("LinkedList 데이터 검색 시간 = " + (endtime - startTime) + " ns");

        System.out.println("-----------------------------------------------------------");

        // 3-1. ArrayList 데이터 제거(remove) 시간
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            aList.remove(0);
        }
        endtime = System.nanoTime();
        System.out.println("ArrayList 데이터 제거 시간 = " + (endtime - startTime) + " ns");

        // 3-2. LinkedList 데이터 제거(remove) 시간
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.remove(0);
        }
        endtime = System.nanoTime();
        System.out.println("LinkedList 데이터 제거 시간 = " + (endtime - startTime) + " ns");

        System.out.println("-----------------------------------------------------------");

        // 해시코드 확인
        System.out.println(Objects.hash(1, 2, 3));
        System.out.println(Objects.hash(1, 2, 3));  // 매개변수 값, 순서를 고려해서 고유한 값을 생성 -> 그런데 이렇게 동일하게 들어오면 unique를 보장x ㅠㅠ

        String str1 = "안녕";
        System.out.println(str1.hashCode());
        System.out.println(str1.hashCode());    // '객체'의 해시코드값을 리턴하는 hashCode() 메서드도.. 동일 값에 대해선 동일 코드값을 주네 ㅠㅠ


    }
}
