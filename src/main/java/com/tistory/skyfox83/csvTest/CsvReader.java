package com.tistory.skyfox83.csvTest;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@RequiredArgsConstructor
public class CsvReader {

    @Bean
    public FlatFileItemReader<Food> csvFileItemReader() {
        // file read
        FlatFileItemReader<Food> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new ClassPathResource("/Users/leo/study/temp/food.csv"));
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setEncoding("UTF-8");

        DefaultLineMapper<Food> defaultLineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer(",");
        delimitedLineTokenizer.setNames("id", "name");
        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

        BeanWrapperFieldSetMapper<Food> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(Food.class);

        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        flatFileItemReader.setLineMapper(defaultLineMapper);

        return flatFileItemReader;
    }
}
