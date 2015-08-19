package com.shiro.service;

import java.util.List;

import com.shiro.entity.User;

public interface UserService {
	
	public void create(User user);
	
	public User findById(Integer id);
	
	public List<User> find();
	
}
