package com.carlariela.universidad.universidad_backend.servicios.contratos;


import com.carlariela.universidad.universidad_backend.modelo.entidades.Persona;

public interface ProfesorDAO extends PersonaDAO {

    Iterable<Persona> findProfesoresByCarrera(String nombre);
}
