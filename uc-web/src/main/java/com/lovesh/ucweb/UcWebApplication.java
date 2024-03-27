package com.lovesh.ucweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@MapperScan("com.lovesh.ucweb.dao")
@PropertySource(value = "classpath:/config/mode.properties")
public class UcWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(UcWebApplication.class, args);
    }

}
