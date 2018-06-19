package com.minsal.sicia.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detalle_inventario database table.
 * 
 */
@Entity
@Table(name="detalle_inventario")
@NamedQuery(name="DetalleInventario.findAll", query="SELECT d FROM DetalleInventario d")
public class DetalleInventario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle_inventario")
	private Integer idDetalleInventario;

	private Integer cantidad;

	@Temporal(TemporalType.DATE)
	private Date fechavencimiento;

//	@Column(name="id_producto")
//	private Integer idProducto;

	//bi-directional many-to-one association to Inventario
	@ManyToOne
	@JoinColumn(name="id_inventario")
	private Inventario inventario;
	
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto idProducto;

	public DetalleInventario() {
	}

	public Integer getIdDetalleInventario() {
		return this.idDetalleInventario;
	}

	public void setIdDetalleInventario(Integer idDetalleInventario) {
		this.idDetalleInventario = idDetalleInventario;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechavencimiento() {
		return this.fechavencimiento;
	}

	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}

	public Producto getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

	public Inventario getInventario() {
		return this.inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

}