package com.carlariela.universidad.universidad_backend.controlador;

import com.carlariela.universidad.universidad_backend.exception.BadRequestException;
import com.carlariela.universidad.universidad_backend.modelo.entidades.Alumno;
import com.carlariela.universidad.universidad_backend.modelo.entidades.Carrera;
import com.carlariela.universidad.universidad_backend.modelo.entidades.Persona;
import com.carlariela.universidad.universidad_backend.servicios.contratos.CarreraDAO;
import com.carlariela.universidad.universidad_backend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController extends PersonaController{

    // Capa Rest para Alumno

    // private final PersonaDAO alumnoDao;       // Utilizamos --> "final" para generarlo via el constructor
    private final CarreraDAO carreraDAO;

    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDao, CarreraDAO carreraDAO) {
        super(alumnoDao);
        nombreEntidad = "Alumno";
        this.carreraDAO = carreraDAO;
    }

    /*
    @GetMapping
    public List<Persona> obtenerTodos(){
        // List<Persona> alumnos = alumnoDao.findAll();                   --> sin casteo
        List<Persona> alumnos = (List<Persona>) alumnoDao.findAll();   // --> con casteo
        if (alumnos.isEmpty()){
            throw new BadRequestException("No existe alumnos");
        }
        return alumnos;
    }

    @GetMapping("/{id}")
    public Persona obtenerAlumnoPorId(@PathVariable(required = false) Integer id){
        Optional<Persona> oAlumno = alumnoDao.findById(id);
        if(!oAlumno.isPresent()){
            throw new BadRequestException(String.format("Alumno con id %d no existe", id));
        }
        return oAlumno.get();
    }

    @PostMapping
    public Persona altaAlumno(@RequestBody Persona alumno){
        return alumnoDao.save(alumno);
    }
    */

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno){
        Map<String, Object> mensaje = new HashMap<>();
        Persona alumnoUpdate = null;
        Optional<Persona> oAlumno = service.findById(id);
        if (!oAlumno.isPresent()){
            // throw new BadRequestException(String.format("Alumno con id %d no existe", id));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("Alumno con id %d no existe", id));
            return ResponseEntity.badRequest().body(mensaje);
        }

        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());

        mensaje.put("datos", service.save(alumnoUpdate));
        mensaje.put("success", Boolean.TRUE);

        return ResponseEntity.ok(mensaje);
    }


    /*
    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Integer id){
        alumnoDao.deleteById(id);
    }
    */

    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public  ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Map<String, Object> mensaje = new HashMap<>();
        Optional<Persona> oALumno = service.findById(idAlumno);
        if (!oALumno.isPresent()){
            // throw new BadRequestException(String.format("Alumno con id %d no existe", idAlumno));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("Alumno con id %d no existe", idAlumno));
            return ResponseEntity.badRequest().body(mensaje);
        }

        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if (!oCarrera.isPresent()){
            // throw new BadRequestException(String.format("Carrera con id %d no existe", idCarrera));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("Carrera con id %d no existe", idCarrera));
            return ResponseEntity.badRequest().body(mensaje);
        }

        Persona alumno = oALumno.get();
        Carrera carrera = oCarrera.get();

        ((Alumno) alumno).setCarrera(carrera);   // casteo para llegar a setCarrera

        mensaje.put("datos", service.save(alumno));
        mensaje.put("success", Boolean.TRUE);

        return ResponseEntity.ok(mensaje);
    }


}
