package com.example.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.entity.Person;
import com.example.service.PersonService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "desc of class")
public class PersonController {
//    @Autowired
//    RestTemplate restTemplate;
    @Reference(check = false, timeout = 20000, retries = 0)
    private PersonService personService;

    @GetMapping("person")
    @ApiOperation(value = "desc of method", notes = "123")
    @HystrixCommand(fallbackMethod = "hello")
    public Person selectOne(){
        Person wangwu = personService.insert(new Person().setAge(32).setNameRmai("wangwu"));
        return wangwu;
    }

    public Person hello(){
        Person person = new Person();
        person.setId(-1).setAge(12).setNameRmai("降级处理");
        return person;
    }
}
