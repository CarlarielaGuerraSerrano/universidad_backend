package com.carlariela.universidad.universidad_backend.servicios.contratos;


import com.carlariela.universidad.universidad_backend.modelo.entidades.Persona;
import com.carlariela.universidad.universidad_backend.modelo.entidades.enumeradores.TipoEmpleado;

public interface EmpleadoDAO extends PersonaDAO {

    Iterable<Persona> findEmpleadosByTipo(TipoEmpleado tipo);

}
