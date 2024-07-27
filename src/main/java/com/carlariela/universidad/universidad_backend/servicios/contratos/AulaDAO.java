package com.carlariela.universidad.universidad_backend.servicios.contratos;

import com.carlariela.universidad.universidad_backend.modelo.entidades.Aula;
import com.carlariela.universidad.universidad_backend.modelo.entidades.enumeradores.Pizarron;

import java.util.Optional;

public interface AulaDAO extends GenericoDAO<Aula> {

    Iterable<Aula> findAulasByPizarron(Pizarron pizarron);
    Iterable<Aula> findAulasByPabellonNombre(String nombre);
    Optional<Aula> findAulaByNroAula(Integer nroAula);

}
