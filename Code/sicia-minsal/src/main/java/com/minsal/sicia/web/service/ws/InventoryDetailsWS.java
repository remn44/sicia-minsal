package com.minsal.sicia.web.service.ws;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.minsal.sicia.dto.Inventario;
import com.minsal.sicia.resolver.SiciaResolver;
import com.minsal.sicia.web.service.dto.InventoryDetailsRequest;
import com.minsal.sicia.web.service.dto.InventoryDetailsResponse;

@Path("/SiciaWS")
public class InventoryDetailsWS {

	@POST
	@Path("/InventoryDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public InventoryDetailsResponse webService(InventoryDetailsRequest request){
		
		InventoryDetailsResponse response = new InventoryDetailsResponse();
		try {
			EntityManager em = SiciaResolver.getInstance().getEntityManagerFactory().createEntityManager();
			
			Inventario inventario = (Inventario) em.createQuery("SELECT i FROM Inventario i WHERE i.ctlAmbulancia.idUnidad=:idAmbulancia",Inventario.class)
					.setParameter("idAmbulancia", request.getIdAmbulancia())
					.getSingleResult();
			
			em.close();
			response.setCode(0);
			response.setDescription("Exito");
			response.setInventario(inventario);
		}catch(Exception e) {
			response.setCode(1);
			response.setDescription(e.getMessage());
		}
		return response;
		
	}
	
}
