package com.shiro.service;

import java.util.List;

import com.shiro.entity.RolePermission;

public interface RolePermissionService {

	public void add(Integer permissionId, Integer roleId);
	
	public void delete(Integer id);
	
	public List<RolePermission> findByRole(Integer roleId);
	
}
