package com.shiro.dao;

import java.util.List;

import com.shiro.entity.Permission;

public interface PermissionDao {

	public void save(Permission permission);
	
	public List<Permission> find();
	
	public Permission findById(Integer id);
	
	public List<Permission> findByRole(Integer roleId);
	
	public void delete(Permission permission);
	
	public void delete(Integer id);
	
}
