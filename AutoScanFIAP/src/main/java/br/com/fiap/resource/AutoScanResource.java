package br.com.fiap.resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.PcdOuIdoso;
import br.com.fiap.bo.AutoScanBO;

@Path("/cadastro")
public class AutoScanResource {

	private AutoScanBO bo = new AutoScanBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(Cliente cliente, PcdOuIdoso pcd, @Context UriInfo urlInfo) throws ClassNotFoundException, SQLException {
		bo.inserirCadastro(cliente, pcd);
		UriBuilder builder = urlInfo.getAbsolutePathBuilder();
		return Response.created(builder.build()).build();
	}
	
}
