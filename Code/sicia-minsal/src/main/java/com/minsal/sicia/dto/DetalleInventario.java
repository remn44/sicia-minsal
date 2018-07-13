package com.minsal.sicia.dto;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
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

	private BigDecimal cantidad;

	private String destino;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vencimiento")
	private Date fechaVencimiento;

	@Column(name="id_almacen")
	private Integer idAlmacen;

	@Column(name="id_establecimiento")
	private Integer idEstablecimiento;

	@Column(name="id_fuente_financiamiento")
	private Integer idFuenteFinanciamiento;

	@Column(name="id_maestro")
	private Integer idMaestro;

	@Column(name="id_movimiento")
	private Integer idMovimiento;

	@Column(name="nombre_almacen")
	private String nombreAlmacen;

	@Column(name="numero_identificacion")
	private String numeroIdentificacion;

	@Column(name="numero_lote")
	private String numeroLote;

	@Column(name="numero_vale")
	private String numeroVale;

	private String observacion;

	@Column(name="persona_recibe")
	private String personaRecibe;

	@Column(name="precio_unitario")
	private BigDecimal precioUnitario;

	//bi-directional many-to-one association to Inventario
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_inventario")
	private Inventario inventario;

	//bi-directional many-to-one association to CtlMedicamento
	@ManyToOne
	@JoinColumn(name="corr_producto", referencedColumnName="nm_codigo_sinab")
	private CtlMedicamento ctlMedicamento;

	public DetalleInventario() {
	}

	public Integer getIdDetalleInventario() {
		return this.idDetalleInventario;
	}

	public void setIdDetalleInventario(Integer idDetalleInventario) {
		this.idDetalleInventario = idDetalleInventario;
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

	public Inventario getInventario() {
		return this.inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public CtlMedicamento getCtlMedicamento() {
		return this.ctlMedicamento;
	}

	public void setCtlMedicamento(CtlMedicamento ctlMedicamento) {
		this.ctlMedicamento = ctlMedicamento;
	}

}