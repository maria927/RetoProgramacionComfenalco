package com.reto.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Process {
	
	public String ListToString(List<String> list) {
		String[] strarray = list.toArray(new String[0]);
		return Arrays.toString(strarray);
	}

	public String MatrixToString(char[][] matrix) {
		String convert = "";
		for (char[] cs : matrix) {
			convert += String.format("%s,", Arrays.toString(cs));
		}
		return convert;
	}

	public char[][] arrayToMatrix(char[] vector, int alto, int ancho) {
		char[][] matrix = new char[alto][ancho];
		int index = 0;
		for (int r = 0; r < alto; r++) {
			for (int c = 0; c < ancho; c++) {

				matrix[r][c] = vector[index];
				index++;
			}
		}

		return matrix;
	}

	public List<String> consultarOcurrencias(char[] array) {

		char[] data = Arrays.copyOf(array, array.length);
		List<String> list = new ArrayList<>();
		for (int i = 0; i < data.length; i++) {
			if (data[i] != '*') {

				int count = 1;
				for (int j = i + 1; j < data.length; j++) {
					if ((data[i] == data[j])) {
						data[j] = '*';
						count++;
					}
				}
				list.add(String.format("%s(%d)", data[i], count));
			}
		}
		return list;

	}

	public char[] ordenarArreglo(char[] array) {
		char[] data = Arrays.copyOf(array, array.length);
		Arrays.sort(data);
		return data;
	}

	public char[] eliminarRepetidos(char[] array) {
		char[] data = Arrays.copyOf(array, array.length);
		for (int i = 0; i < data.length; i++) {
			if (data[i] != '*') {
				for (int j = i + 1; j < data.length; j++) {
					if ((data[i] == data[j])) {
						data[j] = '*';
					}
				}
			}
		}

		return data;
	}

}
