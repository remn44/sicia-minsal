package com.minsal.sicia.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.minsal.sicia.dao.AmbulanceDao;
import com.minsal.sicia.dao.OperacionDao;
import com.minsal.sicia.dto.CtlAmbulancia;
import com.minsal.sicia.dto.Operacion;

@ManagedBean(name="checkInventoryOutputsController")
@ViewScoped
public class CheckInventoryOutputsController {
	private CtlAmbulancia ambulanceSelected;
	private List<CtlAmbulancia> ambulancesList = new LinkedList<CtlAmbulancia>();
	
	@ManagedProperty(value="#{ambulanceDao}")
	private AmbulanceDao ambulanceDao;
	
	@ManagedProperty(value="#{operacionDao}")
	private OperacionDao operacionDao;
	
	private List<Operacion> operaciones;
	
	private String tipoOperacion;
	
	private Date maxDate;
	private Date minDate;
	private Date iniDate;
	private Date finDate;
	@PostConstruct
	private void onload() {
		this.ambulancesList = ambulanceDao.findAll();
		Calendar c = Calendar.getInstance();
		maxDate = new Date();
		finDate = maxDate;
		c.setTime(maxDate);
		c.add(Calendar.MONTH, -3);
		minDate = c.getTime();
		c.add(Calendar.MONTH, 2);
		iniDate = c.getTime();
	}
	
	public void filtrarOperaciones() {
		
		if(ambulanceSelected == null) {
			System.out.println("Null");
			this.operaciones = this.operacionDao.findAll();
			System.out.println("Cant: " + this.operaciones.size());
		}else {
			this.operaciones = ambulanceSelected.getOperaciones();
		}
		
		List<Operacion> op = new LinkedList<Operacion>();
		op.clear();
		for (Operacion operacion : this.operaciones) {
			if(operacion.getFechaOperacion().equals(iniDate) || operacion.getFechaOperacion().equals(finDate)
					|| (operacion.getFechaOperacion().before(finDate) && operacion.getFechaOperacion().after(iniDate))) {
				op.add(operacion);
				System.out.println("Agregando operacion...");
			}
		}
		this.operaciones.clear();
		this.operaciones.addAll(op);
		op.clear();
		System.out.println("cant final: " + this.operaciones.size());
		if(!"N".equals(tipoOperacion)) {
			for (Operacion operacion : this.operaciones) {
				if(tipoOperacion.equals(operacion.getTipoOperacion())) {
					op.add(operacion);
				}
			}
			this.operaciones.clear();
			this.operaciones.addAll(op);
			System.out.println("cant final: " + this.operaciones.size());
		}
		System.out.println("cant final: " + this.operaciones.size());
		
	}

	public List<Operacion> getOperaciones() {
		return this.operaciones;
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
//		System.out.println(this.ambulanceSelected.getIdUnidad());
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	public Date getIniDate() {
		return iniDate;
	}

	public void setIniDate(Date iniDate) {
		this.iniDate = iniDate;
	}

	public Date getFinDate() {
		return finDate;
	}

	public void setFinDate(Date finDate) {
		this.finDate = finDate;
	}

	public OperacionDao getOperacionDao() {
		return operacionDao;
	}

	public void setOperacionDao(OperacionDao operacionDao) {
		this.operacionDao = operacionDao;
	}
	
	
	
}
