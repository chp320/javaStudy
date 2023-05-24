package com.tistory.skyfox83.migTest;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class MyController extends QuartzJobBean {

    private static final Logger log = LoggerFactory.getLogger(MyController.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("마이그레이션 작업 시작");
    }
}
