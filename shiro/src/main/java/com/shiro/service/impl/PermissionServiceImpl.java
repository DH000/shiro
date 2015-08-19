package com.shiro.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shiro.dao.PermissionDao;
import com.shiro.entity.Permission;
import com.shiro.service.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
	@Resource
	private PermissionDao permissionDao;

	@Override
	public void add(Permission permission) {
		if(null == permission){
			throw new IllegalArgumentException("Null entity");
		}
		
		permissionDao.save(permission);
	}

	@Override
	public List<Permission> find() {
		return permissionDao.find();
	}

	@Override
	public Permission findById(Integer id) {
		if(null == id){
			throw new IllegalArgumentException("Null id");
		}
		return permissionDao.findById(id);
	}

	@Override
	public List<Permission> findByRole(Integer roleId) {
		if(null == roleId){
			throw new IllegalArgumentException("Null roleId");
		}
		return permissionDao.findByRole(roleId);
	}

}
