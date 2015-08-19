package com.shiro.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.shiro.dao.RoleDao;
import com.shiro.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void save(Role role) {
		sessionFactory.getCurrentSession().save(role);
	}

	@Override
	public void delete(Role role) {
		sessionFactory.getCurrentSession().delete(role);
	}

	@Override
	public void delete(Integer roleId) {
		Role role = this.findById(roleId);
		this.delete(role);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> find() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		return query.list();
	}
	
	@SuppressWarnings("rawtypes")
	public Role findById(Integer id){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User u where u.id = :id");
		query.setParameter("id", id);
		
		List list = query.list();
		
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		
		return (Role) list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findByUser(Integer userId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select r.* from UserRole ur left join Role r on r.id = ur.roleId where ur.userId = :userId");
		query.setParameter("userId", userId);
		query.setEntity("r", Role.class);
		
		return query.list();
	}
	
}
