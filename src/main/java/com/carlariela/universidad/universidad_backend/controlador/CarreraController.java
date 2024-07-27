package com.carlariela.universidad.universidad_backend.controlador;

import com.carlariela.universidad.universidad_backend.exception.BadRequestException;
import com.carlariela.universidad.universidad_backend.modelo.entidades.Carrera;
import com.carlariela.universidad.universidad_backend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Deprecated
@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "false")
public class CarreraController extends GenericController<Carrera, CarreraDAO>{

    // Capa Rest para Carrera

    @Autowired
    public CarreraController(CarreraDAO service) {
        super(service);
        nombreEntidad = "carrera";
    }

    /*
    @GetMapping("/{codigo}")
    public  Carrera obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id){
        Optional<Carrera> oCarrera = service.findById(id);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("La carrera con id %d no existe", id));
        }
        return oCarrera.get();
    }

    @PostMapping
    public Carrera altaCarrera(@RequestBody Carrera carrera){
        if (carrera.getCantidadAnios() < 0){
            throw new BadRequestException("El campo cantidad de años no puede ser negativo");
        }
        if (carrera.getCantidadMaterias() < 0){
            throw new BadRequestException("El campo cantidad de materias no puede ser negativo");
        }
        return service.save(carrera);
    }
    */

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera){
        Map<String, Object> mensaje = new HashMap<>();
        Carrera carreraUpdate = null;
        Optional<Carrera> oCarrera = service.findById(id);

        if (!oCarrera.isPresent()){
            // throw new BadRequestException(String.format("La carrera con id %d no existe", id));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("%s con ID %d no existe", nombreEntidad, id));
            return ResponseEntity.badRequest().body(mensaje);
        }

        carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());

        mensaje.put("datos", service.save(carreraUpdate));
        mensaje.put("success", Boolean.TRUE);

        return ResponseEntity.ok(mensaje);
    }

    /*
    @DeleteMapping("/{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        service.deleteById(id);
    }
    */


}
