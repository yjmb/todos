package com.mavha.tareas.dto;

public class TodoResponse {
    private Long id;
    private String descripcion;
    private String estado;
    private String foto;

    public TodoResponse() {
    }

    public TodoResponse(Long id, String descripcion, String estado, String foto) {
        this.id = id;
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
