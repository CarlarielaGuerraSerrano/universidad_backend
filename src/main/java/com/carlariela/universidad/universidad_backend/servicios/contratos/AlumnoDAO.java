package com.carlariela.universidad.universidad_backend.servicios.contratos;

import com.carlariela.universidad.universidad_backend.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO{
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);

}
