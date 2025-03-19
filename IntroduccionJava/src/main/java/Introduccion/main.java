package Introduccion;

import java.io.IOException;
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
		
		PrintStream ps = new PrintStream(System.out);
		PrintStream psErr = new PrintStream(System.err);
		
		ps.println("Estamos todo bien");
		
		int linea;
		String palabra="";
		try {
			while( (linea = System.in.read()) != 13 ) {
				palabra = palabra + (char)linea;
				ps.println( (char)linea );
			}
			ps.println(palabra);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		psErr.println("Esto es un error");
	}

}
