package com.redsocial.model;

import java.time.LocalDateTime;

public class Notificacion {
    private String mensaje;
    private LocalDateTime fecha;
    private boolean leida;

    public Notificacion(String mensaje) {
        this.mensaje = mensaje;
        this.fecha = LocalDateTime.now();
        this.leida = false;
    }

    public void marcarLeida() { this.leida = true; }
    public LocalDateTime getFecha(){return fecha;}
    public boolean isLeida(){return leida;}
    public String getMensaje() { return mensaje; }
}
