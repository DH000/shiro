package com.shiro.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: Permission
 * @Description: 权限
 * @author xuelin
 * @date Aug 14, 2015 12:58:42 PM
 *
 */
public class Permission implements Serializable {

	private static final long serialVersionUID = 5408305468351014430L;

	private Integer id;
	private String permission;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
