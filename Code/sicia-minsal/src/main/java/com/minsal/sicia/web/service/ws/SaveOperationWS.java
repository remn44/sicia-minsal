package com.minsal.sicia.web.service.ws;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.minsal.sicia.resolver.SiciaResolver;
import com.minsal.sicia.web.service.dto.Response;
import com.minsal.sicia.web.service.dto.SaveOperationRequest;

@Path("/SiciaWS")
public class SaveOperationWS {
	
	@POST
	@Path("/SaveOperation")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response webService(SaveOperationRequest request){
		
		Response response = new Response();
		EntityManager em = SiciaResolver.getInstance().getEntityManagerFactory().createEntityManager();
		try {
			
			em.getTransaction().begin();
			em.createNativeQuery("INSERT INTO ss.operacion (id_ambulancia,id_producto,cantidad,fecha_venc_producto,fecha_operacion,tipo_operacion) VALUES"
					+ "(:idAmbulancia,:idProducto,:cant,:fechaVenc,:fechaOper,:tipoOper)")
					.setParameter("idAmbulancia", request.getIdAmbulancia())
					.setParameter("idProducto", request.getIdProducto())
					.setParameter("cant", request.getCantidad())
					.setParameter("fechaVenc", request.getFechaVencProducto())
					.setParameter("fechaOper", request.getFechaOperacion())
					.setParameter("tipoOper", request.getTipoOperacion()).executeUpdate()
					;
			em.getTransaction().commit();
			response.setCode(0);
			response.setDescription("Exito");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setCode(1);
			response.setDescription(e.getMessage());
		}finally {
			em.close();
		}		
		
		return response;
		
	}
	
}
