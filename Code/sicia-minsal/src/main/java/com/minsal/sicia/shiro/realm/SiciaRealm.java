package com.minsal.sicia.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.minsal.sicia.controller.LoginController;
import com.minsal.sicia.dto.GlbUsuario;
import com.minsal.sicia.resolver.SiciaResolver;

public class SiciaRealm extends AuthenticatingRealm {
	private static String RealName = "_SiciaRealm_";
	private EntityManager em;
//	private User user;
	private GlbUsuario user;
	
	@ManagedProperty(value="loginController")
	private LoginController loginController;
	
    public GlbUsuario getUser() {
		return user;
	}
	public void setUser(GlbUsuario user) {
		this.user = user;
	}
	public EntityManager getEm() {
    		em = SiciaResolver.getInstance().getEntityManagerFactory().createEntityManager();
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	public SiciaRealm() {
    }
    
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        this.user = getUser(token.getUsername());
//        System.out.println(this.getUser().getUserName());
        if( user != null ) {
            return new SimpleAuthenticationInfo(user.getDsUsuario(),user.getDsPass(),RealName);
        } else {
            return null;
        }
    }
    

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	
    	Set<String> info = new HashSet<String>();
    	this.user = getUser(principals.getPrimaryPrincipal().toString());
    	if(this.user!=null) {
    		if("TEC".equals(this.user.getIdPerfil())) {
        		info.add("ADMIN");
    		}
    	}

    	return new SimpleAuthorizationInfo(info);
    }


    public GlbUsuario getUser(String userName) {
    	EntityManager em = getEm();
    	GlbUsuario user = em.createQuery("SELECT u from GlbUsuario u WHERE u.dsUsuario = :username", GlbUsuario.class).setParameter("username", userName).getSingleResult();
    	em.close();
    	return user;
    }
	
}
