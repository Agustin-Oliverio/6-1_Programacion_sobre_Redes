package TP1;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ejercicios {
    public static void main(String[] args) {
    	
        int[] datos = new int[5];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream ps = System.out;

        datos[0] = 0;
        datos[1] = 125;

        
        
        while (true) {
            try {
                ps.print("Ingresá un número cualquiera: ");
                datos[2] = Integer.parseInt(reader.readLine());

                System.out.print("Ingresá un 0 (Esto no es opcional, te voy a pegar si no ingresás un 0): ");
                int ingresoManual = Integer.parseInt(reader.readLine());

                if (ingresoManual == 0) {
                    datos[3] = ingresoManual;
                    break;
                    
                } else {
                    ps.println("¿Por qué hiciste eso? Te dije que no lo hicieras. Ahora por eso vas a tener que empezar de nuevo >:("); 
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
            datos[4] = Integer.parseInt(fileReader.readLine());
        } catch (IOException e) {
            ps.println("No se pudo leer 'entrada.txt': " + e.getMessage());
            return;
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                Logger.getLogger(ejercicios.class.getName()).log(Level.WARNING, null, e);
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
			
			for (int num : datos) {
				bw.write(String.valueOf(num));
				bw.newLine();
	        }
			bw.newLine();
			bw.append("Espero que te guste Gonza, lo hice con mucho amor :3");
			
			
			ps.println("Todo salió bien en el ejercicio 1, andá a revisar la carpeta 7w7");
			
		} catch(IOException e) {
			Logger.getLogger(ejercicios.class.getName()).log(Level.WARNING, null, e);
		}finally {
		    try {
		        if (bw != null)
		            bw.close(); 
		        if (fw != null)
		            fw.close(); 
		        
		    } catch (IOException e) {
			    Logger.getLogger(ejercicios.class.getName()).log(Level.WARNING, null, e);
		    }
		}
		
		
		
	

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

	                    int divisor = datos[i + 1];
	                    if(divisor != 0) {
	                    	double resultado = (double) dividendo / divisor;

		                    bwResultados.write(dividendo + " / " + divisor + " = " + resultado);
		                    bwResultados.newLine();
	                    } else {
	                    	throw new ArithmeticException( "(No puede dividirse por 0)");
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
	            Logger.getLogger(ejercicios.class.getName()).log(Level.SEVERE, null, e);
	        } finally {
	            try {
	                if (bwResultados != null)
	                    bwResultados.close();
	                if (bwErrores != null)
	                    bwErrores.close();
	            } catch (IOException e) {
	                Logger.getLogger(ejercicios.class.getName()).log(Level.WARNING, null, e);
	            }
	        }
		
	        
	        
	        
	        
	        
	        File resultadoFileEj3 = new File("resultadosEjericio3.txt");
	        File errorFileEj3 = new File("erroresEjercicio3.txt");

	        BufferedWriter bwResultadosEj3 = null;
	        BufferedWriter bwErroresEj3 = null;
	        
	        
	        
	        BufferedReader fileReaderEj3 = null;
	        int[] datosLeidos = new int[5];
	        int indice = 0;

	        try {
	            fileReaderEj3 = new BufferedReader(new FileReader("paraConsorti.txt"));
	            String linea;

	            while ((linea = fileReaderEj3.readLine()) != null && indice < datosLeidos.length) {
	                try {
	                    int numero = Integer.parseInt(linea.trim());
	                    datosLeidos[indice] = numero;
	                    indice++;
	                } catch (NumberFormatException e) {
	                   
	                }
	            }

	        } catch (IOException e) {
	            ps.println("No se pudo leer 'paraConsorti.txt': " + e.getMessage());
	        } finally {
	            try {
	                if (fileReaderEj3 != null)
	                    fileReaderEj3.close();
	            } catch (IOException e) {
	                Logger.getLogger(ejercicios.class.getName()).log(Level.WARNING, null, e);
	            }
	        }
	        
	        

	        try {
	            bwResultadosEj3 = new BufferedWriter(new FileWriter(resultadoFileEj3));
	            bwErroresEj3 = new BufferedWriter(new FileWriter(errorFileEj3));

	            for (int i = 0; i < datos.length; i++) {
	                int dividendo = datos[i];
	                int divisor = datosLeidos[i];
	                

	                try {
	                    if(divisor != 0) {
	                    	double resultado = (double) dividendo / divisor;

		                    bwResultadosEj3.write(dividendo + " / " + divisor + " = " + resultado);
		                    bwResultadosEj3.newLine();
		                    
	                    } else {
	                    	throw new ArithmeticException( "(No puede dividirse por 0)");
	                    }
	                    

	                } catch (ArithmeticException e) {
	                    bwErroresEj3.write(dividendo + " / " + divisor + " = ArithmeticException: " + e.getMessage());
	                    bwErroresEj3.newLine();

	                } catch (ArrayIndexOutOfBoundsException e) {
	                    bwErroresEj3.write(dividendo + " / n/a = ArrayIndexOutOfBoundsException: " + e.getMessage());
	                    bwErroresEj3.newLine();
	                }
	            }

	            ps.println("Todo salió bien en el ejercicio 3, andá a revisar la carpeta UwU");

	        } catch (IOException e) {
	            Logger.getLogger(ejercicios.class.getName()).log(Level.SEVERE, null, e);
	        } finally {
	            try {
	                if (bwResultadosEj3 != null)
	                    bwResultadosEj3.close();
	                if (bwErroresEj3 != null)
	                    bwErroresEj3.close();
	            } catch (IOException e) {
	                Logger.getLogger(ejercicios.class.getName()).log(Level.WARNING, null, e);
	            }
	        }
	  
	        
	        
	  

    }
}








