package com.minsal.sicia.web.service.dto;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;

public class ValeSinab implements Serializable {
	private static final long serialVersionUID = 1L;


	private BigDecimal cantidad;

	private String destino;

	private Date fechaVencimiento;

	private Integer idAlmacen;

	private Integer idEstablecimiento;

	private Integer idFuenteFinanciamiento;

	private Integer idMaestro;

	private Integer idMovimiento;

	private String nombreAlmacen;

	private String numeroIdentificacion;

	private String numeroLote;

	private String numeroVale;

	private String observacion;

	private String personaRecibe;

	private BigDecimal precioUnitario;

	private String ctlMedicamento;//CORRPRODUCTO del sinab

	public ValeSinab() {
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Integer getIdAlmacen() {
		return this.idAlmacen;
	}

	public void setIdAlmacen(Integer idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public Integer getIdEstablecimiento() {
		return this.idEstablecimiento;
	}

	public void setIdEstablecimiento(Integer idEstablecimiento) {
		this.idEstablecimiento = idEstablecimiento;
	}

	public Integer getIdFuenteFinanciamiento() {
		return this.idFuenteFinanciamiento;
	}

	public void setIdFuenteFinanciamiento(Integer idFuenteFinanciamiento) {
		this.idFuenteFinanciamiento = idFuenteFinanciamiento;
	}

	public Integer getIdMaestro() {
		return this.idMaestro;
	}

	public void setIdMaestro(Integer idMaestro) {
		this.idMaestro = idMaestro;
	}

	public Integer getIdMovimiento() {
		return this.idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public String getNombreAlmacen() {
		return this.nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public String getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getNumeroLote() {
		return this.numeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}

	public String getNumeroVale() {
		return this.numeroVale;
	}

	public void setNumeroVale(String numeroVale) {
		this.numeroVale = numeroVale;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getPersonaRecibe() {
		return this.personaRecibe;
	}

	public void setPersonaRecibe(String personaRecibe) {
		this.personaRecibe = personaRecibe;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getCtlMedicamento() {
		return ctlMedicamento;
	}

	public void setCtlMedicamento(String ctlMedicamento) {
		this.ctlMedicamento = ctlMedicamento;
	}


}