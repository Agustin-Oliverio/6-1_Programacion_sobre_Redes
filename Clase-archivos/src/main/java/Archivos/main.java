package Archivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class main {

	public static void main(String[] args) {
		PrintStream ps;
		ps = new PrintStream(System.out);
		
		files arch = new files("consorti.txt");
		
		arch.crearFileConBuffer(arch.rutaFiles(), "Hola mundo");
		try {
			ps.println( arch.LeerFileConBuffer(arch.rutaFiles()) );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
