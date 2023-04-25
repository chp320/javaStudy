package com.baekjoon.datastructure;

import java.util.Scanner;

public class p1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 과목 갯수 입력
        int N = sc.nextInt();

        // 각 과목 점수 입력을 위한 배열 생성
        int A[] = new int[N];
        // 입력한 숫자를 각 배열에 저장
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
//            System.out.println(A[i]);
        }

        long sum = 0, max = 0;  // 총합, 최댓값 저장
        for (int i = 0; i < N; i++) {
            if(A[i]>max) max = A[i];
            sum = sum + A[i];
        }

        // 한 과목과 관련된 수식을 총합한 후 관련된 수식으로 변환해 로직이 간단해짐
        System.out.println(sum * 100.0 / max / N);
    }
}
