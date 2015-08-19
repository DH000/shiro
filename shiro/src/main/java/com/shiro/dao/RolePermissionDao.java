package com.shiro.dao;

import java.util.List;

import com.shiro.entity.RolePermission;

public interface RolePermissionDao {

	public void save(RolePermission rolePermission);
	
	public RolePermission findById(Integer id);
	
	public List<RolePermission> findByRole(Integer roleId);
	
	public void delete(RolePermission rolePermission);
	
	public void delete(Integer id);
}
