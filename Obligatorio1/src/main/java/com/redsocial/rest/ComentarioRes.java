package com.redsocial.rest;

import com.redsocial.model.*;
import com.redsocial.service.GrafoSocial;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/comentarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComentarioRes {

    private GrafoSocial servicio = GrafoSocial.getInstance();

    @POST
    @Path("/post/{postId}/usuario/{autorId}")
    public Comentario comentar(
            @PathParam("postId") int postId,
            @PathParam("autorId") int autorId,
            Comentario cBody
    ) {
        Usuario autor = servicio.getUsuario(autorId);
        if (autor == null) throw new NotFoundException();

        // Buscar el post
        Post post = null;
        for (Usuario u : servicio.getTodos()) {
            for (Post p : u.getPosts()) {
                if (p.getId() == postId) post = p;
            }
        }

        if (post == null) throw new NotFoundException();

        Comentario c = new Comentario(autor, cBody.getTexto());
        post.agregarComentario(c);

        return c;
    }
}

