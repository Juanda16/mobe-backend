package com.ssmu.security.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api_v1/test")
public class TestController {

     @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Map<String, String>> test() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "server is up and running");
        return ResponseEntity.ok(response);
    }
    
}
