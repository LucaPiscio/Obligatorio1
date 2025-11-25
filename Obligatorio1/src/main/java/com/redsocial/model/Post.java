package com.redsocial.model;

import java.time.LocalDateTime;
import java.util.*;

public class Post {
    private int id;
    private Usuario autor;
    private String contenido;
    private LocalDateTime fecha;
    private List<Comentario> comentarios;

    public Post(int id, Usuario autor, String contenido) {
        this.id = id;
        this.autor = autor;
        this.contenido = contenido;
        this.fecha = LocalDateTime.now();
        this.comentarios = new ArrayList<>();
    }

    public void agregarComentario(Comentario c) {
        comentarios.add(c);

        // Notificación al autor
        autor.agregarNotificacion(
            new Notificacion("Nuevo comentario de " + c.getAutor().getNombre())
        );
    }

    public List<Comentario> getComentarios() { return comentarios; }
    public int getId() {return id;}
    public LocalDateTime getFecha(){return fecha;}
    public String getContenido(){return contenido;}
}
