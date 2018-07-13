package com.minsal.sicia.web.service.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.minsal.sicia.dto.Inventario;

@XmlRootElement(name = "inventoryDetailsResponse")
public class InventoryDetailsResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code;
	private String description;

	private Inventario inventario;
	
	public InventoryDetailsResponse() {

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
	public Inventario getInventario() {
		return inventario;
	}
	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}
	
}
