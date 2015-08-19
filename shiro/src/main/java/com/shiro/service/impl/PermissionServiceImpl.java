package com.shiro.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.shiro.dao.PermissionDao;
import com.shiro.dao.RoleDao;
import com.shiro.entity.Permission;
import com.shiro.entity.Role;
import com.shiro.service.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
	@Resource
	private PermissionDao permissionDao;
	@Resource
	private RoleDao roleDao;

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

	@Override
	public List<Permission> findByUser(Integer userId) {
		if(null == userId){
			throw new IllegalArgumentException("Null userId");
		}
		
		List<Permission> permissions = new ArrayList<Permission>();
		
		// 获取用户角色
		List<Role> roles = roleDao.findByUser(userId);
		for(Role role : roles){
			// 获取权限角色
			permissions.addAll(permissionDao.findByRole(role.getId()));
		}
		
		return permissions;
	}

}






