package com.lyx.springbootbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lyx.springbootbackend.mapper")
public class SpringBootBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBackendApplication.class, args);
    }

}
