package ar.edu.et32.tuti_fruti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;

public class InterfazUsuario {
	
	public static PrintStream ps = new PrintStream(System.out);
    
    private BufferedReader reader;
    
    public InterfazUsuario() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    
    public void mostrarMenu() {
        ps.printf("\n%s" +
            "=========================================================================================\n" +
            "| TUTI-FRUTI ║\n" +
            "| MENÚ PRINCIPAL ║\n" +
            "=========================================================================================\n" +
            "| \n" +
            "| 1. Agregar datos nuevos al archivo \n" +
            "| 2. Eliminar datos del archivo \n" +
            "| 3. Mostrar los datos existentes \n" +
            "| 4. Salir \n" +
            "| \n" +
            "=========================================================================================%s\n",
            ConsoleColors.CYAN, ConsoleColors.RESET);
    }

    public int solicitarOpcion() {
        while (true) {
            ps.printf("%sSeleccione una opción (1-4): %s", 
                ConsoleColors.YELLOW, ConsoleColors.RESET);
            
            try {
                String entrada = reader.readLine();
                int opcion = Integer.parseInt(entrada.trim());
                
                if (opcion >= 1 && opcion <= 4) {
                    return opcion;
                } else {
                    ps.printf("%sError: Debe ingresar un número entre 1 y 4. >:( %s\n", 
                        ConsoleColors.RED, ConsoleColors.RESET);
                }
            } catch (IOException e) {
                ps.printf("%sError al leer la entrada.%s\n", 
                    ConsoleColors.RED, ConsoleColors.RESET);
            } catch (NumberFormatException e) {
                ps.printf("%sError: Debe ingresar un número válido.%s\n", 
                    ConsoleColors.RED, ConsoleColors.RESET);
            }
        }
    }
    

    public char solicitarLetra(Set<Character> letrasUsadas) {
        ValidadorDatos validador = new ValidadorDatos();
        
        while (true) {
            ps.printf("\n%sLetras disponibles: %s%s\n", 
                ConsoleColors.GREEN, validador.generarLetrasDisponibles(letrasUsadas), ConsoleColors.RESET);
            ps.printf("%sIngrese una letra para jugar: %s", 
                ConsoleColors.YELLOW, ConsoleColors.RESET);
            
            try {
                String entrada = reader.readLine();
                
                if (entrada != null && !entrada.trim().isEmpty()) {
                    char letra = Character.toUpperCase(entrada.trim().charAt(0));
                    
                    if (validador.esLetraValida(letra)) {
                        if (validador.letraNoUsada(letra, letrasUsadas)) {
                            return letra;
                        } else {
                            ps.printf("%sError: La letra %c ya fue utilizada.%s\n", 
                                ConsoleColors.RED, letra, ConsoleColors.RESET);
                        }
                    } else {
                        ps.printf("%sError: Debe ingresar una letra válida (A-Z).%s\n", 
                            ConsoleColors.RED, ConsoleColors.RESET);
                    }
                } else {
                    ps.printf("%sError: Debe ingresar una letra.%s\n", 
                        ConsoleColors.RED, ConsoleColors.RESET);
                }
            } catch (IOException e) {
                ps.printf("%sError al leer la entrada.%s\n", 
                    ConsoleColors.RED, ConsoleColors.RESET);
            }
        }
    }
    

    public RegistroTutiFruti solicitarDatosCompletos(char letra, ValidadorDatos validador) {
        ps.printf("\n%s=======================================================================================%s\n", 
            ConsoleColors.BLUE, ConsoleColors.RESET);
        ps.printf("%s INGRESO DE DATOS PARA LA LETRA                                                         | %c%s\n", 
            ConsoleColors.BLUE, letra, ConsoleColors.RESET);
        ps.printf("%s=======================================================================================%s\n", 
            ConsoleColors.BLUE, ConsoleColors.RESET);
        
        String color = solicitarCampo("Color", letra, validador);
        String animal = solicitarCampo("Animal", letra, validador);
        String objetos = solicitarCampo("Objetos", letra, validador);
        String alimento = solicitarCampo("Alimento", letra, validador);
        
        return new RegistroTutiFruti(letra, color, animal, objetos, alimento);
    }
 
