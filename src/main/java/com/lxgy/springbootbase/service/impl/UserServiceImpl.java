package com.lxgy.springbootbase.service.impl;

import com.github.pagehelper.PageHelper;
import com.lxgy.springbootbase.mapper.SysUserMapper;
import com.lxgy.springbootbase.mapper.SysUserMapperCustom;
import com.lxgy.springbootbase.pojo.SysUser;
import com.lxgy.springbootbase.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Gryant
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private SysUserMapperCustom sysUserMapperCustom;

	@Override
	public void saveUser(SysUser user) throws Exception {

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		sysUserMapper.insert(user);
	}

	@Override
	public void updateUser(SysUser user) {
//		userMapper.updateByPrimaryKeySelective(user);
		sysUserMapper.updateByPrimaryKey(user);
	}

	@Override
	public void deleteUser(String userId) {
		sysUserMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public SysUser queryUserById(String userId) {

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return sysUserMapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<SysUser> queryUserList(SysUser user) {

		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Example example = new Example(SysUser.class);
		Example.Criteria criteria = example.createCriteria();

		if (!StringUtils.isEmptyOrWhitespace(user.getUsername())) {
//			criteria.andEqualTo("username", user.getUsername());
			criteria.andLike("username", "%" + user.getUsername() + "%");
		}

		if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
			criteria.andLike("nickname", "%" + user.getNickname() + "%");
		}

		List<SysUser> userList = sysUserMapper.selectByExample(example);

		return userList;
	}

	@Override
	public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
		// 开始分页
        PageHelper.startPage(page, pageSize);

		Example example = new Example(SysUser.class);
		Example.Criteria criteria = example.createCriteria();

		if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
			criteria.andLike("nickname", "%" + user.getNickname() + "%");
		}
		example.orderBy("registTime").desc();
		List<SysUser> userList = sysUserMapper.selectByExample(example);

		return userList;
	}

	@Override
	public SysUser queryUserByIdCustom(String userId) {

		List<SysUser> userList = sysUserMapperCustom.queryUserSimplyInfoById(userId);

		if (userList != null && !userList.isEmpty()) {
			return (SysUser)userList.get(0);
		}

		return null;
	}

	@Override
	public void saveUserTransactional(SysUser user) {

		sysUserMapper.insert(user);

		int a = 1 / 0;

		user.setIsDelete(1);
		sysUserMapper.updateByPrimaryKeySelective(user);
	}
}
