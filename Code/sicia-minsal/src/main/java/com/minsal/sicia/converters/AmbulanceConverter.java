package com.minsal.sicia.converters;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import com.minsal.sicia.dao.AmbulanceDao;
import com.minsal.sicia.dto.CtlAmbulancia;
import com.minsal.sicia.resolver.SiciaResolver;

@FacesConverter(forClass=CtlAmbulancia.class)
	public class AmbulanceConverter implements Converter {
		
		protected EntityManager getEntityManager() {
			return SiciaResolver.getInstance().getEntityManagerFactory().createEntityManager();
		}
		
		public List<CtlAmbulancia> findAll() {
			EntityManager em = getEntityManager();
			CriteriaQuery<CtlAmbulancia> cq = em.getCriteriaBuilder()
			        .createQuery(CtlAmbulancia.class);
			cq.select(cq.from(CtlAmbulancia.class));
			List<CtlAmbulancia> list = em.createQuery(cq).getResultList();
			em.close();
			return list;
		}
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
		    if (submittedValue == null || submittedValue.isEmpty()) {
		        return null;
		    }
		    System.out.println(submittedValue);
		    try {
		    	
		    	for (CtlAmbulancia testItem : findAll()) {
		    		if (testItem.getIdAmbulancia() == Integer.parseInt(submittedValue)) {
						return testItem;
					}
				}
		    	
//		        return warehouseService.find(Long.valueOf(submittedValue));
		    } catch (NumberFormatException e) {
		        throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Warehouse ID"), e);
		    }
		    return null;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
		    if (modelValue == null) {
		        return "";
		    }

		    if (modelValue instanceof CtlAmbulancia) {
		        return String.valueOf(((CtlAmbulancia) modelValue).getIdAmbulancia());
		    } else {
		        throw new ConverterException(new FacesMessage(modelValue + " is not a valid Ambulance"));
		    }
		}

	}