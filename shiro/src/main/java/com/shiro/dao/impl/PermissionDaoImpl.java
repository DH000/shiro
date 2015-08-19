package com.shiro.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.shiro.dao.PermissionDao;
import com.shiro.entity.Permission;

@Repository
public class PermissionDaoImpl implements PermissionDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void save(Permission permission) {
		sessionFactory.getCurrentSession().save(permission);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> find() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Permission");
		return query.list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Permission findById(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Permission p where p.id = :id");
		query.setParameter("id", id);
		
		List list = query.list();
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		
		return (Permission) list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> findByRole(Integer roleId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from RolePermission rp left join Permission p on p.id = rp.permissionId where p.roleId = :roleId");
		query.setParameter("roleId", roleId);
		return query.list();
	}

	@Override
	public void delete(Permission permission) {
		sessionFactory.getCurrentSession().delete(permission);
	}

	@Override
	public void delete(Integer id) {
		Permission permission = this.findById(id);
		this.delete(permission);
	}

}
