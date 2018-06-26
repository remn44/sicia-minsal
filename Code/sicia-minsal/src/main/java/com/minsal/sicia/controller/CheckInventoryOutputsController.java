package com.minsal.sicia.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.minsal.sicia.dao.AmbulanceDao;
import com.minsal.sicia.dto.CtlAmbulancia;
import com.minsal.sicia.dto.Operacion;

@ManagedBean(name="checkInventoryOutputsController")
@ViewScoped
public class CheckInventoryOutputsController {
	private CtlAmbulancia ambulanceSelected;
	private List<CtlAmbulancia> ambulancesList = new LinkedList<CtlAmbulancia>();
	
	@ManagedProperty(value="#{ambulanceDao}")
	private AmbulanceDao ambulanceDao;
	
	private List<Operacion> operaciones;
	
	private String tipoOperacion;
	
	@PostConstruct
	private void onload() {
		this.ambulancesList = ambulanceDao.findAll();
	}
	
	public List<Operacion> getOperaciones() {
		this.operaciones = ambulanceSelected.getOperaciones();
		List<Operacion> op = new LinkedList<Operacion>();
		
		if("N".equals(tipoOperacion)) {
			return operaciones;
		}else {
			for (Operacion operacion : this.operaciones) {
				if(tipoOperacion.equals(operacion.getTipoOperacion())) {
					op.add(operacion);
				}
			}
			this.operaciones = op;
		}
		
		return operaciones;
	}

	public void setOperaciones(List<Operacion> operaciones) {
		this.operaciones = operaciones;
	}

	public List<CtlAmbulancia> getAmbulancesList() {
		return ambulancesList;
	}
	public void setAmbulancesList(List<CtlAmbulancia> ambulancesList) {
		this.ambulancesList = ambulancesList;
	}
	public AmbulanceDao getAmbulanceDao() {
		return ambulanceDao;
	}
	public void setAmbulanceDao(AmbulanceDao ambulanceDao) {
		this.ambulanceDao = ambulanceDao;
	}
	public CtlAmbulancia getAmbulanceSelected() {
		return ambulanceSelected;
	}
	public void setAmbulanceSelected(CtlAmbulancia ambulanceSelected) {
		this.ambulanceSelected = ambulanceSelected;
	}
	
	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public void prueba() {
		System.out.println(this.ambulanceSelected.getIdUnidad());
	}
}
