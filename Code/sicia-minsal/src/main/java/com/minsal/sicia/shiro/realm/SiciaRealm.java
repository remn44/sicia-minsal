package com.minsal.sicia.shiro.realm;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.minsal.sicia.dao.UserDao;
import com.minsal.sicia.dto.User;

public class SiciaRealm extends AuthenticatingRealm {
	
	@ManagedProperty(value="#{userDao}")
    protected UserDao userDao;

    public SiciaRealm() {
    }
    
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//        User user = userDao.find(1);
        
//        if( user != null ) {
            return new SimpleAuthenticationInfo(1, "5a9ee05c5a77b3c50c6d2c41d4b15384", "Rene");
//        } else {
//            return null;
//        }
    }
    

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }


	
}
