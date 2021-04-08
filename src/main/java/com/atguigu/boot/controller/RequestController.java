package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller  // the normal controller's return value is used to switch the page
public class RequestController {
    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg", "success");
        request.setAttribute("code", 200);

        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(HttpServletRequest request,
                                       @RequestAttribute("msg") String msg,
                                       @RequestAttribute("code") Integer code) {
        Map<String, Object> mp = new HashMap<>();

        mp.put("msg", msg);
        mp.put("code", code);
        mp.put("requestMsg", request.getAttribute("msg"));
        mp.put("request", request.toString());

        return mp;
    }
}
