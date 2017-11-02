package com.xz.drip.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by MABIAO on 2017/10/25.
 */

@SpringBootApplication
@ImportResource("classpath*:spring/applicationContext.xml")
@PropertySource("classpath:env/app.properties")
public class BootApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootApplication.class, args);
    }

}
