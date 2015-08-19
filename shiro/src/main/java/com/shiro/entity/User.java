package com.shiro.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: User
 * @Description: 用户
 * @author xuelin
 * @date Aug 14, 2015 12:31:32 PM
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = 3333125274534511730L;
	
	private Integer id;
	private String username;
	private String password;
	private String passwordSalt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
}
