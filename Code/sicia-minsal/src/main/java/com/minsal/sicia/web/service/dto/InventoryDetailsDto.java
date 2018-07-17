package com.minsal.sicia.web.service.dto;

import java.math.BigDecimal;
import java.util.Date;

public class InventoryDetailsDto {
	
	private Integer idAmbulancia;
	private Integer idInventario;
	private String id_medicamento;
	private BigDecimal cantidad;
	private Date fechaVencimiento;
	
	public Integer getIdAmbulancia() {
		return idAmbulancia;
	}
	public void setIdAmbulancia(Integer idAmbulancia) {
		this.idAmbulancia = idAmbulancia;
	}
	public Integer getIdInventario() {
		return idInventario;
	}
	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}
	public String getId_medicamento() {
		return id_medicamento;
	}
	public void setId_medicamento(String id_medicamento) {
		this.id_medicamento = id_medicamento;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
	
}
