package com.minsal.sicia.dao;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.minsal.sicia.dto.Inventario;

@ManagedBean(name="inventarioDao")
@ViewScoped
public class InventarioDao extends AbstractDao<Inventario> implements Serializable{

	private static final long serialVersionUID = 1L;

	public InventarioDao() {
		super(Inventario.class);
		// TODO Auto-generated constructor stub
	}
	
}
