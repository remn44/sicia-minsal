package com.minsal.sicia.dao;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.minsal.sicia.dto.Ambulance;

@ManagedBean(name="ambulanceDao")
@ViewScoped
public class AmbulanceDao extends AbstractDao<Ambulance> implements Serializable{

	private static final long serialVersionUID = 1L;

	public AmbulanceDao() {
		super(Ambulance.class);
		// TODO Auto-generated constructor stub
	}
	
}
