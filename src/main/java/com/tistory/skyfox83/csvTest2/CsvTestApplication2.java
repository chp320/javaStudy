package com.tistory.skyfox83.csvTest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CsvTestApplication2 {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(CsvTestApplication2.class);
        System.out.println("Go!!");

        GoCsv goCsv = new GoCsv("/Users/leo/study/temp/junlab.csv");
        String[] line = null;
        while ((line = goCsv.nextRead()) != null) {
            for (String a : line) {
                System.out.println(a + " ");
            }
            System.out.println();
        }
    }
}
