package com.tistory.skyfox83.csvTest;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CsvWriter implements ItemWriter<Food> {

    @Override
    public void write(List<? extends Food> list) throws Exception {
        System.out.println(list);
    }
}
