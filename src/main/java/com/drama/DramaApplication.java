package com.drama;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.drama.dao")
public class DramaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DramaApplication.class, args);
    }

}
