package com.meorient.appserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.meorient.appserver.mapper"})
public class AppserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppserverApplication.class, args);
    }

}
