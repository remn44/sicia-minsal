package com.minsal.sicia.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.minsal.sicia.dao.AmbulanceDao;
import com.minsal.sicia.dto.CtlAmbulancia;

@ManagedBean(name="checkInventoryOutputsController")
@ViewScoped
public class CheckInventoryOutputsController {
	private CtlAmbulancia ambulanceSelected;
	private List<CtlAmbulancia> ambulancesList = new LinkedList<CtlAmbulancia>();
	
	@ManagedProperty(value="#{ambulanceDao}")
	private AmbulanceDao ambulanceDao;
	
	@PostConstruct
	private void onload() {
		this.ambulancesList = ambulanceDao.findAll();
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
	
	public void prueba() {
		System.out.println(this.ambulanceSelected.getIdUnidad());
	}
}
