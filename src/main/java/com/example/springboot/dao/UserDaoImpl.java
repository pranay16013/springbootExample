package com.example.springboot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springboot.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<User> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User").list();
		return userList;
	}

	@Override
	public User getUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	@Override
	public User addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
		return user;
	}

	@Override
	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);

	}

	@Override
	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = session.load(User.class, new Integer(id));
		if (null != u) {
			session.delete(u);
		}

	}

}
