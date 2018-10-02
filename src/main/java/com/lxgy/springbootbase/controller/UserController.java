package com.lxgy.springbootbase.controller;

import com.lxgy.springbootbase.pojo.Result;
import com.lxgy.springbootbase.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gryant
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    Resource resource;

    @RequestMapping("/get")
    public Result get(){

        // 测试返回用户信息
//        User user = new User();
//        user.setAge(30);
//        user.setBirthday(new Date());
//        user.setName("Gryant-dev-tool");
//        user.setDesc(null);
//        user.setPassword("123456y34将24链接2镂空九连接2里街路口监控");

        // 测试返回资源文件
        Resource res = new Resource();
        BeanUtils.copyProperties(resource, res);

        return Result.ok(res);
    }

}
