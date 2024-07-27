package com.carlariela.universidad.universidad_backend.repositorios;

import com.carlariela.universidad.universidad_backend.modelo.entidades.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CarreraRepository extends CrudRepository<Carrera, Integer> {
    
    // 📌 Repositorios --> Consultas a traves de Metodos


    /*
    🚩 CarreraRepository:
    Agregar método "Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);",
    el cual a través de anotación @Query se debe de buscar las carreras que se encuentren asociados a dicho profesor,
    buscando al mismo por nombre y apellido, los cuales serán ingresados por parámetros del método.
    */
    
    //@Query("select c from Carrera c where c.nombre like %?1%")
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    
    //@Query("select c from Carrera c where upper(c.nombre) like upper(%?1%)")
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    
    //@Query("select c from Carrera c where c.cantidadAnios > ?1")
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

}