package com.minsal.sicia.dto;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ctl_medicamento database table.
 * 
 */
@Entity
@Table(name="ctl_medicamento")
@NamedQuery(name="CtlMedicamento.findAll", query="SELECT c FROM CtlMedicamento c")
public class CtlMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="ds_concentracion")
	private String dsConcentracion;

	@Column(name="ds_dosificacion")
	private String dsDosificacion;

	@Column(name="ds_forma_farmaceutica")
	private String dsFormaFarmaceutica;

	@Column(name="ds_medicamento")
	private String dsMedicamento;

	@Column(name="ds_presentacion")
	private String dsPresentacion;

	@Column(name="nm_codigo_sinab")
	private String nmCodigoSinab;

	//bi-directional one-to-one association to Producto
	@OneToOne(mappedBy="ctlMedicamento")
	private Producto producto;

	public CtlMedicamento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDsConcentracion() {
		return this.dsConcentracion;
	}

	public void setDsConcentracion(String dsConcentracion) {
		this.dsConcentracion = dsConcentracion;
	}

	public String getDsDosificacion() {
		return this.dsDosificacion;
	}

	public void setDsDosificacion(String dsDosificacion) {
		this.dsDosificacion = dsDosificacion;
	}

	public String getDsFormaFarmaceutica() {
		return this.dsFormaFarmaceutica;
	}

	public void setDsFormaFarmaceutica(String dsFormaFarmaceutica) {
		this.dsFormaFarmaceutica = dsFormaFarmaceutica;
	}

	public String getDsMedicamento() {
		return this.dsMedicamento;
	}

	public void setDsMedicamento(String dsMedicamento) {
		this.dsMedicamento = dsMedicamento;
	}

	public String getDsPresentacion() {
		return this.dsPresentacion;
	}

	public void setDsPresentacion(String dsPresentacion) {
		this.dsPresentacion = dsPresentacion;
	}

	public String getNmCodigoSinab() {
		return this.nmCodigoSinab;
	}

	public void setNmCodigoSinab(String nmCodigoSinab) {
		this.nmCodigoSinab = nmCodigoSinab;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}