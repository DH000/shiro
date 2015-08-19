package com.shiro.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class ShiroLoginTest {

	@Test
	public void loginTest(){
		
		// 初始化
		Factory<SecurityManager> factory = new IniSecurityManagerFactory();
		
		// 获取SecurityManager
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		// 获取subject
		Subject subject = SecurityUtils.getSubject();
		
		// token
		UsernamePasswordToken token = new UsernamePasswordToken("hello1", "123");
		
		// 登录
		subject.login(token);
		
		Assert.assertEquals(true, subject.isAuthenticated());
		
		// 退出
		subject.logout();
	}
	
}
