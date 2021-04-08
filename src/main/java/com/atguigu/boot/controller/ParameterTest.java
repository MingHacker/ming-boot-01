package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTest {

    @PostMapping("/saveuser")
    public Person person1(Person person) {
        return person;
    }

    @PostMapping("/saveuser2")
    public Person person2(Person person) {
        return person;
    }

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getParam(@PathVariable("id") String id,
                                        @PathVariable("username") String username,
                                        @PathVariable Map<String, String> pv,
                                        @RequestHeader Map<String, String> header,
                                        @RequestParam("age") Integer age,
                                        @RequestParam("interest") List<String> interests,
                                        @CookieValue("Idea-1c7da80") String cookie,
                                        @CookieValue("Idea-1c7da80") Cookie cookieValue
                                        ){
        Map<String, Object> mp = new HashMap<>();
        mp.put("id", id);
        mp.put("username", username);
        mp.put("pv", pv);
        mp.put("header", header);
        mp.put("age", age);
        mp.put("interests", interests);
        mp.put("cookie", cookie);
        mp.put("cookieValue", cookieValue);
        return mp;
    }

    @PostMapping("/save")
    public Map<String, Object> saveMethod(@RequestBody String rb) {
        Map<String, Object> mp = new HashMap<>();
        mp.put("Body", rb);
        return mp;
    }

    @GetMapping("/empID/{id}/name/{username}")
    public Map<String, Object> matrix(@MatrixVariable(value = "age", pathVar = "id") Integer age1,
                                         @MatrixVariable(value = "age", pathVar = "username") Integer age2) {
        Map<String, Object> mp = new HashMap<>();

        mp.put("age1", age1);
        mp.put("age2", age2);

        return mp;
    }

}
