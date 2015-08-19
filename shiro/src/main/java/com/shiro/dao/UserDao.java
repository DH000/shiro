package com.shiro.dao;

import java.util.List;

import com.shiro.entity.User;

public interface UserDao {

	public void save(User user);

	public User findById(Integer id);

	public List<User> find();

}
