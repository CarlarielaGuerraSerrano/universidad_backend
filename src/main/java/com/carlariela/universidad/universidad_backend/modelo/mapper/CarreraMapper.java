package com.carlariela.universidad.universidad_backend.modelo.mapper;

import com.carlariela.universidad.universidad_backend.modelo.dto.CarreraDTO;
import com.carlariela.universidad.universidad_backend.modelo.entidades.Carrera;

@Deprecated
public class CarreraMapper {
    public static CarreraDTO mapCarrera(Carrera carrera){
        CarreraDTO dto = new CarreraDTO();
        dto.setCodigo(carrera.getId());
        dto.setNombre(carrera.getNombre());
        dto.setCantidad_anios(carrera.getCantidadAnios());
        dto.setCantidad_materias(carrera.getCantidadMaterias());
        return dto;
    }


}
