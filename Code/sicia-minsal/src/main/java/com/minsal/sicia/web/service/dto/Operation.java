package com.minsal.sicia.web.service.dto;

import java.io.Serializable;
import java.util.Date;

public class Operation implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cantidad;

	private String tipoOperacion;
	
	private Date fechaOperacion;

	private Date fechaVencProducto;

	private String idProducto;
	
	private String justificacion;
	
	public Operation() {
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaOperacion() {
		return this.fechaOperacion;
	}

	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	public Date getFechaVencProducto() {
		return this.fechaVencProducto;
	}

	public void setFechaVencProducto(Date fechaVencProducto) {
		this.fechaVencProducto = fechaVencProducto;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	
}
