package com.example.beanaoptest.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
public class AccountService {

    public AccountService(){
        System.err.println("init....");
    }


    public String sayHello(String name){
        System.out.println("hi---"+name);
        return "hello -- "+name;
    }

}
