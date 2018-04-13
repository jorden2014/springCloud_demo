package com.example.config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestControl {
    @Value("${environment:}")
    private String val;

    @RequestMapping("/")
    public String test(){
        return val;
    }
}
