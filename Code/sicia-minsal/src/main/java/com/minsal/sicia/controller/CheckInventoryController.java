package com.minsal.sicia.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.minsal.sicia.dao.AmbulanceDao;
import com.minsal.sicia.dto.Ambulance;

@ManagedBean(name="checkInventoryController")
@ViewScoped
public class CheckInventoryController {
	
	private Ambulance ambulanceSelected;
	private List<Ambulance> ambulancesList = new LinkedList<Ambulance>();
	
	@ManagedProperty(value="#{ambulanceDao}")
	private AmbulanceDao ambulanceDao;
	
	@PostConstruct
	private void onload() {
		this.ambulancesList = ambulanceDao.findAll();
	}
	
	public List<Ambulance> getAmbulancesList() {
		return ambulancesList;
	}
	public void setAmbulancesList(List<Ambulance> ambulancesList) {
		this.ambulancesList = ambulancesList;
	}
	public AmbulanceDao getAmbulanceDao() {
		return ambulanceDao;
	}
	public void setAmbulanceDao(AmbulanceDao ambulanceDao) {
		this.ambulanceDao = ambulanceDao;
	}
	public Ambulance getAmbulanceSelected() {
		return ambulanceSelected;
	}
	public void setAmbulanceSelected(Ambulance ambulanceSelected) {
		this.ambulanceSelected = ambulanceSelected;
	}
	
	public void prueba() {
		System.out.println(this.ambulanceSelected.getIdUnidad());
	}
	
}
