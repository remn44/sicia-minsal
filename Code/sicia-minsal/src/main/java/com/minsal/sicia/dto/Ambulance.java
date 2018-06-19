package com.minsal.sicia.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ctl_ambulancia")
public class Ambulance {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ambulancia", nullable = false)
    private Integer idAmbulancia;
	
	@Column(name="id_provincia")
	private String idProvincia;
	
	@Column(name="id_unidad")
	private String idUnidad;
	
	@Column(name="id_institucion")
	private String idInstitucion;
	
	@Column(name="id_base")
	private String idBase;
	
	@Column(name="ds_num_ambulancia")
	private String dsNumAmbulancia;
	
	@Column(name="ds_ambulancia")
	private String dsAmbulancia;
	
	@Column(name="ds_tipo_ambulancia")
	private String dsTipoAmbulancia;
	
	@Column(name="cd_estado")
	private String cdEstado;
	
	@Column(name="usua_crea")
	private String usuaCrea;
	
	@Column(name="fech_crea")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechCrea;
	
	@Column(name="usua_actu")
	private String usuaActu;

	@Column(name="fech_actu")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechActu;

	public Integer getIdAmbulancia() {
		return idAmbulancia;
	}

	public void setIdAmbulancia(Integer idAmbulancia) {
		this.idAmbulancia = idAmbulancia;
	}

	public String getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(String idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getIdInstitucion() {
		return idInstitucion;
	}

	public void setIdInstitucion(String idInstitucion) {
		this.idInstitucion = idInstitucion;
	}

	public String getIdBase() {
		return idBase;
	}

	public void setIdBase(String idBase) {
		this.idBase = idBase;
	}

	public String getDsNumAmbulancia() {
		return dsNumAmbulancia;
	}

	public void setDsNumAmbulancia(String dsNumAmbulancia) {
		this.dsNumAmbulancia = dsNumAmbulancia;
	}

	public String getDsAmbulancia() {
		return dsAmbulancia;
	}

	public void setDsAmbulancia(String dsAmbulancia) {
		this.dsAmbulancia = dsAmbulancia;
	}

	public String getDsTipoAmbulancia() {
		return dsTipoAmbulancia;
	}

	public void setDsTipoAmbulancia(String dsTipoAmbulancia) {
		this.dsTipoAmbulancia = dsTipoAmbulancia;
	}

	public String getCdEstado() {
		return cdEstado;
	}

	public void setCdEstado(String cdEstado) {
		this.cdEstado = cdEstado;
	}

	public String getUsuaCrea() {
		return usuaCrea;
	}

	public void setUsuaCrea(String usuaCrea) {
		this.usuaCrea = usuaCrea;
	}

	public Date getFechCrea() {
		return fechCrea;
	}

	public void setFechCrea(Date fechCrea) {
		this.fechCrea = fechCrea;
	}

	public String getUsuaActu() {
		return usuaActu;
	}

	public void setUsuaActu(String usuaActu) {
		this.usuaActu = usuaActu;
	}

	public Date getFechActu() {
		return fechActu;
	}

	public void setFechActu(Date fechActu) {
		this.fechActu = fechActu;
	}
	
	
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmbulancia != null ? idAmbulancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Ambulance)) {
            return false;
        }
        Ambulance other = (Ambulance) object;
        if ((this.idAmbulancia == null && other.idAmbulancia != null) || (this.idAmbulancia != null && !this.idAmbulancia.equals(other.idAmbulancia))) {
            return false;
        }
        return true;
    }
	
	
	
}
