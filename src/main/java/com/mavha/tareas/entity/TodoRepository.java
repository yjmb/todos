package com.mavha.tareas.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

   @Override
    List<TodoEntity> findAll();

    @Query("SELECT d FROM TodoEntity  d WHERE d.descripcion like %:desc%")
    List<TodoEntity> findByDescripcion(@Param("desc") String desc);

    @Query("SELECT d FROM TodoEntity  d WHERE d.estado =:estado")
    List<TodoEntity> findByEstado(@Param("estado") String estado);

    @Query("SELECT d FROM TodoEntity  d WHERE d.descripcion like %:desc% and d.estado =:estado")
    List<TodoEntity> findByDescripcionEstado(@Param("desc") String desc, @Param("estado") String estado);

}
