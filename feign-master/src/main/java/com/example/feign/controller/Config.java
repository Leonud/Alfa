package com.example.feign.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    public Config(){}

    @Value("${valuta.name}")
    private String secretName;

    public String getValutaName(){
        return secretName;
    }
}