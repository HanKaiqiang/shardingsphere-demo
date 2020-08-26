package com.shardingsphere.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(basePackages = "com.shardingsphere.demo.repository")
@SpringBootApplication
public class DemoApplication {

    public static void main(final String[] args){
        SpringApplication.run(DemoApplication.class, args);
    }
}