    private String solicitarCampo(String nombreCampo, char letra, ValidadorDatos validador) {
        while (true) {
            ps.printf("%s%s que empiece con %c: %s", 
                ConsoleColors.YELLOW, nombreCampo, letra, ConsoleColors.RESET);
            
            try {
                String entrada = reader.readLine();
                String valorLimpio = validador.validarYLimpiarCampo(nombreCampo, entrada, letra);
                
                if (valorLimpio != null) {
                    return valorLimpio;
                } else {
                    String mensajeError = validador.obtenerMensajeError(nombreCampo, entrada, letra);
                    ps.printf("%sError: %s%s\n", 
                        ConsoleColors.RED, mensajeError, ConsoleColors.RESET);
                }
            } catch (IOException e) {
                ps.printf("%sError al leer la entrada.%s\n", 
                    ConsoleColors.RED, ConsoleColors.RESET);
            }
        }
    }
    

    public void mostrarRegistrosParaEliminar(List<String> registros) {
        ps.printf("\n%s=====================================================================================%s\n", 
            ConsoleColors.PURPLE, ConsoleColors.RESET);
        ps.printf("%s| REGISTROS EXISTENTES                                                                 |%s\n", 
            ConsoleColors.PURPLE, ConsoleColors.RESET);
        ps.printf("%s=======================================================================================%s\n", 
            ConsoleColors.PURPLE, ConsoleColors.RESET);
        
        
        // Mostrar registros numerados
        for (int i = 1; i < registros.size(); i++) {
            String color = (i % 2 == 1) ? ConsoleColors.CYAN : ConsoleColors.BLUE;
            ps.printf("%s%d. %s%s\n", 
                color, i, registros.get(i), ConsoleColors.RESET);
        }
    }
    
    public int solicitarNumeroEliminar(int maxRegistros) {
        while (true) {
            ps.printf("\n%sIngrese el número del registro a eliminar (1-%d): %s", 
                ConsoleColors.YELLOW, maxRegistros, ConsoleColors.RESET);
            
            try {
                String entrada = reader.readLine();
                int numero = Integer.parseInt(entrada.trim());
                
                if (numero >= 1 && numero <= maxRegistros) {
                    return numero; // Devolver el índice real (numero ya está en base 1)
                } else {
                    ps.printf("%sError: Debe ingresar un número entre 1 y %d.%s\n", 
                        ConsoleColors.RED, maxRegistros, ConsoleColors.RESET);
                }
            } catch (IOException e) {
                ps.printf("%sError al leer la entrada.%s\n", 
                    ConsoleColors.RED, ConsoleColors.RESET);
            } catch (NumberFormatException e) {
                ps.printf("%sError: Debe ingresar un número válido.%s\n", 
                    ConsoleColors.RED, ConsoleColors.RESET);
            }
        }
    }
    
    public void mostrarTablaOrdenada(String cabecera, List<String> datos) {
        ps.printf("\n%s=========================================================================================%s\n", 
            ConsoleColors.GREEN, ConsoleColors.RESET);
        ps.printf("%s| DATOS EXISTENTES |%s\n", 
            ConsoleColors.GREEN, ConsoleColors.RESET);
        ps.printf("%s===========================================================================================%s\n", 
            ConsoleColors.GREEN, ConsoleColors.RESET);
        
        // Mostrar cabecera
        String[] columnasCabecera = cabecera.split(";");
        mostrarFilaTabla(columnasCabecera, ConsoleColors.BLUE + ConsoleColors.WHITE, true);
        
        // Línea separadora
        ps.printf("%s%s%s\n", 
            ConsoleColors.WHITE, "─".repeat(100), ConsoleColors.RESET);
        
        // Mostrar datos
        for (int i = 0; i < datos.size(); i++) {
            String[] columnas = datos.get(i).split(";");
            String color = (i % 2 == 0) ? ConsoleColors.CYAN : ConsoleColors.BLUE;
            mostrarFilaTabla(columnas, color, false);
        }
        
        ps.printf("\n%sTotal de registros: %d%s\n", 
            ConsoleColors.GREEN, datos.size(), ConsoleColors.RESET);
    }
    
 void mostrarFilaTabla(String[] columnas, String color, boolean esCabecera) {
        ps.printf("%s", color);
        
        if (columnas.length >= 5) {
            ps.printf("%-8s %-15s %-15s %-15s %-15s", 
                columnas[0], columnas[1], columnas[2], columnas[3], columnas[4]);
        } else {
            // Manejar caso de columnas faltantes
            for (int i = 0; i < 5; i++) {
                String valor = (i < columnas.length) ? columnas[i] : "";
                ps.printf("%-15s ", valor);
            }
        }
        
        ps.printf("%s\n", ConsoleColors.RESET);
    }
    

    public void cerrar() {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            System.err.printf("Error cerrando BufferedReader: %s\n", e.getMessage());
        }
    }
}
