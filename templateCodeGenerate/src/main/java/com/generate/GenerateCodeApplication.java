package com.generate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
@SpringBootApplication
@MapperScan(basePackages = "com.generate.dao")
public class GenerateCodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(GenerateCodeApplication.class, args);
    }
}
