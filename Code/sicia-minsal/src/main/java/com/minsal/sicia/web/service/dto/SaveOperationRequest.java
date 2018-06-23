package com.minsal.sicia.web.service.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the operacion database table.
 * 
 */
public class SaveOperationRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idOperacion;
	
	private Integer cantidad;

	private String tipoOperacion;
	
	private Date fechaOperacion;

	private Date fechaVencProducto;

	private Integer idAmbulancia;

	private Integer idProducto;
	
//	@ManyToOne
//	@JoinColumn(name="id_ambulancia")
//	private CtlAmbulancia idAmbulancia;
//	
//	@ManyToOne
//	@JoinColumn(name="id_producto")
//	private Producto idProducto;

	public SaveOperationRequest() {
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public Integer getIdOperacion() {
		return this.idOperacion;
	}

	public void setIdOperacion(Integer idOperacion) {
		this.idOperacion = idOperacion;
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

	public Integer getIdAmbulancia() {
		return idAmbulancia;
	}

	public void setIdAmbulancia(Integer idAmbulancia) {
		this.idAmbulancia = idAmbulancia;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

//	public CtlAmbulancia getIdAmbulancia() {
//		return idAmbulancia;
//	}
//
//	public void setIdAmbulancia(CtlAmbulancia idAmbulancia) {
//		this.idAmbulancia = idAmbulancia;
//	}
//
//	public Producto getIdProducto() {
//		return idProducto;
//	}
//
//	public void setIdProducto(Producto idProducto) {
//		this.idProducto = idProducto;
//	}

}