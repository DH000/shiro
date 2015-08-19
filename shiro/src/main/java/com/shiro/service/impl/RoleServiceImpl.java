package com.shiro.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shiro.dao.RoleDao;
import com.shiro.dao.UserRoleDao;
import com.shiro.entity.Role;
import com.shiro.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;
	@Resource
	private UserRoleDao userRoleDao;

	@Override
	public void add(Role role) {
		if(null == role){
			throw new IllegalArgumentException("Null entity");
		}
		
		roleDao.save(role);
	}

	@Override
	public Role findById(Integer id) {
		if(null == id){
			throw new IllegalArgumentException("Null id");
		}
		
		return roleDao.findById(id);
	}

	@Override
	public List<Role> find() {
		return roleDao.find();
	}

	@Override
	public List<Role> findByUser(Integer userId) {
		if(null == userId){
			throw new IllegalArgumentException("Null userId");
		}
		return roleDao.findByUser(userId);
	}
	

}













