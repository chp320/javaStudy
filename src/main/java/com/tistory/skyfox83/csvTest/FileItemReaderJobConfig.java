package com.tistory.skyfox83.csvTest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class FileItemReaderJobConfig {
    /* 스프링배치에서 Job은 하나의 '배치 작업 단위'를 지칭한다.
       하나의 Job 안에는 여러 Step이 존재하고, Step 안에 Reader, Writer 등이 포함된다.
     */
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CsvReader csvReader;
//    private final CsvWriter csvWriter;

    private static final int chunkSize = 1000;  // 한 번에 처리할 크기

    @Bean
    public Job csvFileItemReaderJob() {
        return jobBuilderFactory.get("csvFileItemReaderJob")
                .start(csvFileItemReaderStep())
                .build()
                ;
    }

    private Step csvFileItemReaderStep() {
        return stepBuilderFactory.get("csvFileItemReaderStep")
                .<Food, Food>chunk(chunkSize)
                .reader(csvReader.csvFileItemReader())
                .build()
                ;
    }
}
