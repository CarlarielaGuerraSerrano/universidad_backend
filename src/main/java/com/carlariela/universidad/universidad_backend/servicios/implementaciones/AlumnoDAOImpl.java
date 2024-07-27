package com.carlariela.universidad.universidad_backend.servicios.implementaciones;

import com.carlariela.universidad.universidad_backend.modelo.entidades.Persona;
import com.carlariela.universidad.universidad_backend.repositorios.AlumnoRepository;
import com.carlariela.universidad.universidad_backend.repositorios.PersonaRepository;
import com.carlariela.universidad.universidad_backend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO {
    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos")PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre) {
        return ((AlumnoRepository)repository).buscarAlumnosPorNombreCarrera(nombre);
    }

}
