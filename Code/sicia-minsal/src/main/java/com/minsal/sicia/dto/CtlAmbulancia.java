package com.minsal.sicia.dto;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ctl_ambulancia database table.
 * 
 */
@Entity
@Table(name="ctl_ambulancia")
public class CtlAmbulancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ambulancia")
	private Integer idAmbulancia;

	@Column(name="cd_estado")
	private String cdEstado;

	@Column(name="ds_ambulancia")
	private String dsAmbulancia;

	@Column(name="ds_num_ambulancia")
	private String dsNumAmbulancia;

	@Column(name="ds_tipo_ambulancia")
	private String dsTipoAmbulancia;

	@Column(name="fech_actu")
	private Timestamp fechActu;

	@Column(name="fech_crea")
	private Timestamp fechCrea;

	@Column(name="id_base")
	private String idBase;

	@Column(name="id_institucion")
	private String idInstitucion;

	@Column(name="id_provincia")
	private String idProvincia;

	@Column(name="id_unidad")
	private String idUnidad;

	@Column(name="usua_actu")
	private String usuaActu;

	@Column(name="usua_crea")
	private String usuaCrea;

	//bi-directional many-to-one association to Operacion
	@OneToMany(mappedBy="ctlAmbulancia")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Operacion> operaciones;

	//bi-directional one-to-one association to Inventario
	@OneToOne(mappedBy="ctlAmbulancia")
	private Inventario inventario;

	public CtlAmbulancia() {
	}

	public Integer getIdAmbulancia() {
		return this.idAmbulancia;
	}

	public void setIdAmbulancia(Integer idAmbulancia) {
		this.idAmbulancia = idAmbulancia;
	}

	public String getCdEstado() {
		return this.cdEstado;
	}

	public void setCdEstado(String cdEstado) {
		this.cdEstado = cdEstado;
	}

	public String getDsAmbulancia() {
		return this.dsAmbulancia;
	}

	public void setDsAmbulancia(String dsAmbulancia) {
		this.dsAmbulancia = dsAmbulancia;
	}

	public String getDsNumAmbulancia() {
		return this.dsNumAmbulancia;
	}

	public void setDsNumAmbulancia(String dsNumAmbulancia) {
		this.dsNumAmbulancia = dsNumAmbulancia;
	}

	public String getDsTipoAmbulancia() {
		return this.dsTipoAmbulancia;
	}

	public void setDsTipoAmbulancia(String dsTipoAmbulancia) {
		this.dsTipoAmbulancia = dsTipoAmbulancia;
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

	public String getIdBase() {
		return this.idBase;
	}

	public void setIdBase(String idBase) {
		this.idBase = idBase;
	}

	public String getIdInstitucion() {
		return this.idInstitucion;
	}

	public void setIdInstitucion(String idInstitucion) {
		this.idInstitucion = idInstitucion;
	}

	public String getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(String idUnidad) {
		this.idUnidad = idUnidad;
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

	public List<Operacion> getOperaciones() {
		return this.operaciones;
	}

	public void setOperacions(List<Operacion> operaciones) {
		this.operaciones = operaciones;
	}

	public Operacion addOperacion(Operacion operacion) {
		getOperaciones().add(operacion);
		operacion.setCtlAmbulancia(this);

		return operacion;
	}

	public Operacion removeOperacion(Operacion operacion) {
		getOperaciones().remove(operacion);
		operacion.setCtlAmbulancia(null);

		return operacion;
	}

	public Inventario getInventario() {
		return this.inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}
	

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmbulancia != null ? idAmbulancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CtlAmbulancia)) {
            return false;
        }
        CtlAmbulancia other = (CtlAmbulancia) object;
        if ((this.idAmbulancia == null && other.idAmbulancia != null) || (this.idAmbulancia != null && !this.idAmbulancia.equals(other.idAmbulancia))) {
            return false;
        }
        return true;
}

}