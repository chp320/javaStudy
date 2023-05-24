package com.tistory.skyfox83.migTest;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static org.quartz.JobBuilder.newJob;

@Configuration
public class MyJobConfig {

    @Autowired
    private Scheduler scheduler;    // 쿼츠 스케줄 객체

    @PostConstruct
    public void run() {
        JobDetail detail = runJobDetail(MyController.class, new HashMap<>());

        try {
            // 크론 형식 지정 스케줄 시작
//            scheduler.scheduleJob(detail, runJobTrigger("0/10 * * * * ?"));     // 예시. 10초 주기 수행
            scheduler.scheduleJob(detail, runJobTrigger("* * * * * ?"));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public Trigger runJobTrigger(String scheduleExp) {
        // 크론 스케줄 사용
        return TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(scheduleExp)).build();
    }

    private JobDetail runJobDetail(Class job, Map params) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.putAll(params);

        // 스케줄 생성
        return newJob(job).usingJobData(jobDataMap).build();
    }
}
