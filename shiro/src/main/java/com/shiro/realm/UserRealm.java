package com.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.shiro.entity.Permission;
import com.shiro.entity.Role;
import com.shiro.entity.User;
import com.shiro.service.PermissionService;
import com.shiro.service.RoleService;
import com.shiro.util.Collections3;
import com.shiro.util.SpringContextUtils;

public class UserRealm extends AuthenticatingRealm {
	
	@Override
	protected Object getAuthenticationCacheKey(PrincipalCollection principals) {
		User user = (User)principals.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		// 取权限
		RoleService roleService = SpringContextUtils.getBean("roleService", RoleService.class);
		List<Role> roles = roleService.findByUser(user.getId());
		authorizationInfo.setRoles(Collections3.extractToSet(roles, "name", String.class));
		
		// 取权限
		List<Permission> permissions = new ArrayList<Permission>();
		PermissionService permissionService = SpringContextUtils.getBean("permissionService", PermissionService.class);
		for(Role role : roles){
			permissions.addAll(permissionService.findByRole(role.getId()));
		}
		authorizationInfo.setStringPermissions(Collections3.extractToSet(permissions, "permission", String.class));
		
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		return null;
	}

}
