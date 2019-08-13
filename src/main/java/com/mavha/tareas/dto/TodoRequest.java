package com.mavha.tareas.dto;

import javax.validation.constraints.NotNull;

public class TodoRequest {
    private Long id;

    @NotNull(message="La desripción de la tarea es requerida")
    private String descripcion;

    @NotNull(message="El estado de la tarea es requerido")
    private String estado;
    private String foto;

    public TodoRequest() {
    }

    public TodoRequest(String descripcion, String estado, String foto) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
