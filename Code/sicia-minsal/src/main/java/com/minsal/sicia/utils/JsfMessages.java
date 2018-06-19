package com.minsal.sicia.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class JsfMessages {
	
//	private static JsfMessages instance = null;
//	
//	protected JsfMessages() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	public static JsfMessages getInstance() {
//		if(instance == null) {
//				instance = new JsfMessages();
//		}
//		   return instance;
//	}
	
	private static FacesContext facesContext;

	public static FacesContext getFacesContext() {
		facesContext = FacesContext.getCurrentInstance();
		return facesContext;
	}

	public static void setFacesContext(FacesContext newFacesContext) {
		facesContext = newFacesContext;
	}
	
	public static void addError(String mensaje) {
		
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,mensaje,null));
		
	}
	
	public static void addSuccess(String mensaje) {
		
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,mensaje,null));
	
	}
	
	public static void addWarning(String mensaje) {
		
		getFacesContext().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje,null));
		
	}
	
	public static void addFatal(String mensaje) {
		
		getFacesContext().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL, mensaje,null));
		
	}
	
	
	
}
