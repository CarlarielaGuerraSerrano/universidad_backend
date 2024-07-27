package com.carlariela.universidad.universidad_backend.servicios.contratos;

import com.carlariela.universidad.universidad_backend.modelo.entidades.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona>{
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    Optional<Persona> buscarPorDni(String dni);
    Iterable<Persona> buscarPersonaPorApellido(String apellido);

}
