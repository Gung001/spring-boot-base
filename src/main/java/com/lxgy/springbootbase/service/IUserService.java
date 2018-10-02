package com.lxgy.springbootbase.service;

import com.lxgy.springbootbase.pojo.SysUser;

import java.util.List;

/**
 * @author Gryant
 */
public interface IUserService {

	public void saveUser(SysUser user) throws Exception;

	public void updateUser(SysUser user);

	public void deleteUser(String userId);

	public SysUser queryUserById(String userId);

	public List<SysUser> queryUserList(SysUser user);

	public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize);

	public SysUser queryUserByIdCustom(String userId);
	
	public void saveUserTransactional(SysUser user);
}
