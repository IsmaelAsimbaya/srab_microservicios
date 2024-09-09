package com.srab.usuarios.rest;

import com.srab.usuarios.clients.HorarioRestClient;
import com.srab.usuarios.clients.LoginRestClient;
import com.srab.usuarios.clients.LugarTrabajoRestClient;
import com.srab.usuarios.clients.MarcacionRestClient;
import com.srab.usuarios.db.Usuario;
import com.srab.usuarios.dtos.*;
import com.srab.usuarios.repo.UsuarioRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class UsuarioRest {

    @Inject
    UsuarioRepository rep;

    @Inject
    @RestClient
    LugarTrabajoRestClient lugarTrabajoClient;

    @Inject
    @RestClient
    HorarioRestClient horarioClient;

    @Inject
    @RestClient
    MarcacionRestClient marcacionClient;

    @Inject
    @RestClient
    LoginRestClient loginClient;

    @GET
    public List<UsuarioDto> findAll() {
        return rep.streamAll()
                .map(UsuarioRest::usuarioToDto)
                .map(usuarioDto -> {
                    completeDtoRestClient(usuarioDto);
                    return usuarioDto;
                })
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        var usuario = rep.findByIdOptional(id);
        if (usuario.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        UsuarioDto usuarioDto = usuarioToDto(usuario.get());
        completeDtoRestClient(usuarioDto);
        return Response.ok(usuarioDto).build();
    }

    @GET
    @Path("/raw")
    public List<Usuario> findAllRaw() {
        return rep.findAll().list();
    }

    @GET
    @Path("/raw/{id}")
    public Response getByIdRaw(@PathParam("id") Integer id) {
        var usuario = rep.findByIdOptional(id);
        if (usuario.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(usuario.get()).build();
    }

    @POST
    public Response create(Usuario usuario) {
        rep.persist(usuario);
        return Response.status(Response.Status.CREATED.getStatusCode(), "usuario creado").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, Usuario usuario) {
        Usuario user = rep.findById(id);

        user.setCi(usuario.getCi());
        user.setNombres(usuario.getNombres());
        user.setApellidos(usuario.getApellidos());
        user.setFecha_nacimiento(usuario.getFecha_nacimiento());
        user.setEmail(usuario.getEmail());
        user.setFace_source_url(usuario.getFace_source_url());
        user.setTelefono_movil(usuario.getTelefono_movil());
        user.setTelefono_fijo(usuario.getTelefono_fijo());
        user.setDireccion(usuario.getDireccion());
        user.setId_lugar(usuario.getId_lugar());
        user.setId_horario(usuario.getId_horario());

        return Response.status(Response.Status.OK.getStatusCode(), "usuario actualizado").build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        rep.deleteById(id);
        return Response.ok().build();
    }

    public static UsuarioDto usuarioToDto(Usuario usuario) {
        UsuarioDto dto = new UsuarioDto();

        dto.setId_usuario(usuario.getId_usuario());
        dto.setCi(usuario.getCi());
        dto.setNombres(usuario.getNombres());
        dto.setApellidos(usuario.getApellidos());
        dto.setFecha_nacimiento(usuario.getFecha_nacimiento());
        dto.setEmail(usuario.getEmail());
        dto.setFace_source_url(usuario.getFace_source_url());
        dto.setTelefono_movil(usuario.getTelefono_movil());
        dto.setTelefono_fijo(usuario.getTelefono_fijo());
        dto.setDireccion(usuario.getDireccion());
        dto.setId_lugar(usuario.getId_lugar());
        dto.setId_horario(usuario.getId_horario());
        return dto;
    }

    private void completeDtoRestClient(UsuarioDto usuarioDto) {
        LoginDto loginDto = loginClient.findByIdUsuario(usuarioDto.getId_usuario());
        LugarTrabajoDto lugarTrabajoDto = lugarTrabajoClient.getById(usuarioDto.getId_lugar());
        HorarioDto horarioDto = horarioClient.getById(usuarioDto.getId_horario());
        List<MarcacionDto> marcacionesdto = marcacionClient.findAllByIdUsuario(usuarioDto.getId_usuario());

        usuarioDto.setLogin(loginDto);
        usuarioDto.setLugarTrabajo(lugarTrabajoDto);
        usuarioDto.setHorario(horarioDto);
        usuarioDto.setMarcaciones(marcacionesdto);
    }


}
