package com.minsal.sicia.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private Integer idProducto;

//	@Column(name="id_insumo")
//	private Integer idInsumo;

	@Column(name="tipo_producto")
	private String tipoProducto;

	//bi-directional one-to-one association to CtlMedicamento
	@OneToOne
	@JoinColumn(name="id_medicamento")
	private CtlMedicamento ctlMedicamento;

	//bi-directional one-to-one association to CtlInsumo
	@OneToOne
	@JoinColumn(name="id_insumo")
	private CtlInsumo ctlInsumo;
	
	@OneToMany(mappedBy="idProducto")
	private List<DetalleInventario> detalleInventarios;
	
	@OneToMany(mappedBy="idProducto")
	private List<Operacion> operaciones;
	
	@Transient
	private String tipo;
	
	@Transient
	private String nombre;
	
	@Transient
	private String descripcion;

	public String getNombre() {
		if(ctlMedicamento!=null) {
			nombre = ctlMedicamento.getDsMedicamento();
		}else if(ctlInsumo!=null) {
			nombre = ctlInsumo.getDsInsumo();
		}
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		if(ctlMedicamento!=null) {
			descripcion = ctlMedicamento.getDsFormaFarmaceutica();
		}else if(ctlInsumo!=null) {
			descripcion = ctlInsumo.getDsDescripcion();
		}
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<DetalleInventario> getDetalleInventarios() {
		return detalleInventarios;
	}

	public void setDetalleInventarios(List<DetalleInventario> detalleInventarios) {
		this.detalleInventarios = detalleInventarios;
	}

	public String getTipo() {
		if("M".equals(tipoProducto)) {
			tipo = "Medicamento";
		}else {
			tipo = "Insumo";
		}
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Producto() {
	}

	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

//	public Integer getIdInsumo() {
//		return this.idInsumo;
//	}
//
//	public void setIdInsumo(Integer idInsumo) {
//		this.idInsumo = idInsumo;
//	}

	public String getTipoProducto() {
		return this.tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public CtlMedicamento getCtlMedicamento() {
		return this.ctlMedicamento;
	}

	public void setCtlMedicamento(CtlMedicamento ctlMedicamento) {
		this.ctlMedicamento = ctlMedicamento;
	}

	public CtlInsumo getCtlInsumo() {
		return this.ctlInsumo;
	}

	public void setCtlInsumo(CtlInsumo ctlInsumo) {
		this.ctlInsumo = ctlInsumo;
	}

}