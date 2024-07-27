package com.carlariela.universidad.universidad_backend.servicios.implementaciones;

import com.carlariela.universidad.universidad_backend.modelo.entidades.Persona;
import com.carlariela.universidad.universidad_backend.modelo.entidades.enumeradores.TipoEmpleado;
import com.carlariela.universidad.universidad_backend.repositorios.EmpleadoRepository;
import com.carlariela.universidad.universidad_backend.repositorios.PersonaRepository;
import com.carlariela.universidad.universidad_backend.servicios.contratos.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoDAOImple extends PersonaDAOImpl implements EmpleadoDAO {

    @Autowired
    public EmpleadoDAOImple(@Qualifier("empleadoRepository") PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Persona> findEmpleadosByTipo(TipoEmpleado tipo) {
        return ((EmpleadoRepository)repository).findEmpleadoByTipoEmpleado(tipo);
    }

}
