package com.shiro.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.shiro.dao.UserRoleDao;
import com.shiro.entity.UserRole;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void save(UserRole userRole) {
		sessionFactory.getCurrentSession().save(userRole);
	}

	@Override
	public void delete(UserRole userRole) {
		sessionFactory.getCurrentSession().delete(userRole);
	}

	@Override
	public void delete(Integer id) {
		UserRole userRole = this.findById(id);
		this.delete(userRole);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserRole> findByUser(Integer userId){
		Query query = sessionFactory.getCurrentSession().createQuery("from UserRole ur where ur.userId = :userId");
		query.setParameter("userId", userId);
		return query.list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public UserRole findById(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from UserRole ur where ur.id = :id");
		query.setParameter("id", id);
		
		List list = query.list();
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		
		return (UserRole) list.get(0);
	}
	
	@SuppressWarnings("rawtypes")
	public UserRole findByUserAndRole(Integer userId, Integer roleId){
		Query query = sessionFactory.getCurrentSession().createQuery("from UserRole ur where ur.userId = :userId and ur.roleId = :roleId");
		query.setParameter("userId", userId);
		query.setParameter("roleId", roleId);
		
		List list = query.list();
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		
		return (UserRole) list.get(0);
	}

}
