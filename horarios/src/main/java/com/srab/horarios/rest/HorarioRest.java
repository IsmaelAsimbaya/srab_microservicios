package com.srab.horarios.rest;

import com.srab.horarios.db.DiaHorario;
import com.srab.horarios.db.Horario;
import com.srab.horarios.dtos.DiaHorarioDTO;
import com.srab.horarios.dtos.HorarioDTO;
import com.srab.horarios.repo.HorarioRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/horario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class HorarioRest {

    @Inject
    HorarioRepository rep;

    @GET
    public List<HorarioDTO> findAll() {
        List<Horario> horarios = rep.findAll().list();
        return horarios.stream()
                .map(HorarioRest::mapToDTO)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        var horario = rep.findByIdOptional(id);
        if (horario.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        HorarioDTO horarioDTO = mapToDTO(horario.get());
        return Response.ok(horarioDTO).build();
    }

    @POST
    public Response create(Horario horario) {
        for (DiaHorario diaHorario : horario.getDiasHorario()) {
            diaHorario.setHorario(horario);
        }
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
            horarioaux.setNombre(horario.getNombre());
            horarioaux.getDiasHorario().clear();
            for (DiaHorario diaHorario : horario.getDiasHorario()) {
                diaHorario.setHorario(horarioaux);
                horarioaux.getDiasHorario().add(diaHorario);
            }
            rep.persist(horarioaux);
        }
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        rep.deleteById(id);
        return Response.ok().build();
    }

    private static HorarioDTO mapToDTO(Horario horario) {
        HorarioDTO horarioDTO = new HorarioDTO();
        horarioDTO.setId_horario(horario.getId_horario());
        horarioDTO.setNombre(horario.getNombre());
        List<DiaHorarioDTO> diasHorarioDTO = horario.getDiasHorario().stream()
                .map(HorarioRest::mapDiaHorarioToDTO)
                .collect(Collectors.toList());
        horarioDTO.setDiasHorario(diasHorarioDTO);
        return horarioDTO;
    }

    private static DiaHorarioDTO mapDiaHorarioToDTO(DiaHorario diaHorario) {
        DiaHorarioDTO diaHorarioDTO = new DiaHorarioDTO();
        diaHorarioDTO.setDiaSemana(diaHorario.getDiaSemana());
        diaHorarioDTO.setHoraEntrada(diaHorario.getHoraEntrada());
        diaHorarioDTO.setHoraSalida(diaHorario.getHoraSalida());
        return diaHorarioDTO;
    }
}
