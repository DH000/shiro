package com.shiro.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: Permission
 * @Description: 角色权限
 * @author xuelin
 * @date Aug 14, 2015 12:36:41 PM
 *
 */
public class RolePermission implements Serializable {

	private static final long serialVersionUID = 5408305468351014430L;

	private Integer id;
	private Integer roleId;
	private Integer permissionId;
	
	public RolePermission() {
		super();
	}
	
	public RolePermission(Integer roleId, Integer permissionId) {
		super();
		this.roleId = roleId;
		this.permissionId = permissionId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
}
