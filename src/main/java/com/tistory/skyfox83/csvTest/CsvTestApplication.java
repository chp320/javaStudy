package com.tistory.skyfox83.csvTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;

@SpringBootApplication
public class CsvTestApplication {

    public static void doSomething() {

        String filePath = "/Users/leo/study/temp/junlab.csv";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length == 6) {
                    String id = columns[0].trim();
                    String lastName = columns[1].trim();
                    String firstName = columns[2].trim();
                    String position = columns[3].trim();
                    String birthYear = columns[4].trim();
                    String debutYear = columns[5].trim();

                    System.out.println("id= " + id + ", lastName= " + lastName + ", firstName= " + firstName + ", position= " + position + ", birthYear= " + birthYear + ", debutYear= " + debutYear);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {

        SpringApplication.run(CsvTestApplication.class, args);

//        doSomething();
    }
}
