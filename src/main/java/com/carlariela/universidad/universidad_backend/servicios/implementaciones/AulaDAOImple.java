package com.carlariela.universidad.universidad_backend.servicios.implementaciones;
import com.carlariela.universidad.universidad_backend.modelo.entidades.Aula;
import com.carlariela.universidad.universidad_backend.modelo.entidades.enumeradores.Pizarron;
import com.carlariela.universidad.universidad_backend.repositorios.AulaRepository;
import com.carlariela.universidad.universidad_backend.servicios.contratos.AulaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AulaDAOImple extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO {

    @Autowired
    public AulaDAOImple(AulaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Aula> findAulasByPizarron(Pizarron pizarron) {
        return repository.findAulasByPizarron(pizarron);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Aula> findAulasByPabellonNombre(String nombre) {
        return repository.findAulasByPabellon_Nombre(nombre);
    }

    @Override
    public Optional<Aula> findAulaByNroAula(Integer nroAula) {
        return repository.findAulaByNroAula(nroAula);
    }

}
