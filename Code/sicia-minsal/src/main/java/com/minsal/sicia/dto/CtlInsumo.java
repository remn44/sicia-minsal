package com.minsal.sicia.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ctl_insumo database table.
 * 
 */
@Entity
@Table(name="ctl_insumo")
@NamedQuery(name="CtlInsumo.findAll", query="SELECT c FROM CtlInsumo c")
public class CtlInsumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="cd_estado")
	private String cdEstado;

	@Column(name="ds_descripcion")
	private String dsDescripcion;

	@Column(name="ds_insumo")
	private String dsInsumo;

	@Column(name="fech_actu")
	private Timestamp fechActu;

	@Column(name="fech_crea")
	private Timestamp fechCrea;

	@Column(name="usua_actu")
	private String usuaActu;

	@Column(name="usua_crea")
	private String usuaCrea;

	//bi-directional one-to-one association to Producto
	@OneToOne(mappedBy="ctlInsumo")
	private Producto producto;

	public CtlInsumo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCdEstado() {
		return this.cdEstado;
	}

	public void setCdEstado(String cdEstado) {
		this.cdEstado = cdEstado;
	}

	public String getDsDescripcion() {
		return this.dsDescripcion;
	}

	public void setDsDescripcion(String dsDescripcion) {
		this.dsDescripcion = dsDescripcion;
	}

	public String getDsInsumo() {
		return this.dsInsumo;
	}

	public void setDsInsumo(String dsInsumo) {
		this.dsInsumo = dsInsumo;
	}

	public Timestamp getFechActu() {
		return this.fechActu;
	}

	public void setFechActu(Timestamp fechActu) {
		this.fechActu = fechActu;
	}

	public Timestamp getFechCrea() {
		return this.fechCrea;
	}

	public void setFechCrea(Timestamp fechCrea) {
		this.fechCrea = fechCrea;
	}

	public String getUsuaActu() {
		return this.usuaActu;
	}

	public void setUsuaActu(String usuaActu) {
		this.usuaActu = usuaActu;
	}

	public String getUsuaCrea() {
		return this.usuaCrea;
	}

	public void setUsuaCrea(String usuaCrea) {
		this.usuaCrea = usuaCrea;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}