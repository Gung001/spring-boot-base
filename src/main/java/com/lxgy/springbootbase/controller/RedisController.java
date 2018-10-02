package com.lxgy.springbootbase.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lxgy.springbootbase.pojo.Result;
import com.lxgy.springbootbase.pojo.User;
import com.lxgy.springbootbase.redis.RedisOperator;
import com.lxgy.springbootbase.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Gryant
 */
@RestController
@RequestMapping("redis")
public class RedisController {
	
	@Autowired
	private RedisOperator redisOperator;

	@RequestMapping("/test")
	public Result test() {

		SysUser user = new SysUser();
		user.setId("100111");
		user.setUsername("Gryant");
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		redisOperator.set("json:user", JSON.toJSONString(user));

		SysUser jsonUser = JSON.parseObject(redisOperator.get("json:user"), SysUser.class);

		return Result.ok(jsonUser);
	}
	
	@RequestMapping("/getJsonList")
	public Result getJsonList() {
		
		User user = new User();
		user.setAge(18);
		user.setName("Mornica");
		user.setPassword("123456");
		user.setBirthday(new Date());
		
		User u1 = new User();
		u1.setAge(19);
		u1.setName("Gryant");
		u1.setPassword("123456");
		u1.setBirthday(new Date());
		
		User u2 = new User();
		u2.setAge(17);
		u2.setName("hello Gryant");
		u2.setPassword("123456");
		u2.setBirthday(new Date());
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(u1);
		userList.add(u2);
		
		redisOperator.set("json:info:userlist", JSON.toJSONString(userList));
		
		String userListJson = redisOperator.get("json:info:userlist");
		List<User> users = JSONObject.parseArray(userListJson, User.class);

		return Result.ok(users);
	}
}