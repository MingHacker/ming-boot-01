package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello, this is springboot";
    }

    @GetMapping("/user")
    public String getMethod() {
        return "Get Method";
    }

    @PostMapping("/user")
    public String postMethod() {
        return "Post Method";
    }

    @PutMapping("/user")
    public String putMethod() {
        return "Put Method";
    }

    @DeleteMapping("/user")
    public String deleteMethod() {
        return "Delete Method";
    }
}
