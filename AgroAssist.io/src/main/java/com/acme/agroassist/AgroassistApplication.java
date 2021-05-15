package com.acme.agroassist;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AgroassistApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgroassistApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {return new ModelMapper();}

}
