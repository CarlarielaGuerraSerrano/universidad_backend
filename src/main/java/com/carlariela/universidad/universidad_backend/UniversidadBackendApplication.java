package com.carlariela.universidad.universidad_backend;

import com.carlariela.universidad.universidad_backend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UniversidadBackendApplication {

	public static void main(String[] args) {

		String[] beanDefinitionNames = SpringApplication.run(UniversidadBackendApplication.class, args).getBeanDefinitionNames();
		/*
		for (String str : beanDefinitionNames){
			System.out.println(str);
		}
		*/
	}

}






