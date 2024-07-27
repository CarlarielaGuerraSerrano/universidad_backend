package com.carlariela.universidad.universidad_backend.repositorios;

import com.carlariela.universidad.universidad_backend.datos.DatosDummy;
import com.carlariela.universidad.universidad_backend.modelo.entidades.Empleado;
import com.carlariela.universidad.universidad_backend.modelo.entidades.Persona;
import com.carlariela.universidad.universidad_backend.modelo.entidades.Profesor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.carlariela.universidad.universidad_backend.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonaRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepository;

    @Autowired
    @Qualifier("empleadoRepository")
    PersonaRepository empleadoRepository;

    @Autowired
    @Qualifier("profesorRepository")
    PersonaRepository profesorRepository;



    @Test
    void buscarPorNombreYApellido() {

        // Given
        Persona save = empleadoRepository.save(empleado01());

        //When
        Optional<Persona> expected = empleadoRepository.buscarPorNombreYApellido(empleado01().getNombre(),
                empleado01().getApellido());

        //Then
        assertThat(expected.get()).isInstanceOf(Empleado.class);
        assertThat(expected.get()).isEqualTo(save);
    }


    @Test
    void buscarPorDni() {

        // Given
        Persona save = profesorRepository.save(profesor01()); // extrayendo de manera "estatica" los "DatosDummy".

        // When
        Optional<Persona> expected = profesorRepository.buscarPorDni(profesor01().getDni());

        // Then
        assertThat(expected.get()).isInstanceOf(Profesor.class);
        assertThat(expected.get()).isEqualTo(save);
        assertThat(expected.get().getDni()).isEqualTo(save.getDni());

    }

    @Test
    void buscarPersonaPorApellido() {

        // Given
        Iterable<Persona> personas = alumnoRepository.saveAll(
                Arrays.asList(alumno01(), alumno02(), alumno03())
        );

        // When
        String apellido = "Lopez";
        List<Persona> expected = (List<Persona>) alumnoRepository.buscarPersonaPorApellido(apellido);

        // Then
        assertThat(expected.size() == 2).isTrue();
    }


}