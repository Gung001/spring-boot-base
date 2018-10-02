package com.lxgy.springbootbase.controller;

import com.lxgy.springbootbase.pojo.Result;
import com.lxgy.springbootbase.service.IUserService;
import com.lxgy.springbootbase.pojo.SysUser;
import com.lxgy.springbootbase.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author Gryant
 */
@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/saveUser")
	public Result saveUser() throws Exception {
		
		SysUser user = new SysUser();
		user.setId(UuidUtil.get32Uuid());
		user.setUsername("lxgy" + new Date());
		user.setNickname("lxgy" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUser(user);
		
		return Result.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public Result updateUser() {
		
		SysUser user = new SysUser();
		user.setId("1ecc627bc7cf45c686ebbb18aea2e6a8");
		user.setUsername("updateuser" + new Date());
		user.setNickname("updatenickname" + new Date());
		user.setPassword("updatepwd");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.updateUser(user);
		
		return Result.ok("保存成功");
	}
	
	@RequestMapping("/deleteUser")
	public Result deleteUser(String userId) {
		
		userService.deleteUser(userId);
		
		return Result.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public Result queryUserById(String userId) {
		
		return Result.ok(userService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public Result queryUserList() {
		
		SysUser user = new SysUser();
//		user.setUsername("lxgy");
//		user.setNickname("Gryant");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return Result.ok(userList);
	}
	
	@RequestMapping("/queryUserListPaged")
	public Result queryUserListPaged(Integer page) {
		
		if (page == null) {
			page = 1;
		}

		int pageSize = 2;
		
		SysUser user = new SysUser();
//		user.setNickname("Gryant");
		
		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
		
		return Result.ok(userList);
	}
	
	@RequestMapping("/queryUserByIdCustom")
	public Result queryUserByIdCustom(String userId) {
		
		return Result.ok(userService.queryUserByIdCustom(userId));
	}
	
	@RequestMapping("/saveUserTransactional")
	public Result saveUserTransactional() {

		SysUser user = new SysUser();
		user.setId(UuidUtil.get32Uuid());
		user.setUsername("Gryant" + new Date());
		user.setNickname("Gryant" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUserTransactional(user);
		
		return Result.ok("保存成功");
	}
}
