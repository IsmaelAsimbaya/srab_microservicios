package com.srab.logins.rest;

import com.srab.logins.db.Login;
import com.srab.logins.repo.LoginRepository;
import com.srab.logins.request.LoginRequest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDateTime;
import java.util.List;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class LoginRest {

    @Inject
    LoginRepository rep;

    @GET
    public List<Login> findAll() {
        return rep.findAll().list();
    }

    @GET
    @Path("/id_usuario/{id_usuario}")
    public Login findByIdUsuario(@PathParam("id_usuario") Integer id_usuario) {
        return rep.find("id_usuario", id_usuario).singleResult();
    }

    @GET
    @Path("/username/{username}")
    public Login findByUsername(@PathParam("username") String username) {
        return rep.find("username", username).singleResult();
    }

    @GET
    @Path("/is_active/{is_active}")
    public List<Login> findByIsActive(@PathParam("is_active") boolean isActive) {
        return rep.find("is_active", isActive).list();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        var login = rep.findByIdOptional(id);
        if (login.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(login.get()).build();
    }

    @POST
    public Response create(LoginRequest request) {
        Login login = loginRequestToLogin(request);
        rep.persist(login);
        return Response.status(Response.Status.CREATED.getStatusCode(), "login creado").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, LoginRequest request) {
        Login login = rep.findById(id);
        if (login == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            Login loginaux = loginRequestToLogin(request);
            login.setUsername(loginaux.getUsername());
            login.setPassword_hash(loginaux.getPassword_hash());
            login.setSalt(loginaux.getSalt());
            login.setRoles(loginaux.getRoles());
            login.setIs_active(loginaux.getIs_active());
        }
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}/active/{isActive}")
    public Response updateIsActive(@PathParam("id") Integer id, @PathParam("isActive") boolean isActive) {
        Login login = rep.findById(id);
        if (login == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            login.setIs_active(isActive);
        }
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        rep.deleteById(id);
        return Response.ok().build();
    }

    public static Login loginRequestToLogin(LoginRequest request) {
        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(request.getPassword(), salt);
        Login login = new Login();
        login.setId_usuario(request.getId_usuario());
        login.setUsername(request.getUsername());
        login.setPassword_hash(hashedPassword);
        login.setSalt(salt);
        login.setRoles(request.getRoles());
        login.setLast_login(LocalDateTime.now());
        login.setIs_active(request.getIs_active());
        return login;
    }

}
