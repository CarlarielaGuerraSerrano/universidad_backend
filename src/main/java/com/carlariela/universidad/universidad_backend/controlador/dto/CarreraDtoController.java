package com.carlariela.universidad.universidad_backend.controlador.dto;

import com.carlariela.universidad.universidad_backend.modelo.dto.CarreraDTO;
import com.carlariela.universidad.universidad_backend.modelo.entidades.Carrera;
import com.carlariela.universidad.universidad_backend.modelo.mapper.CarreraMapper;
import com.carlariela.universidad.universidad_backend.modelo.mapper.mapstruct.CarreraMapperMS;
import com.carlariela.universidad.universidad_backend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class CarreraDtoController {

    @Autowired
    private CarreraDAO carreraDAO;
    @Autowired
    private CarreraMapperMS mapper;

    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> mensaje = new HashMap();
        List<Carrera> carreras = (List<Carrera>) carreraDAO.findAll();

        List<CarreraDTO> carreraDTOS = carreras
                .stream()
                .map(mapper::mapCarrera)
                .collect(Collectors.toList());

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("data", carreraDTOS);

        return ResponseEntity.ok(mensaje);
    }

}
