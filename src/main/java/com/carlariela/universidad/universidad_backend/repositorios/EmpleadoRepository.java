package com.carlariela.universidad.universidad_backend.repositorios;

import com.carlariela.universidad.universidad_backend.modelo.entidades.Persona;
import com.carlariela.universidad.universidad_backend.modelo.entidades.enumeradores.TipoEmpleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends PersonaRepository{
    /*
    🚩 EmpleadoRepository:
    Agregar método "Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);",
    el cual a través de anotación @Query se debe de buscar los empleados que se encuentren asociados a dicho tipo de
    empleado el cual será ingresado por parámetro del método.
    */
    @Query("select e from Empleado e where e.tipoEmpleado = ?1")
    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);
}
