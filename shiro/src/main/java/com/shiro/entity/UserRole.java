package com.shiro.entity;

import java.io.Serializable;

/**
 * 
 * 
 * @ClassName: UserRole
 * @Description: 用户角色
 * @author xuelin
 * @date Aug 14, 2015 12:33:09 PM
 *
 */
public class UserRole implements Serializable {

	private static final long serialVersionUID = -1295143297172939825L;

	private Integer id;
	private Integer userId;
	private Integer roleId;
	
	public UserRole() {
		super();
	}

	public UserRole(Integer userId, Integer roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
