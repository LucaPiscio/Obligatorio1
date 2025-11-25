package com.redsocial.rest;
import com.redsocial.service.GrafoSocial;
import com.redsocial.model.*;
import java.util.List;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/notificaciones")
@Produces(MediaType.APPLICATION_JSON)
public class NotificacionRes {

    private GrafoSocial servicio = GrafoSocial.getInstance();

    @GET
    @Path("/usuario/{id}")
    public List<Notificacion> obtener(@PathParam("id") int id) {
        Usuario u = servicio.getUsuario(id);
        if (u == null) throw new NotFoundException();
        return u.getNotificaciones();
    }
}

