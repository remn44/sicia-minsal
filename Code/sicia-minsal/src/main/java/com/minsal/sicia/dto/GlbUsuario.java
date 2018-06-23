package com.minsal.sicia.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the glb_usuario database table.
 * 
 */
@Entity
@Table(name="glb_usuario")
@NamedQuery(name="GlbUsuario.findAll", query="SELECT g FROM GlbUsuario g")
public class GlbUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="cd_estado")
	private String cdEstado;

	@Column(name="ds_apellido")
	private String dsApellido;

	@Column(name="ds_correo")
	private String dsCorreo;

	@Column(name="ds_nombre")
	private String dsNombre;

	@Column(name="ds_pass")
	private String dsPass;

	@Column(name="ds_token")
	private String dsToken;

	@Column(name="ds_usuario")
	private String dsUsuario;

	@Column(name="fech_actu")
	private Timestamp fechActu;

	@Column(name="fech_crea")
	private Timestamp fechCrea;

	@Column(name="id_perfil")
	private String idPerfil;

	@Column(name="id_personal")
	private String idPersonal;

	@Column(name="usua_actu")
	private String usuaActu;

	@Column(name="usua_crea")
	private String usuaCrea;

	public GlbUsuario() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCdEstado() {
		return this.cdEstado;
	}

	public void setCdEstado(String cdEstado) {
		this.cdEstado = cdEstado;
	}

	public String getDsApellido() {
		return this.dsApellido;
	}

	public void setDsApellido(String dsApellido) {
		this.dsApellido = dsApellido;
	}

	public String getDsCorreo() {
		return this.dsCorreo;
	}

	public void setDsCorreo(String dsCorreo) {
		this.dsCorreo = dsCorreo;
	}

	public String getDsNombre() {
		return this.dsNombre;
	}

	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

	public String getDsPass() {
		return this.dsPass;
	}

	public void setDsPass(String dsPass) {
		this.dsPass = dsPass;
	}

	public String getDsToken() {
		return this.dsToken;
	}

	public void setDsToken(String dsToken) {
		this.dsToken = dsToken;
	}

	public String getDsUsuario() {
		return this.dsUsuario;
	}

	public void setDsUsuario(String dsUsuario) {
		this.dsUsuario = dsUsuario;
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

	public String getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getIdPersonal() {
		return this.idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
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

}