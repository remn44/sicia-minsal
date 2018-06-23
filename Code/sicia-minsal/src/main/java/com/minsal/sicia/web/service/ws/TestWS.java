package com.minsal.sicia.web.service.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.minsal.sicia.web.service.dto.Request;
import com.minsal.sicia.web.service.dto.Response;

@Path("/SiciaWS")
public class TestWS {

	@POST
	@Path("/Test")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response webService(Request request){
		
		Response response = new Response();
		response.setCode(request.getCode()+1);
		response.setDescription(request.getDescription() + " : Respuesta");
		
		return response;
		
	}

}
