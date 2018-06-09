package com.minsal.sicia.dao;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.minsal.sicia.dto.User;

@ManagedBean(name="userDao")
@ViewScoped
public class UserDao extends AbstractDao<User> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDao() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}
	
}
