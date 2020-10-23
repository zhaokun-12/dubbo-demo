package com.example.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.entity.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author zhaokun
 * @Date 2020/10/23
 * @Version 1.0
 **/
@RestController
public class PersonController {
//    @Autowired
//    RestTemplate restTemplate;
    @Reference(check = false, timeout = 20000, retries = 0)
    private PersonService personService;

    @GetMapping("person")
    public Person selectOne(){
        System.out.println(personService);
        Person wangwu = personService.insert(new Person().setAge(32).setNameRmai("wangwu"));
        return wangwu;
    }
}
