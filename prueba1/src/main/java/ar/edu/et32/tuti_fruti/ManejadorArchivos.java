package ar.edu.et32.tuti_fruti;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ManejadorArchivos {
    public List<String> leerLineasArchivo(String nombreArchivo) throws IOException {
        List<String> lineas = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (FileNotFoundException e) {
            return lineas;
        }
        
        return lineas;
    }
    

    public boolean escribirLineasArchivo(String nombreArchivo, List<String> lineas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, false))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.err.printf("Error escribiendo archivo %s: %s\n", nombreArchivo, e.getMessage());
            return false;
        }
    }
    

    public boolean agregarLineasArchivo(String nombreArchivo, List<String> lineas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.err.printf("Error agregando al archivo %s: %s\n", nombreArchivo, e.getMessage());
            return false;
        }
    }
    

    public boolean archivoExiste(String nombreArchivo) {
        return Files.exists(Paths.get(nombreArchivo));
    }
    

    public boolean eliminarArchivo(String nombreArchivo) {
        try {
            return Files.deleteIfExists(Paths.get(nombreArchivo));
        } catch (IOException e) {
            System.err.printf("Error eliminando archivo %s: %s\n", nombreArchivo, e.getMessage());
            return false;
        }
    }
    
    public boolean renombrarArchivo(String nombreOriginal, String nombreNuevo) {
        try {
            Files.move(Paths.get(nombreOriginal), Paths.get(nombreNuevo));
            return true;
        } catch (IOException e) {
            System.err.printf("Error renombrando archivo de %s a %s: %s\n", 
                nombreOriginal, nombreNuevo, e.getMessage());
            return false;
        }
    }
    

    public boolean crearArchivoSiNoExiste(String nombreArchivo) {
        try {
            if (!archivoExiste(nombreArchivo)) {
                Files.createFile(Paths.get(nombreArchivo));
            }
            return true;
        } catch (IOException e) {
            System.err.printf("Error creando archivo %s: %s\n", nombreArchivo, e.getMessage());
            return false;
        }
    }
    

    public boolean validarFormatoArchivo(String nombreArchivo, String separador, int camposEsperados) {
        try {
            List<String> lineas = leerLineasArchivo(nombreArchivo);
            
            for (String linea : lineas) {
                if (!linea.trim().isEmpty()) {
                    String[] partes = linea.split(separador);
                    if (partes.length != camposEsperados) {
                        return false;
                    }
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
}
