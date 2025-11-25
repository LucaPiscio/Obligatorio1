package com.redsocial.service;

import com.redsocial.model.*;
import java.util.*;

public class GrafoSocial {

    private static GrafoSocial instance;
    private Map<Integer, Usuario> usuarios;

    private GrafoSocial() {
        usuarios = new HashMap<>();
    }

    public static GrafoSocial getInstance() {
        if (instance == null) instance = new GrafoSocial();
        return instance;
    }

    public Usuario crearUsuario(int id, String nombre) {
        Usuario u = new Usuario(id, nombre);
        usuarios.put(id, u);
        return u;
    }

    public Usuario getUsuario(int id) {
        return usuarios.get(id);
    }

    public Collection<Usuario> getTodos() {
        return usuarios.values();
    }

    public void seguir(int seguidorId, int seguidoId) {
        Usuario a = getUsuario(seguidorId);
        Usuario b = getUsuario(seguidoId);
        if (a == null || b == null) return;

        a.getSeguidos().add(b);
        b.getSeguidores().add(a);

        b.agregarNotificacion(
            new Notificacion("Nuevo seguidor: " + a.getNombre())
        );
    }
}
