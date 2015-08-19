package com.shiro.service;

import java.util.List;

import com.shiro.entity.UserRole;

public interface UserRoleService {

	public void add(Integer userId, Integer roleId);

	public void delete(Integer id);
	
	public List<UserRole> findByUser(Integer userId);
	
}
