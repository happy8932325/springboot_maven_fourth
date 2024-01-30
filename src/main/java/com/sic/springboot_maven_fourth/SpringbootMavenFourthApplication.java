package com.sic.springboot_maven_fourth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootMavenFourthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMavenFourthApplication.class, args);
    }

}
