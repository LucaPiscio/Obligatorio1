package com.redsocial.rest;

import com.redsocial.model.*;
import com.redsocial.service.GrafoSocial;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioPost {

    private GrafoSocial servicio = GrafoSocial.getInstance();

    @POST
    @Path("/usuario/{id}")
    public Post crearPost(@PathParam("id") int id, Post p) {
        Usuario u = servicio.getUsuario(id);
        if (u == null) throw new NotFoundException();

        Post nuevo = new Post(p.getId(), u, p.getContenido());
        u.agregarPost(nuevo);

        return nuevo;
    }
}

