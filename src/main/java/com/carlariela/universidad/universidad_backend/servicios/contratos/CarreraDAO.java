package com.carlariela.universidad.universidad_backend.servicios.contratos;

import com.carlariela.universidad.universidad_backend.modelo.entidades.Carrera;

import java.util.Optional;

public interface CarreraDAO extends GenericoDAO<Carrera>{
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

}
