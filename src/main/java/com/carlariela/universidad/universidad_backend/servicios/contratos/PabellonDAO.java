package com.carlariela.universidad.universidad_backend.servicios.contratos;


import com.carlariela.universidad.universidad_backend.modelo.entidades.Pabellon;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PabellonDAO extends GenericoDAO<Pabellon> {

    Iterable<Pabellon> buscarPabellonesPorLocalidad(String localidad);
    Optional<Pabellon> findPabellonByNombreIgnoreCase(String nombre);
    Iterable<Pabellon> findPabellonsByFechaAltaBetween(LocalDateTime desde, LocalDateTime hasta);

}
