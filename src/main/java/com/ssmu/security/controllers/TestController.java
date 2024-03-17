package com.ssmu.security.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api_v1/test")
public class TestController {

     @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test() {
        return "test ok";
    }
    
}
