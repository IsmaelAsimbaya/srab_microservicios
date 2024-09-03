package com.srab.usuarios.clients;

import com.srab.usuarios.dtos.LugarTrabajoDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/lugartrabajo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "lugaresTrabajoRestClient")
public interface LugarTrabajoRestClient {

    @GET
    List<LugarTrabajoDto> findAll();

    @GET
    @Path("/{id}")
    LugarTrabajoDto getById(@PathParam("id") Integer id);

}
