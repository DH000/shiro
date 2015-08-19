package com.shiro.dao;

import java.util.List;

import com.shiro.entity.Role;

public interface RoleDao {

	public void save(Role role);
	
	public void delete(Role role);
	
	public void delete(Integer roleId);
	
	public List<Role> find();
	
	public Role findById(Integer id);
	
	public List<Role> findByUser(Integer userId);
	
}
