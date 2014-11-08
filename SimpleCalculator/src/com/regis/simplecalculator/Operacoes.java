package com.regis.simplecalculator;

public class Operacoes {
	private static double resultado = 0;

	public static String somar(String v1, String v2) {
		double valor1 = Double.parseDouble(v1);
		double valor2 = Double.parseDouble(v2);
		resultado = valor1 + valor2;
		return String.valueOf(resultado);

	}

	public static String subtrair(String v1, String v2) {
		double valor1 = Double.parseDouble(v1);
		double valor2 = Double.parseDouble(v2);
		resultado = valor1 - valor2;
		return String.valueOf(resultado);
	}

	public static String multiplicar(String v1, String v2) {
		double valor1 = Double.parseDouble(v1);
		double valor2 = Double.parseDouble(v2);
		resultado = valor1 * valor2;
		return String.valueOf(resultado);
	}

	public static String dividir(String v1, String v2) {
		if (v2.equals("0")) {
			return "Num Div Zero!";
		} else {
			double valor1 = Double.parseDouble(v1);
			double valor2 = Double.parseDouble(v2);
			resultado = valor1 / valor2;
			return String.valueOf(resultado);
		}
	}
}
