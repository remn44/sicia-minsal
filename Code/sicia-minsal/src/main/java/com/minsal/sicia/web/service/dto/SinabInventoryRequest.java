package com.minsal.sicia.web.service.dto;

import java.io.Serializable;

public class SinabInventoryRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String idUnidad;

	public String getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(String idUnidad) {
		this.idUnidad = idUnidad;
	}
	
}
