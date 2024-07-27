package com.carlariela.universidad.universidad_backend.servicios.implementaciones;

import com.carlariela.universidad.universidad_backend.modelo.entidades.Persona;
import com.carlariela.universidad.universidad_backend.repositorios.PersonaRepository;
import com.carlariela.universidad.universidad_backend.repositorios.ProfesorRepository;
import com.carlariela.universidad.universidad_backend.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorDAOImple extends PersonaDAOImpl implements ProfesorDAO {

    @Autowired
    public ProfesorDAOImple(@Qualifier("profesorRepository") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Persona> findProfesoresByCarrera(String nombre) {
        return ((ProfesorRepository)repository).findProfesoresByCarrera(nombre);
    }

}
