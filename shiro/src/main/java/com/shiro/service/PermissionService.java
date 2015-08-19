package com.shiro.service;

import java.util.List;

import com.shiro.entity.Permission;

public interface PermissionService {

	public void add(Permission permission);
	
	public List<Permission> find();
	
	public Permission findById(Integer id);
	
	public List<Permission> findByRole(Integer roleId);
	
	public List<Permission> findByUser(Integer userId);
	
}
