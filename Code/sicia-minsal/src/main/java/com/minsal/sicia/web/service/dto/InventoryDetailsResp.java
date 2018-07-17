package com.minsal.sicia.web.service.dto;

import java.io.Serializable;
import java.util.List;

public class InventoryDetailsResp implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String description;

	private List<InventoryDetailsDto> detalles;
	
	public InventoryDetailsResp() {

	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<InventoryDetailsDto> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<InventoryDetailsDto> detalles) {
		this.detalles = detalles;
	}

	
}
