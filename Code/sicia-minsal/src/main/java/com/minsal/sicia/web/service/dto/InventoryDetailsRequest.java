package com.minsal.sicia.web.service.dto;

import java.io.Serializable;

public class InventoryDetailsRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String idAmbulancia;

	public String getIdAmbulancia() {
		return idAmbulancia;
	}

	public void setIdAmbulancia(String idAmbulancia) {
		this.idAmbulancia = idAmbulancia;
	}
	
}
