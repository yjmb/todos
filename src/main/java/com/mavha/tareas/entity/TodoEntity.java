package com.mavha.tareas.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class TodoEntity implements Serializable {

    private static final long serialVersionUID = 4894729030347835498L;

    @Id
    @GeneratedValue
    private Long id;
    private String descripcion;
    private String estado;
    private String foto;

    public TodoEntity() {
    }

    public TodoEntity(String descripcion, String estado, String foto) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.foto = foto;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
