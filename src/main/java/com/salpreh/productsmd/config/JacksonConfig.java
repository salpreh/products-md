package com.salpreh.productsmd.config;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
        return builder -> builder.serializationInclusion(JsonInclude.Include.ALWAYS);
    }
}
