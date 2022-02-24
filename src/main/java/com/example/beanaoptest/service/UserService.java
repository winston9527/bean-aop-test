package com.example.beanaoptest.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String sayHello(String name){
        System.out.println("hi---"+name);
        return "hello -- "+name;
    }

}
