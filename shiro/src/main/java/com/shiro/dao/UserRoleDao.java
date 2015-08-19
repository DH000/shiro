package com.shiro.dao;

import java.util.List;

import com.shiro.entity.UserRole;

public interface UserRoleDao {

	public void save(UserRole userRole);
	
	public void delete(UserRole userRole);
	
	public void delete(Integer id);
	
	public List<UserRole> findByUser(Integer userId);
	
	public UserRole findById(Integer id);
	
	public UserRole findByUserAndRole(Integer userId, Integer roleId);
	
}
