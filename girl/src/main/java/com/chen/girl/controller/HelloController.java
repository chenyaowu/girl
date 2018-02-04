package com.chen.girl.controller;

import com.chen.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    @GetMapping("hi")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId){
        return girlProperties.getCupSize()+girlProperties.getAge()+myId;
    }
}
