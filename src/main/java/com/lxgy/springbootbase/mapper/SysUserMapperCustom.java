package com.lxgy.springbootbase.mapper;

import com.lxgy.springbootbase.pojo.SysUser;

import java.util.List;

/**
 * @author Gryant
 */
public interface SysUserMapperCustom {

	/**
	 * @param id
	 * @return
	 */
	List<SysUser> queryUserSimplyInfoById(String id);
}