package com.carlariela.universidad.universidad_backend.controlador;

import com.carlariela.universidad.universidad_backend.exception.BadRequestException;
import com.carlariela.universidad.universidad_backend.servicios.contratos.GenericoDAO;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericController <E, S extends GenericoDAO<E>>{

    // Controller Refactor

    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> mensaje = new HashMap<>();
        List<E> listado = (List<E>) service.findAll();

        if (listado.isEmpty()){
            // throw new BadRequestException(String.format("No se han encontrado %ss", nombreEntidad));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No existen %ss", nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", listado);

        return ResponseEntity.ok(mensaje);
    }

    // obtenerPorId (Id)

    // borrarEntidadPorId (Id)

    // altaEntidad (Entidad)


}






