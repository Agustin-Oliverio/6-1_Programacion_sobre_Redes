package Ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
	public static PrintStream ps = new PrintStream(System.out);
	public static PrintStream psErr = new PrintStream(System.err);
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static File f = null;
	static FileWriter fw = null;
    static BufferedWriter bw = null;
    static BufferedReader fileReader = null;
    
    
    private static final String CARPETA_PROYECTO = System.getProperty("user.dir");
    private static final String CARPETA_EXTERNA;

    static {
        File proyectoDir = new File(CARPETA_PROYECTO);
        String parentPath = proyectoDir.getParent();

        if (parentPath != null) {
            CARPETA_EXTERNA = parentPath;
        } else {
            CARPETA_EXTERNA = System.getProperty("user.home");
            System.err.println("Advertencia: No se pudo determinar la carpeta padre de " + CARPETA_PROYECTO + ". Usando " + CARPETA_EXTERNA + " como alternativa.");
        }
    }
    
    
    
    private static void crearArchivo(String nombre) {
    	ps.println("Creando archivo");
    	f = new File(nombre);
    	
    }
    
    
    private static void sobreescribirArchivo(String dato) {
    	try {
			fw = new FileWriter(f, false);
			bw = new BufferedWriter(fw);
			
	        bw.write(dato);
	        bw.close();
            fw.close();
            ps.println("\u001B[32mProducto agregado exitosamente.\u001B[0m");
        } catch (IOException e) {
            ps.println("\u001B[31mError al escribir en el archivo.\u001B[0m");
        }
        
    }
    
    
    private static void escribirArchivo(String dato) {
    	try {
			fw = new FileWriter(f, true);
			bw = new BufferedWriter(fw);
			
	        bw.write(dato);
	        bw.newLine();
	        bw.close();
            fw.close();
            ps.println("\u001B[32mProducto agregado exitosamente.\u001B[0m");
        } catch (IOException e) {
            ps.println("\u001B[31mError al escribir en el archivo.\u001B[0m");
        }
        
    }

    
    private static boolean borrarArchivo(String nombre) {
        try {
            File archivo = new File(nombre);
            if (archivo.exists()) {
                boolean eliminado = archivo.delete();
                if (eliminado) {
                    ps.println("\u001B[32mArchivo eliminado exitosamente.\u001B[0m");
                    return true;
                } else {
                    ps.println("\u001B[31mNo se pudo eliminar el archivo.\u001B[0m");
                    return false;
                }
            } else {
                ps.println("\u001B[33mEl archivo no existe.\u001B[0m");
                return false;
            }
        } catch (Exception e) {
            ps.println("\u001B[31mError al eliminar el archivo.\u001B[0m");
            return false;
        }
    }
    
    
    private static boolean existeArchivo(String nombre) {
        File archivo = new File(nombre);
        return archivo.exists();
    }
    
    
    private static String leerLineaConsola() {
        try {
            return br.readLine();
        } catch (IOException e) {
            ps.println("\u001B[31mError al leer desde consola.\u001B[0m");
            return "";
        }
    }
    
    
    private static List<String> leerArchivoCompleto(String nombre) {
        List<String> lineas = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombre));
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
            reader.close();
        } catch (IOException e) {
            ps.println("\u001B[31mError al leer el archivo.\u001B[0m");
        }
        return lineas;
    }
    
    
    private static void mostrarArchivo(String nombre) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombre));
            String linea;
            while ((linea = reader.readLine()) != null) {
                ps.println(linea);
            }
            reader.close();
        } catch (IOException e) {
            ps.println("\u001B[31mError al leer el archivo.\u001B[0m");
        }
    }
    
    
    private static void crearCarpeta(String ruta) {
        File carpeta = new File(ruta);
        if (!carpeta.exists()) {
            carpeta.mkdir();
            ps.println("Carpeta creada: " + ruta);
        }
    }
    
    
    private static int convertirAEntero(String texto) {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    
    private static double convertirADouble(String texto) {
        try {
            return Double.parseDouble(texto.trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
    
    
    private static boolean esPrimo(int numero) {
        if (numero < 2) return false;
        if (numero == 2) return true;
        if (numero % 2 == 0) return false;
        
        for (int i = 3; i * i <= numero; i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
	
	
    
    
    
    // EJERCICIO 1
    
	static void ejercicio1() throws IOException {
        ps.println("\n=== EJERCICIO 1: Guardar último dato ===");
        String ultimoDato = "";
        
        while (true) {
            ps.print("Ingrese un dato (o 'salir' para terminar): ");
            String dato = br.readLine();
            
            
            if (dato.equalsIgnoreCase("salir")) {
                break;
            }
            
            ultimoDato = dato;
        }
        
        crearArchivo(CARPETA_PROYECTO + File.separator + "Ultimo_dato_guardado.txt");
        sobreescribirArchivo(ultimoDato);
        
        
        ps.println("Presione ENTER para continuar");
        String continuar = br.readLine();
	}
	
	
	// EJERCICIO 2
	
	static void ejercicio2() throws IOException {
        ps.println("\n=== EJERCICIO 2: Guardar valores numéricos ===");
        
        crearArchivo(CARPETA_PROYECTO + File.separator + "valores_numericos.txt");
        
 
        sobreescribirArchivo(""); // Esto lo puse solo para limpiar el archivo
        
        while (true) {
            ps.print("Ingrese un valor (o 'salir' para terminar): ");
            String input = leerLineaConsola();
            
            if (input.equalsIgnoreCase("salir")) {
                break;
            }
            
            double numero = convertirADouble(input);
            
            if (numero != 0.0 || input.trim().equals("0") || input.trim().equals("0.0")) {
                escribirArchivo(String.valueOf(numero));
                ps.println("Número guardado: " + numero);
                
            } else {
                ps.println("No es un número válido, se ignora.");
            }
        }
        
        ps.println("Valores numéricos guardados en: " + f.getAbsolutePath());
        ps.println("Presione ENTER para continuar");
        String continuar = br.readLine();
    }
	
	
	// EJERCICIO 3
	
	static void ejercicio3() throws IOException {
        ps.println("\n=== EJERCICIO 3: Crear números.txt (pares 0-1000) ===");
        
        crearArchivo(CARPETA_EXTERNA + File.separator + "números.txt");
        
        StringBuilder contenido = new StringBuilder();
        for (int i = 0; i <= 1000; i += 2) {
            contenido.append(i);
            if (i < 1000) {
                contenido.append("\n");
            }
        }
        
        sobreescribirArchivo(contenido.toString());
        ps.println("Archivo creado en: " + f.getAbsolutePath());
        ps.println("Se guardaron " + (1000/2 + 1) + " números pares.");
        
        ps.println("Presione ENTER para continuar");
        String continuar = br.readLine();
    }
	
	
	// EJERCICIO 4
	
	static void ejercicio4() throws IOException {
        ps.println("\n=== EJERCICIO 4: Mostrar números.txt ===");
        
        String rutaArchivo = CARPETA_EXTERNA + File.separator + "números.txt";
        
        if (!existeArchivo(rutaArchivo)) {
            ps.println("El archivo números.txt no existe. Ejecute primero el ejercicio 3.");
            return;
        }
        
        ps.println("Contenido del archivo números.txt:");
        List<String> lineas = leerArchivoCompleto(rutaArchivo);
        int contador = 0;
        
        for (String linea : lineas) {
            ps.print(linea + " ");
            contador++;
            if (contador % 10 == 0) {
                ps.println();
            }
        }
        
        ps.println("\nTotal de números leídos: " + contador);
        
        ps.println("Presione ENTER para continuar");
        String continuar = br.readLine();
    }
	
	
	// EJERCICIO 5
	
	static void ejercicio5() throws IOException {
        ps.println("\n=== EJERCICIO 5: Eliminar múltiplos de 3 ===");
        
        String rutaArchivo = CARPETA_EXTERNA + File.separator + "números.txt";
        
        if (!existeArchivo(rutaArchivo)) {
            ps.println("El archivo números.txt no existe. Ejecute primero el ejercicio 3.");
            return;
        }
        
        // Leer números actuales
        List<String> lineas = leerArchivoCompleto(rutaArchivo);
        List<Integer> numeros = new ArrayList<>();
        
        for (String linea : lineas) {
            int numero = convertirAEntero(linea);
            if (numero != -1 && numero % 3 != 0) {
                numeros.add(numero);
            }
        }
        
        // Reescribir archivo sin múltiplos de 3
        crearArchivo(rutaArchivo);
        StringBuilder contenido = new StringBuilder();
        for (int i = 0; i < numeros.size(); i++) {
            contenido.append(numeros.get(i));
            if (i < numeros.size() - 1) {
                contenido.append("\n");
            }
        }
        
        sobreescribirArchivo(contenido.toString());
        ps.println("Múltiplos de 3 eliminados. Números restantes: " + numeros.size());
        
        ps.println("Presione ENTER para continuar");
        String continuar = br.readLine();
    }
	
	
	// EJERCICIO 6
	
	static void ejercicio6() throws IOException {
        ps.println("\n=== EJERCICIO 6: Crear archivo primos.dat ===");
        
        String rutaOrigen = CARPETA_EXTERNA + File.separator + "números.txt";
        
        if (!existeArchivo(rutaOrigen)) {
            ps.println("El archivo números.txt no existe. Ejecute primero los ejercicios 3 y 5.");
            return;
        }
        
        // Crear carpeta diferente para primos.dat
        String carpetaPrimos = CARPETA_EXTERNA + File.separator + "primos_folder";
        crearCarpeta(carpetaPrimos);
        
        String rutaPrimos = carpetaPrimos + File.separator + "primos.dat";
        crearArchivo(rutaPrimos);
        
        // Leer números y filtrar primos
        List<String> lineas = leerArchivoCompleto(rutaOrigen);
        List<Integer> primos = new ArrayList<>();
        
        for (String linea : lineas) {
            int numero = convertirAEntero(linea);
            if (numero != -1 && esPrimo(numero)) {
                primos.add(numero);
            }
        }
        
        // Escribir primos
        StringBuilder contenido = new StringBuilder();
        for (int i = 0; i < primos.size(); i++) {
            contenido.append(primos.get(i));
            if (i < primos.size() - 1) {
                contenido.append("\n");
            }
        }
        
        sobreescribirArchivo(contenido.toString());
        ps.println("Archivo primos.dat creado en: " + f.getAbsolutePath());
        ps.println("Números primos encontrados: " + primos.size());
        
        ps.println("Presione ENTER para continuar");
        String continuar = br.readLine();
    }
	
	
	// EJERCICIO 7
	
	static void ejercicio7() throws IOException {
        ps.println("\n=== EJERCICIO 7: Procesar archivo caracteres.dat ===");
        
        String rutaArchivo = CARPETA_EXTERNA + File.separator + "caracteres.dat";
        crearArchivo(rutaArchivo);
        
        ps.println("Ingrese 10 palabras que contengan la letra 'ñ':");
        List<String> palabras = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            String palabra;
            do {
                ps.print("Palabra " + (i + 1) + ": ");
                palabra = leerLineaConsola();
                if (!palabra.toLowerCase().contains("ñ")) {
                    ps.println("La palabra debe contener la letra 'ñ'");
                }
            } while (!palabra.toLowerCase().contains("ñ"));
            
            palabras.add(palabra);
        }
        
        // Escribir palabras al archivo
        StringBuilder contenido = new StringBuilder();
        for (int i = 0; i < palabras.size(); i++) {
            contenido.append(palabras.get(i));
            if (i < palabras.size() - 1) {
                contenido.append("\n");
            }
        }
        sobreescribirArchivo(contenido.toString());
        
        // Mostrar fichero original
        ps.println("\nFichero original:");
        for (String palabra : palabras) {
            ps.println(palabra);
        }
        
        // Leer archivo y modificar
        List<String> lineas = leerArchivoCompleto(rutaArchivo);
        List<String> palabrasModificadas = new ArrayList<>();
        
        for (String linea : lineas) {
            String palabraModificada = linea.replace("ñ", "ni").replace("Ñ", "Ni");
            palabrasModificadas.add(palabraModificada);
        }
        
        // Reescribir archivo
        StringBuilder contenidoModificado = new StringBuilder();
        for (int i = 0; i < palabrasModificadas.size(); i++) {
            contenidoModificado.append(palabrasModificadas.get(i));
            if (i < palabrasModificadas.size() - 1) {
                contenidoModificado.append("\n");
            }
        }
        sobreescribirArchivo(contenidoModificado.toString());
        
        ps.println("\nFichero arreglado:");
        for (String palabra : palabrasModificadas) {
            ps.println(palabra);
        }
        
        ps.println("Presione ENTER para continuar");
        String continuar = br.readLine();
    }
	
	
	// EJERCICIO 8
	
	static void ejercicio8() throws IOException {
        ps.println("\n=== EJERCICIO 8: Procesar archivo HTML ===");
        
        // Crear archivo HTML con lorem
        String rutaHTML = CARPETA_EXTERNA + File.separator + "ejemplo.html";
        crearArchivo(rutaHTML);
        
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<!DOCTYPE html>\n");
        htmlContent.append("<html>\n");
        htmlContent.append("<head>\n");
        htmlContent.append("    <title>Ejemplo</title>\n");
        htmlContent.append("</head>\n");
        htmlContent.append("<body>\n");
        htmlContent.append("    <h1>Mi página web UwU</h1>\n");
        htmlContent.append("    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>\n");
        htmlContent.append("    <p>Ojalá consorti nunca lea esto porque sino se enteraría que me copie en un examen de geografía sobre las provincias en cuarto grado de primaria. Toda mi carrera se basa en una mentira.</p>\n");
        htmlContent.append("    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>\n");
        htmlContent.append("    <div>Otro contenido sin lorem.</div>\n");
        htmlContent.append("    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium lorem.</p>\n");
        htmlContent.append("</body>\n");
        htmlContent.append("</html>");
        
        sobreescribirArchivo(htmlContent.toString());
        ps.println("Archivo HTML creado en: " + f.getAbsolutePath());
        
        // Leer archivo y eliminar líneas con "lorem"
        List<String> lineas = leerArchivoCompleto(rutaHTML);
        List<String> lineasSinLorem = new ArrayList<>();
        
        for (String linea : lineas) {
            if (!linea.toLowerCase().contains("lorem")) {
                lineasSinLorem.add(linea);
            }
        }
        
        // Reescribir archivo sin "lorem"
        StringBuilder contenidoSinLorem = new StringBuilder();
        for (int i = 0; i < lineasSinLorem.size(); i++) {
            contenidoSinLorem.append(lineasSinLorem.get(i));
            if (i < lineasSinLorem.size() - 1) {
                contenidoSinLorem.append("\n");
            }
        }
        sobreescribirArchivo(contenidoSinLorem.toString());
        
        ps.println("Archivo HTML procesado. Se eliminaron las líneas con 'lorem'.");
        
        ps.println("\nContenido final del archivo HTML:");
        mostrarArchivo(rutaHTML);
        
        ps.println("Presione ENTER para continuar");
        String continuar = br.readLine();
    }
	
	
	// EJERCICIO 9
	
	static void ejercicio9() {
        ps.println("\n=== EJERCICIO 9: Sistema de datos climáticos ===");
        
        String rutaClima = CARPETA_PROYECTO + File.separator + "datos_clima.txt";
        
        while (true) {
            ps.println("\n--- Menú Clima ---");
            ps.println("1. Cargar datos climáticos");
            ps.println("2. Mostrar todos los datos");
            ps.println("3. Borrar un registro");
            ps.println("4. Volver al menú principal");
            ps.print("Seleccione una opción: ");
            
            String input = leerLineaConsola();
            int opcion = convertirAEntero(input);
            
            if (opcion == -1) {
                ps.println("Opción no válida");
                continue;
            }
            
            switch (opcion) {
                case 1:
                    cargarDatosClima(rutaClima);
                    break;
                case 2:
                    mostrarDatosClima(rutaClima);
                    break;
                case 3:
                    borrarRegistroClima(rutaClima);
                    break;
                case 4:
                    return;
                default:
                    ps.println("Opción no válida");
            }
        }
    }
	
	
	
	
	
	private static void cargarDatosClima(String rutaArchivo) {
        ps.print("Ingrese la fecha (dd/mm/yyyy): ");
        String fecha = leerLineaConsola();
        
        ps.print("Ingrese la temperatura (°C): ");
        String tempStr = leerLineaConsola();
        double temperatura = convertirADouble(tempStr);
        if (temperatura == 0.0 && !tempStr.trim().equals("0") && !tempStr.trim().equals("0.0")) {
            ps.println("Temperatura inválida. Se usará 0.0");
            temperatura = 0.0;
        }
        
        ps.print("Ingrese la humedad (%): ");
        String humStr = leerLineaConsola();
        double humedad = convertirADouble(humStr);
        if (humedad == 0.0 && !humStr.trim().equals("0") && !humStr.trim().equals("0.0")) {
            ps.println("Humedad inválida. Se usará 0.0");
            humedad = 0.0;
        }
        
        ps.print("Ingrese la presión (hPa): ");
        String presStr = leerLineaConsola();
        double presion = convertirADouble(presStr);
        if (presion == 0.0 && !presStr.trim().equals("0") && !presStr.trim().equals("0.0")) {
            ps.println("Presión inválida. Se usará 0.0");
            presion = 0.0;
        }
        
        ps.print("Ingrese descripción del clima: ");
        String descripcion = leerLineaConsola();
        
        
        
        crearArchivo(rutaArchivo);
        String registro = fecha + "," + temperatura + "," + humedad + "," + presion + "," + descripcion;
        escribirArchivo(registro);
        
        ps.println("Datos climáticos guardados correctamente.");
    }
    
    private static void mostrarDatosClima(String rutaArchivo) {
        if (!existeArchivo(rutaArchivo)) {
            ps.println("No hay datos climáticos guardados.");
            return;
        }
        
        List<String> lineas = leerArchivoCompleto(rutaArchivo);
        int contador = 1;
        
        ps.println("\n=== DATOS CLIMÁTICOS ===");
        ps.println("Nº  | Fecha      | Temp(°C) | Hum(%) | Pres(hPa) | Descripción");
        ps.println("----+------------+----------+--------+-----------+-------------");
        
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            if (datos.length >= 5) {
                ps.printf("%-3d | %-10s | %-8s | %-6s | %-9s | %s\n", 
                    contador, datos[0], datos[1], datos[2], datos[3], datos[4]);
                contador++;
            }
        }
    }
    
    private static void borrarRegistroClima(String rutaArchivo) {
        if (!existeArchivo(rutaArchivo)) {
            ps.println("No hay datos climáticos guardados.");
            return;
        }
        
        // Leer todos los datos
        List<String> registros = leerArchivoCompleto(rutaArchivo);
        
        if (registros.isEmpty()) {
            ps.println("No hay registros para borrar.");
            return;
        }
        
        // Mostrar registros numerados
        ps.println("\n=== REGISTROS PARA BORRAR ===");
        for (int i = 0; i < registros.size(); i++) {
            String[] datos = registros.get(i).split(",");
            ps.printf("%d. %s - %s°C - %s\n", 
                i + 1, datos[0], datos[1], datos.length > 4 ? datos[4] : "");
        }
        
        ps.print("Ingrese el número del registro a borrar (0 para cancelar): ");
        String input = leerLineaConsola();
        int numRegistro = convertirAEntero(input);
        
        if (numRegistro == -1) {
            ps.println("Número inválido.");
            return;
        }
        
        if (numRegistro == 0) {
            ps.println("Operación cancelada.");
            return;
        }
        
        if (numRegistro < 1 || numRegistro > registros.size()) {
            ps.println("Número de registro inválido.");
            return;
        }
        
        // Eliminar registro
        registros.remove(numRegistro - 1);
        
        // Reescribir archivo
        crearArchivo(rutaArchivo);
        StringBuilder contenido = new StringBuilder();
        for (int i = 0; i < registros.size(); i++) {
            contenido.append(registros.get(i));
            if (i < registros.size() - 1) {
                contenido.append("\n");
            }
        }
        
        if (registros.isEmpty()) {
            sobreescribirArchivo("");
        } else {
            sobreescribirArchivo(contenido.toString());
        }
        
        ps.println("Registro eliminado correctamente.");
    }
}
