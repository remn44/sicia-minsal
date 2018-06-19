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
import com.minsal.sicia.dto.Ambulance;
import com.minsal.sicia.resolver.SiciaResolver;

@FacesConverter(forClass=Ambulance.class)
	public class AmbulanceConverter implements Converter {
		
		
		private EntityManager em = SiciaResolver.getInstance().getEntityManagerFactory().createEntityManager();

		protected EntityManager getEntityManager() {
			return this.em;
		}
		
		public List<Ambulance> findAll() {
			CriteriaQuery<Ambulance> cq = getEntityManager().getCriteriaBuilder()
			        .createQuery(Ambulance.class);
			cq.select(cq.from(Ambulance.class));

			return getEntityManager().createQuery(cq).getResultList();
		}
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
		    if (submittedValue == null || submittedValue.isEmpty()) {
		        return null;
		    }
		    System.out.println(submittedValue);
		    try {
		    	
		    	for (Ambulance testItem : findAll()) {
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

		    if (modelValue instanceof Ambulance) {
		        return String.valueOf(((Ambulance) modelValue).getIdAmbulancia());
		    } else {
		        throw new ConverterException(new FacesMessage(modelValue + " is not a valid Ambulance"));
		    }
		}

	}