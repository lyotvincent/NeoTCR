package com.xwt.browse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.xwt.browse.mapper")
@SpringBootApplication
public class ServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(ServiceApplication.class,args);
    }
}
