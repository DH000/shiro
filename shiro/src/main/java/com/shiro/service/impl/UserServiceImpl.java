package com.shiro.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shiro.dao.UserDao;
import com.shiro.entity.User;
import com.shiro.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public void create(User user) {
		if(null == user){
			throw new IllegalArgumentException("Null entity");
		}
		
		userDao.save(user);
	}

	@Override
	public User findById(Integer id) {
		if(null == id){
			throw new IllegalArgumentException("Null id");
		}
		return userDao.findById(id);
	}

	@Override
	public List<User> find() {
		return userDao.find();
	}

}
