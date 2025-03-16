package com.teletrader.teletradeproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TeletradeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeletradeProjectApplication.class, args);
    }

}
