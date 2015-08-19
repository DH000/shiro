package com.shiro.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shiro.dao.RolePermissionDao;
import com.shiro.entity.RolePermission;
import com.shiro.service.RolePermissionService;

@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {
	@Resource
	private RolePermissionDao rolePermissionDao;
	
	@Override
	public void add(Integer permissionId, Integer roleId) {
		if(null == permissionId || null == roleId){
			throw new IllegalArgumentException();
		}
		
		RolePermission rolePermission = new RolePermission(roleId, permissionId);
		rolePermissionDao.save(rolePermission);
	}

	@Override
	public void delete(Integer id) {
		if(null == id){
			throw new IllegalArgumentException("Null id");
		}
		
		rolePermissionDao.delete(id);
	}

	@Override
	public List<RolePermission> findByRole(Integer roleId) {
		if(null == roleId){
			throw new IllegalArgumentException("Null roleId");
		}
		
		return rolePermissionDao.findByRole(roleId);
	}

}
