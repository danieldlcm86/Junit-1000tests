package org.generation.calculator.main;

public class CalculatorOneThousand {
	// Método para sumar dos enteros
	public int suma(int a, int b) {
        return a + b;
    }

    public int resta(int a, int b) {
        return a - b;
    }

    public int multiplica(int a, int b) {
        return a * b;
    }

    // Método para dividir flotantes y mostrar una excepción si es necesario
    public float divide(float a, float b) {

        if (b == 0) {
            throw new IllegalArgumentException("No es posible dividir un valor entre 0");
        }

        return a / b;
    }
}
