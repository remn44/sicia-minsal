package com.minsal.sicia.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

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
		this.userName = "Rene";
		this.userPassword = "Masin";
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
		userlogged.setUserPassword(MD5("Masin"));
		
//		userDao.create(userlogged);
//		userlogged = em.find(userlogged.getClass(), 1);
//		userlogged = null;
//		userlogged = userDao.find(1);
		userlogged = userDao.find(1);
		
		System.out.println(userlogged.getUserName());
		
	}
	
	public void loginShiro() {
		
		UsernamePasswordToken token = new UsernamePasswordToken(this.userName,this.userPassword);
		
		try {
			SecurityUtils.getSubject().login(token);
			System.out.println("Credenciales correctas");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Credenciales incorrectas");
			e.printStackTrace();
		}
		
	}
	
	public String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
	
//	   @RequestMapping(value="/login",method= RequestMethod.POST)
//	    public String login(Model model, @ModelAttribute LoginCommand command, BindingResult errors) {
//	        loginValidator.validate(command, errors);
//
//	        if( errors.hasErrors() ) {
//	            return showLoginForm(model, command);
//	        }
//
//	        UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(), command.getPassword(), command.isRememberMe());
//	        try {
//	            SecurityUtils.getSubject().login(token);
//	        } catch (AuthenticationException e) {
//	            errors.reject( "error.login.generic", "Invalid username or password.  Please try again." );
//	        }
//
//	        if( errors.hasErrors() ) {
//	            return showLoginForm(model, command);
//	        } else {
//	            return "redirect:/s/home";
//	        }
//	    }
//
//	    @RequestMapping("/logout")
//	    public String logout() {
//	        SecurityUtils.getSubject().logout();
//	        return "redirect:/";
//	}
	
	public void firstStep() {
		
		System.out.println(userName + " " + userPassword);
		loginDb();
	}
	
}
