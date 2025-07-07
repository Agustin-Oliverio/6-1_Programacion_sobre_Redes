package ar.edu.et32.tuti_fruti;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class main {
    private static final String ARCHIVO_ORIGINAL = "datos.dat";
    private static final String ARCHIVO_CSV = "tuti-fruti.csv";
    private static final String ARCHIVO_ERRORES = "ERRORES.log";
    
    private static ManejadorArchivos manejadorArchivos;
    private static ValidadorDatos validadorDatos;
    private static InterfazUsuario interfazUsuario;
    
    public static void main(String[] args) {
        inicializarComponentes();
        
        try {
            // Reparación inicial del archivo
            if (repararArchivoInicial()) {
                // Menú infinito
                mostrarMenuPrincipal();
            } else {
                System.out.printf("%sError: No se pudo inicializar el sistema correctamente.%s\n", 
                    ConsoleColors.RED, ConsoleColors.RESET);
                System.exit(1);
            }
        } catch (Exception e) {
            manejarError("Error general en el sistema: " + e.getMessage());
            System.exit(1);
        }
    }
    
    private static void inicializarComponentes() {
        manejadorArchivos = new ManejadorArchivos();
        validadorDatos = new ValidadorDatos();
        interfazUsuario = new InterfazUsuario();
    }
    
    private static boolean repararArchivoInicial() {
        try {
            File archivoOriginal = new File(ARCHIVO_ORIGINAL);
            File archivoCSV = new File(ARCHIVO_CSV);
            
            // Si ya existe el CSV, no hacer nada
            if (archivoCSV.exists() && !archivoOriginal.exists()) {
                System.out.printf("%sArchivo ya procesado. Sistema listo para usar.%s\n", 
                    ConsoleColors.GREEN, ConsoleColors.RESET);
                return true;
            }
            
            // Si existe el archivo original, procesarlo
            if (archivoOriginal.exists()) {
                System.out.printf("%sConvirtiendo archivo original a formato CSV...%s\n", 
                    ConsoleColors.YELLOW, ConsoleColors.RESET);
                
                if (convertirArchivoACSV()) {
                    // Eliminar archivo original
                    if (archivoOriginal.delete()) {
                        System.out.printf("%sConversión exitosa. Sistema listo para usar.%s\n", 
                            ConsoleColors.GREEN, ConsoleColors.RESET);
                        return true;
                    } else {
                        manejarError("No se pudo eliminar el archivo original");
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (archivoCSV.exists()) {
                System.out.printf("%sArchivo CSV encontrado. Sistema listo para usar.%s\n", 
                    ConsoleColors.GREEN, ConsoleColors.RESET);
                return true;
            } else {
                // Crear archivo CSV vacío con cabeceras
                crearArchivoCSVVacio();
                System.out.printf("%sArchivo CSV creado. Sistema listo para usar.%s\n", 
                    ConsoleColors.GREEN, ConsoleColors.RESET);
                return true;
            }
        } catch (Exception e) {
            manejarError("Error en reparación inicial: " + e.getMessage());
            return false;
        }
    }
    
    private static boolean convertirArchivoACSV() {
        try {
            List<String> lineas = manejadorArchivos.leerLineasArchivo(ARCHIVO_ORIGINAL);
            List<String> lineasCSV = new ArrayList<>();
            
            for (String linea : lineas) {
                if (!linea.trim().isEmpty()) {
                    RegistroTutiFruti registro = new RegistroTutiFruti(linea);
                    lineasCSV.add(registro.toCSV());
                }
            }
            
            return manejadorArchivos.escribirLineasArchivo(ARCHIVO_CSV, lineasCSV);
        } catch (Exception e) {
            manejarError("Error en conversión: " + e.getMessage());
            return false;
        }
    }
    
    private static void crearArchivoCSVVacio() {
        try {
            List<String> cabeceras = new ArrayList<>();
            cabeceras.add("LETRA;COLOR;ANIMAL;OBJETOS;ALIMENTO");
            manejadorArchivos.escribirLineasArchivo(ARCHIVO_CSV, cabeceras);
        } catch (Exception e) {
            manejarError("Error creando archivo CSV vacío: " + e.getMessage());
        }
    }
    
    private static void mostrarMenuPrincipal() {
        while (true) {
            interfazUsuario.mostrarMenu();
            int opcion = interfazUsuario.solicitarOpcion();
            
            switch (opcion) {
                case 1:
                    agregarDatos();
                    break;
                case 2:
                    eliminarDatos();
                    break;
                case 3:
                    mostrarDatos();
                    break;
                case 4:
                    System.out.printf("%s¡Gracias por usar el sistema! :3  %s\n", 
                        ConsoleColors.CYAN, ConsoleColors.RESET);
                    System.exit(0);
                    break;
                default:
                    System.out.printf("%sOpción inválida. Intente nuevamente. :'c   %s\n", 
                        ConsoleColors.RED, ConsoleColors.RESET);
            }
        }
    }
    
    private static void agregarDatos() {
        try {
            List<String> registrosExistentes = manejadorArchivos.leerLineasArchivo(ARCHIVO_CSV);
            Set<Character> letrasUsadas = obtenerLetrasUsadas(registrosExistentes);
            
            char letra = interfazUsuario.solicitarLetra(letrasUsadas);
            RegistroTutiFruti nuevoRegistro = interfazUsuario.solicitarDatosCompletos(letra, validadorDatos);
            
            // Agregar al archivo
            List<String> nuevasLineas = new ArrayList<>();
            nuevasLineas.add(nuevoRegistro.toCSV());
            
            if (manejadorArchivos.agregarLineasArchivo(ARCHIVO_CSV, nuevasLineas)) {
                System.out.printf("%sDatos agregados exitosamente.%s\n", 
                    ConsoleColors.GREEN, ConsoleColors.RESET);
            } else {
                System.out.printf("%sError al agregar datos.%s\n", 
                    ConsoleColors.RED, ConsoleColors.RESET);
            }
        } catch (Exception e) {
            manejarError("Error agregando datos: " + e.getMessage());
        }
    }
    
    private static void eliminarDatos() {
        try {
            List<String> registros = manejadorArchivos.leerLineasArchivo(ARCHIVO_CSV);
            
            if (registros.size() <= 1) { // Solo cabecera
                System.out.printf("%sNo hay registros para eliminar.%s\n", 
                    ConsoleColors.YELLOW, ConsoleColors.RESET);
                return;
            }
            
            interfazUsuario.mostrarRegistrosParaEliminar(registros);
            int numeroRegistro = interfazUsuario.solicitarNumeroEliminar(registros.size() - 1);
            
            // Eliminar registro
            registros.remove(numeroRegistro);
            
            if (manejadorArchivos.escribirLineasArchivo(ARCHIVO_CSV, registros)) {
                System.out.printf("%sRegistro eliminado exitosamente.%s\n", 
                    ConsoleColors.GREEN, ConsoleColors.RESET);
            } else {
                System.out.printf("%sError al eliminar registro.%s\n", 
                    ConsoleColors.RED, ConsoleColors.RESET);
            }
        } catch (Exception e) {
            manejarError("Error eliminando datos: " + e.getMessage());
        }
    }
    
    private static void mostrarDatos() {
        try {
            List<String> registros = manejadorArchivos.leerLineasArchivo(ARCHIVO_CSV);
            
            if (registros.size() <= 1) { // Solo cabecera
                System.out.printf("%sNo hay registros para mostrar.%s\n", 
                    ConsoleColors.YELLOW, ConsoleColors.RESET);
                return;
            }
            
            // Ordenar alfabéticamente (excepto la cabecera)
            String cabecera = "Let \t Color \t\t Animal \t Cosa \t\t Comida";
            // String cabecera = registros.get(0);
            List<String> datosOrdenados = new ArrayList<>(registros.subList(0, registros.size()));
            Collections.sort(datosOrdenados);
            
            interfazUsuario.mostrarTablaOrdenada(cabecera, datosOrdenados);
        } catch (Exception e) {
            manejarError("Error mostrando datos: " + e.getMessage());
        }
    }
    
    private static Set<Character> obtenerLetrasUsadas(List<String> registros) {
        Set<Character> letrasUsadas = new HashSet<>();
        
        for (int i = 0; i < registros.size(); i++) { // Saltar cabecera
            String[] partes = registros.get(i).split(";");
            if (partes.length > 0) {
                letrasUsadas.add(partes[0].charAt(0));
            }
        }
        
        return letrasUsadas;
    }
    
    private static void manejarError(String mensaje) {
        System.out.printf("%sError: %s%s\n", ConsoleColors.RED, mensaje, ConsoleColors.RESET);
        
        try {
            List<String> errores = new ArrayList<>();
            errores.add(java.time.LocalDateTime.now() + ": " + mensaje);
            manejadorArchivos.agregarLineasArchivo(ARCHIVO_ERRORES, errores);
        } catch (Exception e) {
            System.out.printf("%sError adicional al guardar log: %s%s\n", 
                ConsoleColors.RED, e.getMessage(), ConsoleColors.RESET);
        }
    }
}
