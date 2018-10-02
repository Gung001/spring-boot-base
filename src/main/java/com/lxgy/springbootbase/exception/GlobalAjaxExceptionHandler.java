package com.lxgy.springbootbase.exception;

import com.lxgy.springbootbase.pojo.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @description 返回错误内容（json格式）
 * @author Gryant
 */
//@RestControllerAdvice
public class GlobalAjaxExceptionHandler {

//	@ExceptionHandler(value = Exception.class)
	public Result defaultErrorHandler(HttpServletRequest req,
                                      Exception e) throws Exception {

		e.printStackTrace();

		return Result.errorException(e.getMessage());
	}
}
