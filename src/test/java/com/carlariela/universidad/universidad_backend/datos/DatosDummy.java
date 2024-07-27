package com.carlariela.universidad.universidad_backend.datos;

import com.carlariela.universidad.universidad_backend.modelo.entidades.*;
import com.carlariela.universidad.universidad_backend.modelo.entidades.enumeradores.TipoEmpleado;

import java.math.BigDecimal;

import static com.carlariela.universidad.universidad_backend.modelo.entidades.enumeradores.TipoEmpleado.*;

public class DatosDummy {
    
    // 🚸 Carrera :
    public static Carrera carrera01(boolean conId){
        Carrera carrera = (conId) ? new Carrera(1, "Ingenieria en Sistemas", 50, 5):
                new Carrera(null, "Ingenieria en Sistemas", 50, 5);
        return carrera;
    }
    public static Carrera carrera02(){
        return new Carrera(null, "Licenciatura en Sistemas", 45, 4);
    }
    public static Carrera carrera03(boolean conId){
        Carrera carrera = (conId) ? new Carrera(3, "Ingenieria Industrial", 60, 5):
                new Carrera(null, "Ingenieria Industrial", 60, 5);
        return carrera;
    }


    // 🚸 Empleado :
    public static Persona empleado01(){
        return new Empleado(null, "Juan", "Lopez", "25174036", new Direccion(), new BigDecimal("46750.70"), ADMINISTRATIVO);
    }
    public static Persona empleado02(){
        return new Empleado(null, "Damian", "Lopez", "25172030", new Direccion(), new BigDecimal("46750.70"), MANTENIMIENTO);
    }

    // 🚸 Profesor :
    public static Persona profesor01(){
        return new Profesor(null, "Martin","Guerra", "33908461", new Direccion(), new BigDecimal("60000.00"));
    }

    // 🚸 Alumno :
    public static Persona alumno01(){
        return new Alumno(null, "Andres", "Sandoval", "44908461", new Direccion());
    }
    public static Persona alumno02(){
        return new Alumno(null, "Jhon", "Sandoval", "45908461", new Direccion());
    }
    public static Persona alumno03(){
        return new Alumno(null, "Joaquin", "Gutierrez", "46908461", new Direccion());
    }


}