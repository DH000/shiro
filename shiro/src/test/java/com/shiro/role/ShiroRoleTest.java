package com.shiro.role;

import java.util.Arrays;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

import com.shiro.ShiroBaseTest;

public class ShiroRoleTest extends ShiroBaseTest {

	@Test
	public void hasRoleTest() {
		login("classpath:role/shiro-role.ini", "hello1", "123");
		// 判断拥有角色：role1
		Assert.assertTrue(getSubject().hasRole(ROLE_1));
		// 判断拥有角色：role1 and role2
		Assert.assertTrue(getSubject().hasAllRoles(Arrays.asList(ROLE_1, ROLE_2)));
		// 判断拥有角色：role1 and role2 and !role3
		boolean[] result = getSubject().hasRoles(Arrays.asList(ROLE_1, ROLE_2, ROLE_3));
		Assert.assertEquals(true, result[0]);
		Assert.assertEquals(true, result[1]);
		Assert.assertEquals(false, result[2]);
	}

	@Test(expected = UnauthorizedException.class)
	public void testCheckRole() {
		login("classpath:role/shiro-role.ini", "hello", "123");
		// 断言拥有角色：role1
		getSubject().checkRole(ROLE_1);
		// 断言拥有角色：role1 and role3 失败抛出异常
		getSubject().checkRoles(ROLE_1, ROLE_3);
	}

	@Test
	public void testIsPermitted() {
		login("classpath:role/shiro-permission.ini", "hello", "123");
		// 判断拥有权限：user:create
		Assert.assertTrue(getSubject().isPermitted("user:create"));
		// 判断拥有权限：user:update and user:delete
		Assert.assertTrue(getSubject().isPermittedAll("user:update", "user:delete"));
		// 判断没有权限：user:view
		Assert.assertFalse(getSubject().isPermitted("user:view"));
	}

	@Test(expected = UnauthorizedException.class)
	public void testCheckPermission() {
		login("classpath:role/shiro-permission.ini", "hello", "123");
		// 断言拥有权限：user:create
		getSubject().checkPermission("user:create");
		// 断言拥有权限：user:delete and user:update
		getSubject().checkPermissions("user:delete", "user:update");
		// 断言拥有权限：user:view 失败抛出异常
		getSubject().checkPermissions("user:view");
	}
}
