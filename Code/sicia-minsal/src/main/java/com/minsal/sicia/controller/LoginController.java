package com.minsal.sicia.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;

import com.minsal.sicia.dto.GlbUsuario;
import com.minsal.sicia.resolver.SiciaResolver;
import com.minsal.sicia.utils.JsfMessages;

@ManagedBean(name="loginController")
@SessionScoped
public class LoginController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public LoginController (){
	   }
	//Datos a ingresar
	private String userName;
	private String userPassword;
	private GlbUsuario userlogged = new GlbUsuario();
	
    public EntityManager getEm() {
		return SiciaResolver.getInstance().getEntityManagerFactory().createEntityManager();
	}

	@PostConstruct
	private void onload() {
		this.userName = "";
		this.userPassword = "";
	}
	
	public GlbUsuario getUserlogged() {
		return userlogged;
	}
	public void setUserlogged(GlbUsuario userlogged) {
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
	
	
	public String loginShiro() {
		
		UsernamePasswordToken token = new UsernamePasswordToken(this.userName,this.userPassword);
		
		FacesContext fContext = FacesContext.getCurrentInstance();
		fContext.getExternalContext().getFlash().setKeepMessages(true);
		
		try {
			SecurityUtils.getSubject().login(token);
			userlogged = getUser(this.userName);
			JsfMessages.addSuccess("Bienvenido "+ userlogged.getDsNombre());
			return "/dashboard.xhtml?faces-redirect=true";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			JsfMessages.addError("Credenciales incorrectas.");
		}catch(Exception e) {
			JsfMessages.addFatal("Error inesperado, informe al técnico mas cercano.");
		}
		return "/login.xhtml?faces-redirect=true";
	}
	
	public String logout() {
		SecurityUtils.getSubject().logout();
        return "/login.xhtml?faces-redirect=true";
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
		    	e.printStackTrace();
		    }
		    return null;
		}
	
	
    public GlbUsuario getUser(String userName) {
    	EntityManager em =  getEm();
    	GlbUsuario user = em.createQuery("SELECT u from GlbUsuario u WHERE u.dsUsuario = :username", GlbUsuario.class).setParameter("username", userName).getSingleResult();
    	em.close();
    	return user;
    }
	
	
}
