package com.shiro.service;

import java.util.List;

import com.shiro.entity.Role;

public interface RoleService {

	public void add(Role role);
	
	public Role findById(Integer id);
	
	public List<Role> find();
	
	public List<Role> findByUser(Integer userId);
	
}
