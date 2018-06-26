package com.minsal.sicia.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to DetalleInventario
	@OneToMany(mappedBy="ctlMedicamento")
	private List<DetalleInventario> detalleInventarios;

	//bi-directional many-to-one association to Operacion
	@OneToMany(mappedBy="ctlMedicamento")
	private List<Operacion> operacions;

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

	public List<DetalleInventario> getDetalleInventarios() {
		return this.detalleInventarios;
	}

	public void setDetalleInventarios(List<DetalleInventario> detalleInventarios) {
		this.detalleInventarios = detalleInventarios;
	}

	public DetalleInventario addDetalleInventario(DetalleInventario detalleInventario) {
		getDetalleInventarios().add(detalleInventario);
		detalleInventario.setCtlMedicamento(this);

		return detalleInventario;
	}

	public DetalleInventario removeDetalleInventario(DetalleInventario detalleInventario) {
		getDetalleInventarios().remove(detalleInventario);
		detalleInventario.setCtlMedicamento(null);

		return detalleInventario;
	}

	public List<Operacion> getOperacions() {
		return this.operacions;
	}

	public void setOperacions(List<Operacion> operacions) {
		this.operacions = operacions;
	}

	public Operacion addOperacion(Operacion operacion) {
		getOperacions().add(operacion);
		operacion.setCtlMedicamento(this);

		return operacion;
	}

	public Operacion removeOperacion(Operacion operacion) {
		getOperacions().remove(operacion);
		operacion.setCtlMedicamento(null);

		return operacion;
	}

	public String getNmCodigoSinab() {
		return nmCodigoSinab;
	}

	public void setNmCodigoSinab(String nmCodigoSinab) {
		this.nmCodigoSinab = nmCodigoSinab;
	}
	

}