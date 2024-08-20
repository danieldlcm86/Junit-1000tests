package org.generation.calculator.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.generation.calculator.main.CalculatorOneThousand;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class CalculatorTest {

	// @TestFactory indica que no es una prueba en sí misma, sino un generador de pruebas. Este método devuelve un flujo (Stream) de pruebas dinámicas (DynamicTest).
	@TestFactory
	Stream<DynamicTest> dynamicTests() {
		
		// Instanciar objeto de CalculatorOneThousand
		CalculatorOneThousand calculator = new CalculatorOneThousand();
		
		// Crear Listas de tipo Entero para definir el rango de entrada y rango total de pruebas unitarias (1000 test)
		// Se genera una lista de enteros que va de 0 a 999 utilizando IntStream.range(0, 1000). Luego, se convierte cada número a su tipo envoltorio (Integer) usando boxed().
		List<Integer> entradas = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
		// Se genera otra lista de enteros que contiene los resultados de multiplicar cada número en entradas por 2 (pueden modificar el 2 por cualquier número).
		List<Integer> resultados = IntStream.range(0, 1000).map(n -> n * 2).boxed().collect(Collectors.toList());
		
		// Se convierte la lista de entradas en un flujo (Stream).
		return entradas.stream()
				// Se mapea cada número en entradas a una prueba dinámica (DynamicTest). Para cada número, se crea una prueba con un nombre como "multiplicando: [número]".
				.map(numero -> DynamicTest.dynamicTest("multiplicando: " + numero, 
						() -> {
							// Dentro de cada prueba dinámica, se llama al método multiplica(numero, 2) del objeto calculator y se compara el resultado con el valor correspondiente en la lista resultados usando assertEquals.
							assertEquals(calculator.multiplica(numero, 2), resultados.get(numero));
						}));
	}

}
