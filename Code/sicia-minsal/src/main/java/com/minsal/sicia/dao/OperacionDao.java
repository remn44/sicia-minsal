package com.minsal.sicia.dao;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.minsal.sicia.dto.Operacion;

@ManagedBean(name="operacionDao")
@ViewScoped
public class OperacionDao extends AbstractDao<Operacion> implements Serializable{

	private static final long serialVersionUID = 1L;

	public OperacionDao() {
		super(Operacion.class);
		// TODO Auto-generated constructor stub
	}
	
}
