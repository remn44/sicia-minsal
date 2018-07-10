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

	private Integer cantidad;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_operacion")
	private Date fechaOperacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_venc_producto")
	private Date fechaVencProducto;

	@Column(name="tipo_operacion")
	private String tipoOperacion;
	
	@Column(name="justificacion")
	private String justificacion;
	
	@Transient
	private String tipo;
	
	//bi-directional many-to-one association to CtlAmbulancia
	@ManyToOne
	@JoinColumn(name="id_ambulancia")
	private CtlAmbulancia ctlAmbulancia;

	//bi-directional many-to-one association to CtlMedicamento
	@ManyToOne
	@JoinColumn(name="id_producto", referencedColumnName="nm_codigo_sinab")
	private CtlMedicamento ctlMedicamento;

	public Operacion() {
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

	public String getTipoOperacion() {
		return this.tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public CtlAmbulancia getCtlAmbulancia() {
		return this.ctlAmbulancia;
	}

	public void setCtlAmbulancia(CtlAmbulancia ctlAmbulancia) {
		this.ctlAmbulancia = ctlAmbulancia;
	}

	public CtlMedicamento getCtlMedicamento() {
		return this.ctlMedicamento;
	}

	public void setCtlMedicamento(CtlMedicamento ctlMedicamento) {
		this.ctlMedicamento = ctlMedicamento;
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

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	
	
}