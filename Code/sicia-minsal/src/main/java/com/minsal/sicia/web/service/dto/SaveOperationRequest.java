package com.minsal.sicia.web.service.dto;

import java.io.Serializable;
import java.util.List;

public class SaveOperationRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String idAmbulancia;
	
//	private Integer idInventario;

	private List<Operation> operaciones;

	public SaveOperationRequest() {
	}

	public String getIdAmbulancia() {
		return idAmbulancia;
	}

	public void setIdAmbulancia(String idAmbulancia) {
		this.idAmbulancia = idAmbulancia;
	}

//	public Integer getIdInventario() {
//		return idInventario;
//	}
//
//	public void setIdInventario(Integer idInventario) {
//		this.idInventario = idInventario;
//	}

	public List<Operation> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(List<Operation> operaciones) {
		this.operaciones = operaciones;
	}

}