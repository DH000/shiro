package com.shiro.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shiro.dao.UserRoleDao;
import com.shiro.entity.UserRole;
import com.shiro.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
	@Resource
	private UserRoleDao userRoleDao;

	@Override
	public void add(Integer userId, Integer roleId) {
		if(null == userId || null == roleId){
			throw new IllegalArgumentException();
		}
		
		UserRole userRole = new UserRole(userId, roleId);
		userRoleDao.save(userRole);
	}

	@Override
	public void delete(Integer id) {
		if(null == id){
			throw new IllegalArgumentException("Null id");
		}
		
		userRoleDao.delete(id);
	}
	
	public List<UserRole> findByUser(Integer userId){
		if(null == userId){
			throw new IllegalArgumentException("Null userId");
		}
		
		return userRoleDao.findByUser(userId);
	}
}
