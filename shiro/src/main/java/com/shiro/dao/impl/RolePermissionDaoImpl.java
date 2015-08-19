package com.shiro.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.shiro.dao.RolePermissionDao;
import com.shiro.entity.RolePermission;

@Repository
public class RolePermissionDaoImpl implements RolePermissionDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void save(RolePermission rolePermission) {
		sessionFactory.getCurrentSession().save(rolePermission);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public RolePermission findById(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from RolePermission rp where rp.id = :id");
		query.setParameter("id", id);
		
		List list = query.list();
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		
		return (RolePermission) list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<RolePermission> findByRole(Integer roleId){
		Query query = sessionFactory.getCurrentSession().createQuery("from RolePermission rp where rp.roleId = :roleId");
		query.setParameter("roleId", roleId);
		return query.list();
	}

	@Override
	public void delete(RolePermission rolePermission) {
		sessionFactory.getCurrentSession().delete(rolePermission);
	}

	@Override
	public void delete(Integer id) {
		RolePermission rolePermission = this.findById(id);
		this.delete(rolePermission);
	}

}
