package com.carlariela.universidad.universidad_backend.repositorios;

import com.carlariela.universidad.universidad_backend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends PersonaRepository{
    
    /*
    🚩 ProfesorRepository:
    Agregar método "Iterable<Persona> findProfesoresByCarrera(String carrera)", el cual a través de anotación @Query se 
    debe de buscar los profesores que se encuentren asociados a dicha carrera donde el nombre 
    de la misma sea igual al ingresado en el parámetro del método.
    */
    
    @Query("select p from Profesor p join fetch p.carreras c where c.nombre = ?1")
        //@Query("select p from Profesor p  where p.carreras.id = ?1")
    Iterable<Persona> findProfesoresByCarrera(String carrera);
}