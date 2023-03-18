package com.anil.spring.boot.api.config;

import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    @Override
    public Validator getValidator() {
        return new LocalValidatorFactoryBean();
    }
}