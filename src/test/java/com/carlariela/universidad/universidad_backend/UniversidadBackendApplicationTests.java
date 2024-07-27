package com.carlariela.universidad.universidad_backend;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class UniversidadBackendApplicationTests {

	Calculadora calculadora = new Calculadora();

	@Test
	@DisplayName("Suma de valorA y valorB")
	void sumaDeValores() {

		// ✏️ Given  --> Definimos nuestro contexto o precondicion
		int valorA = 2;
		int valorB = 3;

		// ✏️ When  --> Ejecutamos la accion que queremos hacer o lo que queremos probar
		int expectativa = calculadora.sumar(valorA, valorB);

		// ✏️ Then  --> Para validar que sea correcto lo que queremos probar, en este caso el "assertThat"
		int resultadoEsperado = 5;
		assertThat(expectativa).isEqualTo(resultadoEsperado);
	}


	@Test
	@DisplayName("Test deprecado")
	@Disabled("Test deprecado")
	void testDesactivado(){

	}



	class Calculadora{
		int sumar(int valor_a, int valor_b){
			return valor_a + valor_b;
		}
	}



}