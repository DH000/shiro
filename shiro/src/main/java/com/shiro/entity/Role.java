package com.shiro.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: Role
 * @Description: 角色
 * @author xuelin
 * @date Aug 14, 2015 12:35:38 PM
 *
 */
public class Role implements Serializable {
	private static final long serialVersionUID = 8059205761625009464L;

	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
