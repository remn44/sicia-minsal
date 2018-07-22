package com.minsal.sicia.web.service.ws;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.minsal.sicia.dto.CtlAmbulancia;
import com.minsal.sicia.dto.Inventario;
import com.minsal.sicia.resolver.SiciaResolver;
import com.minsal.sicia.web.service.dto.ValeSinab;
import com.minsal.sicia.web.service.dto.Operation;
import com.minsal.sicia.web.service.dto.Response;
import com.minsal.sicia.web.service.dto.SinabInventoryRequest;

@Path("/SiciaWS")
public class SinabInventoryWS {

	@POST
	@Path("/SinabInventory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response webService(SinabInventoryRequest request){
		
		Response response = new Response();
		
		
		List<ValeSinab> listaVales = new LinkedList<ValeSinab>();// Emula la lista de vales enviados por el sinab
		
		ValeSinab valePrueba = new ValeSinab();
		
		valePrueba.setCantidad(new BigDecimal(500));
		valePrueba.setCtlMedicamento("02800010");
		valePrueba.setDestino("Ambulancia A301");
		valePrueba.setFechaVencimiento(new Date());
		valePrueba.setIdAlmacen(5);
		valePrueba.setIdEstablecimiento(5);
		valePrueba.setIdFuenteFinanciamiento(5);
		valePrueba.setIdMaestro(5);
		valePrueba.setIdMovimiento(5);
		valePrueba.setNombreAlmacen("Nombre del almacen origen");
		valePrueba.setNumeroIdentificacion("1234567891011");
		valePrueba.setNumeroLote("321");
		valePrueba.setNumeroVale("5");
		valePrueba.setObservacion("Primera prueba de carga de inventario");
		valePrueba.setPersonaRecibe("Persona que recibe");
		valePrueba.setPrecioUnitario(new BigDecimal(125));
		listaVales.add(valePrueba);
		
		List<Operation> listaOperaciones = new LinkedList<Operation>();
		Operation operacion = null;
		
		for (ValeSinab vale : listaVales) {
			
			operacion = new Operation();
			
			operacion.setCantidad(vale.getCantidad().intValue());
			operacion.setFechaOperacion(new Date());
			operacion.setFechaVencProducto(vale.getFechaVencimiento());
			operacion.setIdProducto(vale.getCtlMedicamento());
			operacion.setJustificacion("Ingreso de inventario desde SINAB");
			operacion.setTipoOperacion("E");
			
			listaOperaciones.add(operacion);
			
		}
		
		try {
			EntityManager em = SiciaResolver.getInstance().getEntityManagerFactory().createEntityManager();
			
			em.getTransaction().begin();
			int idAmbulancia = getAmbulanceId(request.getIdUnidad(), em);
			int idInventario = getInventoryId(idAmbulancia, em);
			for (Operation op : listaOperaciones) {
				int indexVale = 0;
				saveOperation(response, op, em, idAmbulancia, idInventario, listaVales.get(indexVale));
			}
			em.getTransaction().commit();
			em.close();
		}catch(Exception e) {
			response.setCode(1);
			response.setDescription(e.getMessage());
		}
		return response;
		
	}
	
	
	private void saveOperation(Response response, Operation request, EntityManager em, Integer idAmbulancia, Integer idInventario, ValeSinab vale) {
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
			em.createNativeQuery("INSERT INTO ss.detalle_inventario(" + 
					" id_inventario, corr_producto, numero_vale, nombre_almacen, destino, cantidad, precio_unitario, numero_lote, fecha_vencimiento," + 
					" id_fuente_financiamiento, persona_recibe, numero_identificacion, observacion, id_movimiento, id_maestro, id_almacen, id_establecimiento)" + 
					" VALUES (:idInventario, :correlativoSinab, :numVale, :NomAlmacen, :destino, :cantidad, :precio, :lote, :fecVencimiento, :fuenteFinan, :recibe, :numIdentificacion," + 
					" :observacion, :movimiento, :maestro, :almacen, :establecimiento)")
								.setParameter("idInventario", idInventario)
								.setParameter("correlativoSinab", vale.getCtlMedicamento())
								.setParameter("numVale", vale.getNumeroVale())
								.setParameter("NomAlmacen", vale.getNombreAlmacen())
								.setParameter("destino", vale.getDestino())
								.setParameter("cantidad", vale.getCantidad())
								.setParameter("precio", vale.getPrecioUnitario())
								.setParameter("lote", vale.getNumeroLote())
								.setParameter("fecVencimiento", vale.getFechaVencimiento())
								.setParameter("fuenteFinan", vale.getIdFuenteFinanciamiento())
								.setParameter("recibe", vale.getPersonaRecibe())
								.setParameter("numIdentificacion", vale.getNumeroIdentificacion())
								.setParameter("observacion", vale.getObservacion())
								.setParameter("movimiento", vale.getIdMovimiento())
								.setParameter("maestro", vale.getIdMaestro())
								.setParameter("almacen", vale.getIdAlmacen())
								.setParameter("establecimiento", vale.getIdEstablecimiento())
								.executeUpdate();
			response.setCode(0);
			response.setDescription("Exito");
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(1);
			response.setDescription(e.getMessage());
		}
		
	}
	
	private Integer getAmbulanceId(String idAmbulance, EntityManager em) {
		Integer id = 0;
		try {
			CtlAmbulancia ambulancia = em.createQuery("SELECT a FROM CtlAmbulancia a WHERE a.idUnidad=:idAmbulancia",CtlAmbulancia.class)
														.setParameter("idAmbulancia", idAmbulance)
														.getSingleResult()
														;
			id = ambulancia.getIdAmbulancia();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return id;
		
	}
	
	private Integer getInventoryId(Integer idAmbulance, EntityManager em) {
		Integer id = 0;
		try {
			Inventario inventario = em.createQuery("SELECT i FROM Inventario i WHERE i.ctlAmbulancia.idAmbulancia=:idAmbulancia",Inventario.class)
														.setParameter("idAmbulancia", idAmbulance)
														.getSingleResult()
														;
			id = inventario.getIdInventario();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return id;
		
	}
	
}
