package com.peeba.test.e2etests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class E2eTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(E2eTestsApplication.class, args);
    }

}
