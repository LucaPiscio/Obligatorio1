package com.redsocial.rest;

import com.redsocial.model.Usuario;
import com.redsocial.service.GrafoSocial;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Collection;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRest {

    private GrafoSocial servicio = GrafoSocial.getInstance();

    @GET
    public Collection<Usuario> listarUsuarios() {
        return servicio.getTodos();
    }

    @GET
    @Path("/{id}")
    public Usuario obtener(@PathParam("id") int id) {
        Usuario u = servicio.getUsuario(id);
        if (u == null) throw new NotFoundException();
        return u;
    }

    @POST
    public Response crearUsuario(Usuario nuevo) {
        servicio.crearUsuario(nuevo.getId(), nuevo.getNombre());
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/{id}/seguir/{otroId}")
    public Response seguir(@PathParam("id") int id,
                           @PathParam("otroId") int otro) {
        servicio.seguir(id, otro);
        return Response.ok().build();
    }
}

