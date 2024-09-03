package com.srab.lugarestrabajo.rest;

import com.srab.lugarestrabajo.db.LugarTrabajo;
import com.srab.lugarestrabajo.repo.LugarTrabajoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/lugartrabajo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class LugarTrabajoRest {

    @Inject
    LugarTrabajoRepository rep;

    @GET
    public List<LugarTrabajo> findAll() {
        return rep.findAll().list();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        var lugarTrabajo = rep.findByIdOptional(id);
        if (lugarTrabajo.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(lugarTrabajo.get()).build();
    }

    @POST
    public Response create(LugarTrabajo lugarTrabajo) {
        rep.persist(lugarTrabajo);
        return Response.status(Response.Status.CREATED.getStatusCode(), "lugar trabajo creado").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, LugarTrabajo lugarTrabajo) {
        LugarTrabajo lugar = rep.findById(id);
        if (lugar == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            lugar.setNombreLugar(lugarTrabajo.getNombreLugar());
            lugar.setDireccionLugar(lugarTrabajo.getDireccionLugar());
            lugar.setCord(lugarTrabajo.getCord());
            lugar.setAxis1(lugarTrabajo.getAxis1());
            lugar.setAxis2(lugarTrabajo.getAxis2());
            lugar.setAxis3(lugarTrabajo.getAxis3());
            lugar.setAxis4(lugarTrabajo.getAxis4());
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
