package com.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.shiro.entity.User;
import com.shiro.service.PermissionService;
import com.shiro.service.RoleService;
import com.shiro.util.SpringContextUtils;

public class UserRealm extends AuthenticatingRealm {
	
	@Override
	protected Object getAuthenticationCacheKey(PrincipalCollection principals) {
		User user = (User)principals.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		// 取权限
		RoleService roleService = SpringContextUtils.getBean("roleService", RoleService.class);
		authorizationInfo.setRoles(roleService.getRolesByUser(user.getId()));
		
		// 取权限
		PermissionService permissionService = SpringContextUtils.getBean("permissionService", PermissionService.class);
//		authorizationInfo.setStringPermissions(userService.findPermissions(username));
		
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		return null;
	}

}
