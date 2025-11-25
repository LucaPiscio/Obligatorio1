package com.redsocial.model;
import java.util.*;

public class Usuario {
    private final int id;
    private String nombre;

    // Relaciones del grafo
    private Set<Usuario> seguidores;   // inbound edges (quién me sigue)
    private Set<Usuario> seguidos;     // outbound edges (a quién sigo)
    private Set<Usuario> amigos;       // aristas no dirigidas

    // Contenido
    private List<Post> posts;
    private List<Notificacion> notificaciones;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;

        this.seguidores = new HashSet<>();
        this.seguidos = new HashSet<>();
        this.amigos = new HashSet<>();

        this.posts = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

    public Set<Usuario> getSeguidores() { return seguidores; }
    public Set<Usuario> getSeguidos() { return seguidos; }
    public Set<Usuario> getAmigos() { return amigos; }

    public List<Post> getPosts() { return posts; }
    public List<Notificacion> getNotificaciones() { return notificaciones; }

    public void agregarPost(Post p) {
        posts.add(p);
    }

    public void agregarNotificacion(Notificacion n) {
        notificaciones.add(n);
    }
}

