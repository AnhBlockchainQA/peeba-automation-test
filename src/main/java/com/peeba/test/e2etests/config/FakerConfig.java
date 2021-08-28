package com.peeba.test.e2etests.config;

import com.github.javafaker.Faker;
import com.peeba.test.e2etests.annotations.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker() {
        return new Faker();
    }

}
