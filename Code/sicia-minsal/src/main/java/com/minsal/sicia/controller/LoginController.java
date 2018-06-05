package com.minsal.sicia.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import com.minsal.sicia.dao.UserDao;
import com.minsal.sicia.dto.User;
import com.minsal.sicia.resolver.SiciaResolver;

@ManagedBean(name="loginController")
@ViewScoped
public class LoginController implements Serializable{
	
	public LoginController (){
	   }
	
	private static final long serialVersionUID = 1L;
	private User userlogged = new User();
//	private EntityManager em;
	
	@ManagedProperty(value="#{userDao}")
	private UserDao userDao;
	
	//Datos a ingresar
	private String userName;
	private String userPassword;
	
	@PostConstruct
	private void onload() {
		this.userName = "Algo";
		this.userPassword = "hola";
	}
	
	public User getUserlogged() {
		return userlogged;
	}
	public void setUserlogged(User userlogged) {
		this.userlogged = userlogged;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	public void loginDb() {
		
		EntityManager em = SiciaResolver.getInstance().getEntityManagerFactory().createEntityManager();
		
		userlogged.setUserName("Rene");
		userlogged.setUserPassword("Masin");
		
//		userlogged = em.find(userlogged.getClass(), 1);
//		userlogged = null;
//		userlogged = userDao.find(1);
		userDao.create(userlogged);
		
		System.out.println(userlogged.getUserName());
		
	}
	
	public void firstStep() {
		
		System.out.println(userName + " " + userPassword);
		loginDb();
	}
	
}
