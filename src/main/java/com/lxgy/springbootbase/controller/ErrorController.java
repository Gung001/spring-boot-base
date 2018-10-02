package com.lxgy.springbootbase.controller;

import com.lxgy.springbootbase.pojo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("err")
public class ErrorController {

	@RequestMapping("/error")
	public String error() {
		
		int a = 1 / 0;
		
		return "thymeleaf/error";
	}
	
	@RequestMapping("/ajaxerror")
	public String ajaxerror() {
		
		return "thymeleaf/ajaxerror";
	}
	
	@RequestMapping("/getAjaxerror")
	@ResponseBody
	public Result getAjaxerror() {
		
		int a = 1 / 0;
		
		return Result.ok();
	}
}