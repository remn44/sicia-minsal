package com.minsal.sicia.dto;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the inventario database table.
 * 
 */
@Entity
@NamedQuery(name="Inventario.findAll", query="SELECT i FROM Inventario i")
public class Inventario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_inventario")
	private Integer idInventario;

	//bi-directional many-to-one association to DetalleInventario
	@OneToMany(mappedBy="inventario")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<DetalleInventario> detalleInventarios;

	//bi-directional one-to-one association to CtlAmbulancia
	@OneToOne
	@JoinColumn(name="id_ambulancia")
	private CtlAmbulancia ctlAmbulancia;

	public Inventario() {
	}

	public Integer getIdInventario() {
		return this.idInventario;
	}

	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}

	public List<DetalleInventario> getDetalleInventarios() {
		return this.detalleInventarios;
	}

	public void setDetalleInventarios(List<DetalleInventario> detalleInventarios) {
		this.detalleInventarios = detalleInventarios;
	}

	public DetalleInventario addDetalleInventario(DetalleInventario detalleInventario) {
		getDetalleInventarios().add(detalleInventario);
		detalleInventario.setInventario(this);

		return detalleInventario;
	}

	public DetalleInventario removeDetalleInventario(DetalleInventario detalleInventario) {
		getDetalleInventarios().remove(detalleInventario);
		detalleInventario.setInventario(null);

		return detalleInventario;
	}

	public CtlAmbulancia getCtlAmbulancia() {
		return this.ctlAmbulancia;
	}

	public void setCtlAmbulancia(CtlAmbulancia ctlAmbulancia) {
		this.ctlAmbulancia = ctlAmbulancia;
	}

}