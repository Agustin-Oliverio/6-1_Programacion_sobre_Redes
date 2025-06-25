package TP1;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {
	public static void main(String[] args) {

		int[] datos = new int[5];
		int[] datos2 = new int [5];
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps = System.out;
		

		while (true) {
			try {
				ps.print("Ingresá un número cualquiera: ");
				datos[3] = Integer.parseInt(reader.readLine());

				System.out.print("Ingresá un 0 (Esto no es opcional, te voy a pegar si no ingresás un 0): ");
				int ingresoManual = Integer.parseInt(reader.readLine());

				if (ingresoManual == 0) {
					datos[4] = ingresoManual;

				} else {
					ps.println(
							"¿Por qué hiciste eso? Te dije que no lo hicieras. Ahora por eso vas a tener que empezar de nuevo >:(");
				}
				
				ps.print("Ingresá otro número cualquiera: ");
				datos2[3] = Integer.parseInt(reader.readLine());

				System.out.print("Ingresá un 0 (Esto no es opcional, te voy a pegar si no ingresás un 0): ");
				int ingresoManual2 = Integer.parseInt(reader.readLine());

				if (ingresoManual2 == 0) {
					datos2[4] = ingresoManual;
					break;

				} else {
					ps.println(
							"¿Por qué hiciste eso? Te dije que no lo hicieras. Ahora por eso vas a tener que empezar de nuevo >:(");
				}

			} catch (IOException e) {
				ps.println("Error de entrada/salida. Intentá de nuevo.");
			} catch (NumberFormatException e) {
				ps.println("Eso no era un número válido. Intentá de nuevo.");
			}

		}

		
		
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("entrada.txt"));
			int indice = 0;
			String linea;
			
			while ((linea = fileReader.readLine()) != null && indice < 6) {
				try {
					int numero = Integer.parseInt(linea.trim());
					if (indice < 3){
						datos[indice] = numero;
					} else {
						datos2[indice-3] = numero;
					}
					
					indice++;
					
				} catch (NumberFormatException e) {}
			}
		} catch (IOException e) {
			ps.println("No se pudo leer 'entrada.txt': " + e.getMessage());
			return;
		} finally {
			try {
				if (fileReader != null)
					fileReader.close();
			} catch (IOException e) {
				Logger.getLogger(main.class.getName()).log(Level.WARNING, null, e);
			}
		}

		ps.println("\nLos datos guardados en el vector (memoria volatil) son: ");
		for (int num : datos) {
			ps.println(num);
		}

		File f = new File("paraConsorti.txt");

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			fw = new FileWriter(f, false);
			bw = new BufferedWriter(fw);

			bw.append("Los datos guardados en el archivo (memoria no-volatil) son: ");
			bw.newLine();

			for (int num : datos2) {
				bw.write(String.valueOf(num));
				bw.newLine();
			}
			bw.newLine();
			bw.append("Espero que te guste Gonza, lo hice con mucho amor :3");

			ps.println("Todo salió bien en el ejercicio 1, andá a revisar la carpeta UwU");

		} catch (IOException e) {
			Logger.getLogger(main.class.getName()).log(Level.WARNING, null, e);
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();

			} catch (IOException e) {
				Logger.getLogger(main.class.getName()).log(Level.WARNING, null, e);
			}
		}

		
		
		//EJERCICIO 2
		
		File resultadoFile = new File("resultados.txt");
		File errorFile = new File("errores.txt");

		BufferedWriter bwResultados = null;
		BufferedWriter bwErrores = null;

		try {
			bwResultados = new BufferedWriter(new FileWriter(resultadoFile));
			bwErrores = new BufferedWriter(new FileWriter(errorFile));

			for (int i = 0; i < datos.length; i++) {
				int dividendo = datos[i];

				try {
					if (i + 1 >= datos.length)
						throw new ArrayIndexOutOfBoundsException("(No hay siguiente número)");

					int divisor = datos[i + 1] - 3;
					if (divisor != 0) {
						double resultado = (double) dividendo / divisor;

						bwResultados.write(dividendo + " / " + divisor + " = " + resultado);
						bwResultados.newLine();
					} else {
						throw new ArithmeticException("(No puede dividirse por 0)");
					}

				} catch (ArithmeticException e) {
					int divisor = datos[i + 1];
					bwErrores.write(dividendo + " / " + divisor + " = ArithmeticException: " + e.getMessage());
					bwErrores.newLine();

				} catch (ArrayIndexOutOfBoundsException e) {
					bwErrores.write(dividendo + " / n/a = ArrayIndexOutOfBoundsException: " + e.getMessage());
					bwErrores.newLine();
				}
			}

			ps.println("Todo salió bien en el ejercicio 2, andá a revisar la carpeta :3");

		} catch (IOException e) {
			Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			try {
				if (bwResultados != null)
					bwResultados.close();
				if (bwErrores != null)
					bwErrores.close();
			} catch (IOException e) {
				Logger.getLogger(main.class.getName()).log(Level.WARNING, null, e);
			}
		}
		
		

	}
}