package com.minsal.sicia.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.minsal.sicia.dao.AmbulanceDao;
import com.minsal.sicia.dao.InventarioDao;
import com.minsal.sicia.dto.CtlAmbulancia;
import com.minsal.sicia.dto.Inventario;

@ManagedBean(name="assignInventoryController")
@ViewScoped
public class AssignInventoryController {
	
	private CtlAmbulancia ambulanceSelected;
	private List<CtlAmbulancia> ambulancesList = new LinkedList<CtlAmbulancia>();
	private List<CtlAmbulancia> ambulancesNIList = new LinkedList<CtlAmbulancia>();
	
	@ManagedProperty(value="#{ambulanceDao}")
	private AmbulanceDao ambulanceDao;
	
	@ManagedProperty(value="#{inventarioDao}")
	private InventarioDao inventarioDao;
	
	@PostConstruct
	private void onload() {
		this.ambulancesList = ambulanceDao.findAll();
	}

	public CtlAmbulancia getAmbulanceSelected() {
		return ambulanceSelected;
	}

	public void setAmbulanceSelected(CtlAmbulancia ambulanceSelected) {
		this.ambulanceSelected = ambulanceSelected;
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

	public List<CtlAmbulancia> getAmbulancesNIList() {
		
		ambulancesNIList.clear();
		
		if(ambulancesList==null) {
			ambulancesList = ambulanceDao.findAll();
		}
		
		for (CtlAmbulancia ctlAmbulancia : ambulancesList) {
			if(ctlAmbulancia.getInventario()==null) {
				ambulancesNIList.add(ctlAmbulancia);
			}
		}
		
		return ambulancesNIList;
		
	}

	public void setAmbulancesNIList(List<CtlAmbulancia> ambulancesNIList) {
		this.ambulancesNIList = ambulancesNIList;
	}

	public InventarioDao getInventarioDao() {
		return inventarioDao;
	}

	public void setInventarioDao(InventarioDao inventorioDao) {
		this.inventarioDao = inventorioDao;
	}
	
	public void CreateInventory(CtlAmbulancia ctlAmbulancia) {
		
		Inventario inv = new Inventario();
		inv.setCtlAmbulancia(ctlAmbulancia);
		inventarioDao.create(inv);
		this.ambulancesList = null;
	}
	
}
