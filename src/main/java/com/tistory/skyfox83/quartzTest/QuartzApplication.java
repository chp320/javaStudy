package com.tistory.skyfox83.quartzTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuartzApplication {

    @SuppressWarnings("unused")
    @Autowired
    private JobConfig scheduler;

    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class, args);
    }
}

/**
 * (참고)
 * https://bedmil.tistory.com/8
 * https://blog.advenoh.pe.kr/spring/Quartz-Job-Scheduler란/
 * https://pingfanzhilu.tistory.com/entry/Spring-스프링-부트Spring-Boot-Quartz-Scheduler-사용법
 * https://velog.io/@park2348190/Spring-Boot-환경의-Quartz-Scheduler-활용#scheduler
 *
 */