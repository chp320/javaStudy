package com.java.doit._17;

// 배열과 리스트의 비교

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayVsList {
    public static void main(String[] args) {

        // 배열
        String[] array = new String[]{"가", "나", "다", "라", "마", "바", "사"};
        System.out.println(array.length);

        array[2] = null;
        array[5] = null;
        System.out.println(array.length);   // 2, 5번 인덱스의 데이터를 null하여도 크기는 변동 없다.
        System.out.println(Arrays.toString(array));
        System.out.println();

        // 리스트
        List<String> aList = new ArrayList<>();
        System.out.println(aList.size());

        aList.add("가");
        aList.add("나");
        aList.add("다");
        aList.add("라");
        aList.add("마");
        aList.add("바");
        aList.add("사");
        System.out.println(aList.size());
        aList.remove("다");
        aList.remove("바");
        System.out.println(aList.size());
        System.out.println(aList);
    }
}
