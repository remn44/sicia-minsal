package com.minsal.sicia.web.service.ws;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.minsal.sicia.dto.Operacion;
import com.minsal.sicia.resolver.SiciaResolver;
import com.minsal.sicia.web.service.dto.Operation;
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
		try {
			EntityManager em = SiciaResolver.getInstance().getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			int idAmbulancia = request.getIdAmbulancia();
			int idInventario = request.getIdInventario();
			for (Operation op : request.getOperaciones()) {
				saveOperation(response, op, em, idAmbulancia, idInventario);
			}
			em.getTransaction().commit();
			em.close();
		}catch(Exception e) {
			response.setCode(1);
			response.setDescription(e.getMessage());
		}
		return response;
		
	}
	
	private void saveOperation(Response response, Operation request, EntityManager em, Integer idAmbulancia, Integer idInventario) {
		try {
			Integer cantidad = request.getCantidad();
			if("S".equals(request.getTipoOperacion())) {
				cantidad = -1*cantidad;
			}
			em.createNativeQuery("INSERT INTO ss.operacion (id_ambulancia,id_producto,cantidad,fecha_venc_producto,fecha_operacion,tipo_operacion,fecha_operacion_registrada,justificacion)"
					+ " VALUES"
					+ "(:idAmbulancia,:idProducto,:cant,:fechaVenc,CURRENT_TIMESTAMP,:tipoOper, CURRENT_TIMESTAMP,:justifica)")
					.setParameter("idAmbulancia", idAmbulancia)
					.setParameter("idProducto", request.getIdProducto())
					.setParameter("cant", request.getCantidad())
					.setParameter("fechaVenc", request.getFechaVencProducto())
//					.setParameter("fechaOper", request.getFechaOperacion())
					.setParameter("tipoOper", request.getTipoOperacion())
					.setParameter("justifica", request.getJustificacion()).executeUpdate()
					;
			em.createNativeQuery("update ss.detalle_inventario set cantidad=cantidad+:cant where corr_producto = :idProducto AND id_inventario = :idInventario")
								.setParameter("cant", cantidad)
								.setParameter("idProducto", request.getIdProducto())
								.setParameter("idInventario", idInventario)
								.executeUpdate();
			response.setCode(0);
			response.setDescription("Exito");
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(1);
			response.setDescription(e.getMessage());
		}
		
	}
	
}






