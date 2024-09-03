package com.srab.marcaciones.rest;

import com.srab.marcaciones.db.Marcacion;
import com.srab.marcaciones.repo.MarcacionRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Path("/marcacion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class MarcacionRest {

    @Inject
    MarcacionRepository rep;

    @GET
    public List<Marcacion> findAll() {
        return rep.findAll().list();
    }

    @GET
    @Path("/usuario/{id_usuario}")
    public List<Marcacion> findAllByIdUsuario(@PathParam("id_usuario") Integer id_usuario) {
        return rep.find("id_usuario", id_usuario).list();
    }

    @GET
    @Path("/fecha/{fecha}")
    public List<Marcacion> findAllByFecha(@PathParam("fecha") String fechaStr) {
        LocalDate fecha = LocalDate.parse(fechaStr);
        return rep.find("fecha", fecha).list();
    }

    @GET
    @Path("/hora/{hora}")
    public List<Marcacion> findAllByHora(@PathParam("hora") String horaStr) {
        LocalTime hora = LocalTime.parse(horaStr);
        return rep.find("hora", hora).list();
    }

    @GET
    @Path("/tipo/{tipo}")
    public List<Marcacion> findAllByTipo(@PathParam("tipo") String tipo) {
        return rep.find("tipo", tipo).list();
    }

    @GET
    @Path("/ubicacion/{ubicacion}")
    public List<Marcacion> findAllByUbicacion(@PathParam("ubicacion") String ubicacion) {
        return rep.find("ubicacion", ubicacion).list();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        var marcacion = rep.findByIdOptional(id);
        if (marcacion.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(marcacion.get()).build();
    }

    @POST
    public Response create(Marcacion marcacion) {
        rep.persist(marcacion);
        return Response.status(Response.Status.CREATED.getStatusCode(), "marcacion creada").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, Marcacion marcacion) {
        Marcacion marcacionaux = rep.findById(id);
        if (marcacionaux == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            marcacionaux.setId_usuario(marcacion.getId_usuario());
            marcacionaux.setFecha(marcacion.getFecha());
            marcacionaux.setHora(marcacion.getHora());
            marcacionaux.setTipo(marcacion.getTipo());
            marcacionaux.setUbicacion(marcacion.getUbicacion());
            marcacionaux.setImage_source(marcacion.getImage_source());
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
