package com.person.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {


    @RequestMapping(value = "/referPerson" ,method = RequestMethod.GET)
    public String  referPerson(){
        System.out.println("i am jack");
        return "success";
    }


}
