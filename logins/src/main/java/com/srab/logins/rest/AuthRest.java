package com.srab.logins.rest;

import com.srab.logins.db.Login;
import com.srab.logins.repo.LoginRepository;
import com.srab.logins.request.AuthRequest;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDateTime;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class AuthRest {

    @Inject
    LoginRepository rep;

    @POST
    @Path("/login")
    public Response authenticate(AuthRequest request) {
        Login user;

        try {
            user = rep.find("username", request.getUsername()).singleResult();
        } catch (NoResultException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("username o password incorrectos").build();
        }

        String hashedPassword = BCrypt.hashpw(request.getPassword(), user.getSalt());

        if (!hashedPassword.equals(user.getPassword_hash())) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("username o password incorrectos").build();
        }

        if (!user.getIs_active()) {
            return Response.status(Response.Status.FORBIDDEN).entity("Cuenta no activa").build();
        }

        user.setLast_login(LocalDateTime.now());
        rep.persist(user);

        return Response.ok("Login successful").build();
    }
}
