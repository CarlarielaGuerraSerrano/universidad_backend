package com.carlariela.universidad.universidad_backend.repositorios;

import com.carlariela.universidad.universidad_backend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository{
    // @Query("select a from Alumno a where a.carrera.nombre = ?1")
    @Query("select a from Alumno a join fetch a.carrera c where c.nombre = ?1")
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);

}
