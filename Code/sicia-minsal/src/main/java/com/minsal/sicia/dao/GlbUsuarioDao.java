package com.minsal.sicia.dao;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.minsal.sicia.dto.GlbUsuario;

@ManagedBean(name = "glbUsuarioDao")
@ViewScoped
public class GlbUsuarioDao extends AbstractDao<GlbUsuario> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GlbUsuarioDao() {
		super(GlbUsuario.class);
		// TODO Auto-generated constructor stub
	}
	
}
