package com.carlariela.universidad.universidad_backend.repositorios;

import com.carlariela.universidad.universidad_backend.modelo.entidades.Pabellon;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PabellonRepository extends CrudRepository<Pabellon, Integer> {

    /*
    🚩 PabellonRepository:

    1.- Agregar método para buscar el/los pabellón/es que se encuentran en una localidad en particular la cual será
    ingresada por parámetro, el cual debe de realizarse a través de Query Method.

    2.- Agregar método para buscar el/los pabellón/es por un nombre de pabellón en particular la cual será ingresada
    por parámetro, el cual debe de realizarse a través de Query Method.

    */

    Iterable<Pabellon> findPabellonsByDireccion_Localidad(String localidad);
    Optional<Pabellon> findPabellonByNombreIgnoreCase(String nombre);
    Iterable<Pabellon> findPabellonsByFechaAltaBetween(LocalDateTime desde, LocalDateTime hasta);

}
