package com.srab.horarios.rest;

import com.srab.horarios.db.Horario;
import com.srab.horarios.repo.HorarioRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/horario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class HorarioRest {

    @Inject
    HorarioRepository rep;

    @GET
    public List<Horario> findAll() {
        return rep.findAll().list();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        var horario = rep.findByIdOptional(id);
        if (horario.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(horario.get()).build();
    }

    @POST
    public Response create(Horario horario) {
        rep.persist(horario);
        return Response.status(Response.Status.CREATED.getStatusCode(), "horario creado").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, Horario horario) {
        Horario horarioaux = rep.findById(id);
        if (horarioaux == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            horarioaux.setHoraEntrada(horario.getHoraEntrada());
            horarioaux.setHoraSalida(horario.getHoraSalida());
            horarioaux.setDiasSemana(horario.getDiasSemana());
            horarioaux.setNombre(horario.getNombre());
        }
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        rep.deleteById(id);
        return Response.ok().build();
    }

}
