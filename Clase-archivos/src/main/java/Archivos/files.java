package Archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class files {

	PrintStream ps;
	File file;

	public files() {
		ps = new PrintStream(System.out);

		/*
		 // "c:\\user\\gonza\\miArchivito.txt" file = new File("miArchivito.et32");
		 file.createNewFile(); // Crea un archivo
		 file.delete(); // Borra el archivo
		 file.deleteOnExit(); // Borra el archivo cuando termina de ejecutarse
		 file.exists(); // Indica si el archivo existe
		 file.getAbsoluteFile(); //
		 file.getName(); // Indica el nombre del archivo
		 file.getParent(); // Indica en qué directorio está el archivo
		 file.getTotalSpace(); // Indica el peso del archivo
		 file.isHidden(); // Indica si el archivo está oculto
		 file.isDirectory(); // Indica si el archivo es una carpeta
		 file.isFile(); // Indica si es un archivo
		 file.list(); // Devuelve un listado de "Strings" con los nombres de todos los archivos dentro (funciona con carpetas)
		 file.listFiles(); // Devuelve un listado de "Files" con los nombres de todos los archivos dentro (funciona con carpetas)
		 file.mkdir(); // Crea una carpeta
		 file.renameTo(new File("nuevoNombre.txt")); // Sirve para cambiar el nombre del archivo (es necesario instanciar un nuevo archivo con el nuevo nombre)
		 */

		this.rutaFiles(file);
		this.crearFileConPrintStreamEasy(file);
	}

	// ***********

	/**
	 * 
	 * ESTE TEXTO NO TIENE NINGUNA ETIQUETA DE IDENTIFICACION. ESTO NO VA A
	 * 
	 * AAPARECER :( Tambien se puede agregar referencias a class o methodos o
	 * 
	 * atributos con la instruccion: {
	 *
	 * 
	 * 
	 * @ por ejemplo: {@code <html></html>} o usar {@link String}
	 *
	 * 
	 * 
	 * @param f Este metodo recibe un archivo.
	 * 
	 * @see FlujoDeDatos.File.
	 * 
	 * @since v1.0
	 * 
	 * @exception
	 * 
	 * @throw
	 * 
	 * @return
	 * 
	 * @author Redes-20
	 * 
	 */

	public void rutaFiles(File f) {

	}

	public void crearFileConPrintStreamEasy(File f) {
		FileOutputStream fos = null;
		PrintStream fs = null;

		try {
			fos = new FileOutputStream(f);
			fs = new PrintStream(fos);

			fs.print("Una linea");
			fs.println("Nueva linea");
			fs.write('d');		//escribe 1 byte
			fs.append("HOlAA");	//es como un print, pero escribe en la posición del cursor
			fs.flush();	//limpia todo lo que hay en el canal
			
		} catch (FileNotFoundException e) {
			Logger.getLogger(files.class.getName()).log(Level.WARNING, null, e);
		} finally {		//se ejecuta independientemente si hubo o no un error
			try {
				if (fs != null)
					fs.close();

				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void crearFileConPrinter(File f) {
		FileWriter fw = null;	// Usa buffered directo y además crea canales de comunicaciones
		PrintWriter pw = null;	// Igual que el PrintStream pero funciona con el FileWriter
		
		try {
			if(!f.exists()) {
				try {
					file.createNewFile();
				} catch(IOException e) {
					Logger.getLogger(files.class.getName()).log(Level.WARNING, null, e);
				}
				
			}
			
			fw = new FileWriter(f);
			pw = new PrintWriter(fw);
			
			pw.print("Una linea");
			pw.println("Nueva linea");
			pw.write('d');		//escribe 1 byte
			pw.append("HOlAA");	//es como un print, pero escribe en la posición del cursor
			pw.flush();			//limpia todo lo que hay en el canal
			
		} catch (FileNotFoundException e) {
			Logger.getLogger(files.class.getName()).log(Level.WARNING, null, e);
		} catch (IOException e) {
			Logger.getLogger(files.class.getName()).log(Level.WARNING, null, e);
		} finally {
			
		}
	}

	/**
	 * 
	 * @param f
	 * 
	 * @return
	 * 
	 */

	public void crearFileConBuffer(File f) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(f, false);	// true = append
			bw = new BufferedWriter(fw);
			
			bw.append(":3");
			bw.write('s');
			bw.newLine();
			bw.flush();		//opcional por que ya es Buffered
			
		} catch(IOException e) {
			Logger.getLogger(files.class.getName()).log(Level.WARNING, null, e);
		} finally {
			try {
				if(fw != null)
					fw.close();
				if(bw != null)
					bw.close();
				
			} catch(IOException e) {
				Logger.getLogger(files.class.getName()).log(Level.WARNING, null, e);
			}
		}
		
	}

	/**
	 * 
	 * Descripcion
	 *
	 * 
	 * 
	 * @param f un archivo al leer
	 * 
	 * @return Todo el texto leido.
	 * 
	 * @throws FileNotFoundException
	 * 
	 * @throws IOException
	 * 
	 */

	public String LeerFileConBuffer(File f) throws FileNotFoundException, IOException {

		return null;

	}

	public void leerFileCaracterAcaractet(File f) {

	}

}