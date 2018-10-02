package com.lxgy.springbootbase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * TODO 程序只加载Application.java所在包及其子包下的内容
 * @author Gryant
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public Object hello(){
        return "hello spring boot";
    }

}
