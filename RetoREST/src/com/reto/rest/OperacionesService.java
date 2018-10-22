package com.reto.rest;

import java.io.IOException;
import java.util.Arrays;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.reto.back.Process;
import com.reto.dao.CalculoDao;

import com.reto.vo.RetoOperation;
import com.reto.vo.VOparametros;

@Path("/operacioensservice")
public class OperacionesService {
	

	@POST
	@Produces("application/json")
	@Consumes("application/json")

	public Response PostCalcular(String data) throws JsonParseException, JsonMappingException, IOException {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			VOparametros parametros = objectMapper.readValue(data, VOparametros.class);
			Process proccess = new Process();

			char[] dataArray = parametros.data.toCharArray();
			parametros.dataMatrix = proccess.arrayToMatrix(dataArray, parametros.alto, parametros.ancho);
			
			switch (parametros.operationiD) {
			case DUPLICADOS:
				parametros.temporalReturn = proccess.eliminarRepetidos(dataArray);
				parametros.charReturn = proccess.arrayToMatrix(parametros.temporalReturn, parametros.alto, parametros.ancho);
				break;
			case ORDENAMIENTO:
				parametros.temporalReturn = proccess.ordenarArreglo(dataArray);
				parametros.charReturn = proccess.arrayToMatrix(parametros.temporalReturn, parametros.alto, parametros.ancho);
				break;
			case OCURRENCIAS:
				parametros.stringReturn = proccess.consultarOcurrencias(dataArray);
				break;
				default: break;
			}
			
			
			CalculoDao dao = new CalculoDao();
			dao.saveCalculoParametro(parametros);

			return Ok(parametros);
		} catch (Exception e) {
			return Response.status(500).build();
		}
		
		
	
	}

	private Response Ok(VOparametros obj) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		return Response.status(200).entity(json).build();
	}

}
