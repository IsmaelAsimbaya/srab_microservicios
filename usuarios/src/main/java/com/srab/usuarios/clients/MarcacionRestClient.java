package com.srab.usuarios.clients;

import com.srab.usuarios.dtos.MarcacionDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/marcacion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "marcacionesRestClient")
public interface MarcacionRestClient {

    @GET
    List<MarcacionDto> findAll();

    @GET
    @Path("/usuario/{id_usuario}")
    List<MarcacionDto> findAllByIdUsuario(@PathParam("id_usuario") Integer id_usuario);

}
