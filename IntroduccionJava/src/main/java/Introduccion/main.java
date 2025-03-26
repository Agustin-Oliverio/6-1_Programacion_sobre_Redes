package Introduccion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class main {

	public static void main(String[] args) {
		/*
		System.out.print();			//manda el dato sin enter
		System.out.println();		//manda un enter al final
		System.out.write(null);		//byte
		System.out.printf("texto", var, var2, var3)		//concatenar datos
		//	"texto" + var + "otro texto" + 2	<-- concatenar datos
		 
		System.err;
		*/
		
		/*   %d  double (numeros muy grandes)
		 * 	 %n	 int
		 *   %s  string
		 *   %c  char
		 *   %b  bool
		 *   %f  float
		 *   
		 *   (float)variable   fuerza a una variable a cambiar de tipo (en ese lugar) 
		 */
		
		PrintStream ps = new PrintStream(System.out);		//PrintStream es un administrador de canales de salida
		PrintStream psErr = new PrintStream(System.err);
		
		ps.println("Estamos todo bien");
		
		
		int linea;
		String palabra = "";
		
		int linea2;
		String palabra2 = "";
		try {
			while( (linea = System.in.read()) != 13 ) {
				palabra = palabra + (char)linea;
				ps.println( (char)linea );
			}
			ps.println(palabra);
			
			
			InputStreamReader isr = new InputStreamReader(System.in);	//Gestor de flujo de datos de entrada
			BufferedReader br = new BufferedReader( isr );		//Equivalente al PrintStream
			// BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );	
			
			
			while( (linea2 = System.in.read()) != 13 ) {
				palabra2 = palabra2 + (char)linea2;
				ps.println( (char)linea2 );
			}
			ps.printf( "Con readLine:%s \n", br.readLine() );	//Lee toda la línea completa
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		psErr.println("Esto es un error");
	}

}
