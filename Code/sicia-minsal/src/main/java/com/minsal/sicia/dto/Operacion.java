package com.minsal.sicia.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the operacion database table.
 * 
 */
@Entity
@NamedQuery(name="Operacion.findAll", query="SELECT o FROM Operacion o")
public class Operacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_operacion")
	private Integer idOperacion;
	
	@Column(name="cantidad")
	private Integer cantidad;

	@Column(name="tipo_operacion")
	private String tipoOperacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_operacion")
	private Date fechaOperacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_venc_producto")
	private Date fechaVencProducto;

//	@Column(name="id_ambulancia")
//	private Integer idAmbulancia;

//	@Column(name="id_producto")
//	private Integer idProducto;
	
	@ManyToOne
	@JoinColumn(name="id_ambulancia")
	private CtlAmbulancia idAmbulancia;
	
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto idProducto;

	@Transient
	private String tipo;
	
	public Operacion() {
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public String getTipo() {
		if("S".equals(this.tipoOperacion)) {
			tipo = "Salida";
		}else {
			tipo = "Entrada";
		}
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public CtlAmbulancia getIdAmbulancia() {
		return idAmbulancia;
	}

	public void setIdAmbulancia(CtlAmbulancia idAmbulancia) {
		this.idAmbulancia = idAmbulancia;
	}

	public Producto getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

}