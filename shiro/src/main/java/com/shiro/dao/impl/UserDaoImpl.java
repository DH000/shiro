package com.shiro.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.shiro.dao.UserDao;
import com.shiro.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
	
	@SuppressWarnings("rawtypes")
	public User findById(Integer id){
		Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.id = :id");
		query.setParameter("id", id);
		
		List list = query.list();
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		
		return (User) list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<User> find(){
		Query query = sessionFactory.getCurrentSession().createQuery("from User");
		return query.list();
	}

}
