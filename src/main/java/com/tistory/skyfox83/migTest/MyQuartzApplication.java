package com.tistory.skyfox83.migTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyQuartzApplication {

    @SuppressWarnings("unused")
    @Autowired
    private MyJobConfig scheduler;

    public static void main(String[] args) {
        SpringApplication.run(MyQuartzApplication.class, args);
    }
}
