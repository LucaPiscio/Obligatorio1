package com.redsocial.model;
import java.util.List;
import java.time.LocalDateTime;

public class Comentario {
    private Usuario autor;
    private String texto;
    private LocalDateTime fecha;
    private List<Comentario> respuestas;

    public Comentario(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
        this.fecha = LocalDateTime.now();
    }

    public Usuario getAutor() { return autor; }
    public String getTexto(){return texto;}
    public LocalDateTime getFecha(){return fecha;}
    public List<Comentario> getRespuestas() { return respuestas; }
}

