package com.baekjoon.datastructure;

import java.util.Scanner;

public class p11720 {
    public static void main(String[] args) {
        // 숫자 갯수 N 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();       // 숫자 갯수

        // 입력값을 String형 변수에 저장 후, char[]형 변수로 변환
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();

        // 총 합
        int sum = 0;
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0';
        }
        System.out.print(sum);
    }
}
