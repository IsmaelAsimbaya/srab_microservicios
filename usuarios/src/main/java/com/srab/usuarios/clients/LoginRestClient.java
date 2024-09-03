package com.srab.usuarios.clients;

import com.srab.usuarios.dtos.LoginDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "loginsRestClient")
public interface LoginRestClient {

    @GET
    List<LoginDto> findAll();

    @GET
    @Path("/id_usuario/{id_usuario}")
    LoginDto findByIdUsuario(@PathParam("id_usuario") Integer id_usuario);
}
