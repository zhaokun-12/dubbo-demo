package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zhaokun
 * @Date 2020/10/23
 * @Version 1.0
 **/
@RestController
public class PersonController {
    @GetMapping("hello")
    public String hello(){
        System.out.println("sss");
        return "sss";
    }
}
