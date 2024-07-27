package com.carlariela.universidad.universidad_backend.repositorios;

import com.carlariela.universidad.universidad_backend.modelo.entidades.Aula;
import com.carlariela.universidad.universidad_backend.modelo.entidades.enumeradores.Pizarron;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AulaRepository extends CrudRepository<Aula, Integer> {

    /*
    🚩 AulaRepository:

    1.- Agregar método para buscar las aulas que correspondan al tipo de pizarrón ingresado por parámetro,
    el cual debe de realizarse a través de Query Method.

    2.- Agregar método para buscar las aulas que correspondan al nombre de cierto pabellón ingresado por parámetro,
    el cual debe de realizarse a través de Query Method.

    3.- Agregar método para buscar el aula que corresponda al numero de aula ingresado por parámetro,
    el cual debe de realizarse a través de Query Method.
    */

    Iterable<Aula> findAulasByPizarron(Pizarron pizarron);
    Iterable<Aula> findAulasByPabellon_Nombre(String nombre);
    Optional<Aula> findAulaByNroAula(Integer nroAula);

}
