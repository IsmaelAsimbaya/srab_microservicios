package com.srab.usuarios.clients;

import com.srab.usuarios.dtos.HorarioDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/horario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "horariosRestClient")
public interface HorarioRestClient {

    @GET
    List<HorarioDto> findAll();

    @GET
    @Path("/{id}")
    HorarioDto getById(@PathParam("id") Integer id);
}
