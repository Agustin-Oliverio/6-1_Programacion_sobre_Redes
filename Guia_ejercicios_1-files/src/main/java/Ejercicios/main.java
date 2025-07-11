// Archivo: main.java (Actualizado para el nuevo menú)
package Ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintStream;

public class main { 
    public static PrintStream ps = new PrintStream(System.out);
    public static PrintStream psErr = new PrintStream(System.err);
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        
        int menuPrincipalOpcion = -1;
        
        try {
            while (menuPrincipalOpcion != 0) {
                ps.println("\n=== SELECCIÓN DE MENÚ PRINCIPAL ===");
                ps.println("1. Menú de Ejercicios Originales (Ejercicio3)");
                ps.println("2. Menú de Ejercicios de Colecciones (Ejercicio4)");
                ps.println("0. Salir de la aplicación");
                ps.print("Seleccione una opción: ");
                
                String lineaEntrada = br.readLine(); 
                try {
                    menuPrincipalOpcion = Integer.parseInt(lineaEntrada);
                } catch (NumberFormatException e) {
                    psErr.println("Error: Por favor, ingrese un número válido.");
                    menuPrincipalOpcion = -1;
                    continue;
                }
                
                switch (menuPrincipalOpcion) {
                    case 1:
                        mostrarMenuEjerciciosOriginales();
                        break;
                    case 2:
                        mostrarMenuColecciones();
                        break;
                    case 0:
                        ps.println("¡Chauchis! :3");
                        break; 
                    default:
                        ps.println("Opción de menú principal no válida. Intente de nuevo.");
                }
            }
        } catch (IOException e) {
            psErr.println("Error de entrada/salida principal: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void mostrarMenuEjerciciosOriginales() throws IOException {
        int opcion = -1;
        while (opcion != 0) {
            ps.println("\n=== MENÚ DE EJERCICIOS ORIGINALES (Ejercicio3) ===");
            ps.println("1. Guardar último dato del usuario");
            ps.println("2. Guardar todos los valores numéricos");
            ps.println("3. Crear archivo números.txt (pares 0-1000)");
            ps.println("4. Mostrar números.txt por consola");
            ps.println("5. Eliminar múltiplos de 3 de números.txt");
            ps.println("6. Crear archivo primos.dat");
            ps.println("7. Procesar archivo caracteres.dat con letra 'ñ'");
            ps.println("8. Procesar archivo HTML (quitar lorem)");
            ps.println("9. Sistema de datos climáticos");
            ps.println("0. Volver al Menú Principal");
            ps.print("Seleccione una opción: ");

            String lineaEntrada = br.readLine();
            try {
                opcion = Integer.parseInt(lineaEntrada);
            } catch (NumberFormatException e) {
                psErr.println("Error: Por favor, ingrese un número válido.");
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    Ejercicio3.ejercicio1();
                    break;
                case 2:
                    Ejercicio3.ejercicio2();
                    break;
                case 3:
                    Ejercicio3.ejercicio3();
                    break;
                case 4:
                    Ejercicio3.ejercicio4();
                    break;
                case 5:
                    Ejercicio3.ejercicio5();
                    break;
                case 6:
                    Ejercicio3.ejercicio6();
                    break;
                case 7:
                    Ejercicio3.ejercicio7();
                    break;
                case 8:
                    Ejercicio3.ejercicio8();
                    break;
                case 9:
                    Ejercicio3.ejercicio9();
                    break;
                case 0:
                    ps.println("Volviendo al menú principal...");
                    break;
                default:
                    ps.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void mostrarMenuColecciones() throws IOException {
        int opcion = -1;
        while (opcion != 0) {
            ps.println("\n=== MENÚ DE EJERCICIOS DE COLECCIONES (Ejercicio4) ===");
            ps.println("1. Análisis de Valores Numéricos (List)");
            ps.println("2. Gestión de Colegio (Map)");
            ps.println("3. Días de la Semana (List con operaciones)");
            ps.println("4. Gestión de Jugadores (Set)");
            ps.println("5. Generador de Bolas de Dos Colores (Set)");
            ps.println("0. Volver al Menú Principal");
            ps.print("Seleccione una opción: ");

            String lineaEntrada = br.readLine();
            try {
                opcion = Integer.parseInt(lineaEntrada);
            } catch (NumberFormatException e) {
                psErr.println("Error: Por favor, ingrese un número válido.");
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    Ejercicio4.coleccionesEjercicio1();
                    break;
                case 2:
                    Ejercicio4.coleccionesEjercicio2();
                    break;
                case 3:
                    Ejercicio4.coleccionesEjercicio3();
                    break;
                case 4:
                    Ejercicio4.coleccionesEjercicio4();
                    break;
                case 5:
                    Ejercicio4.coleccionesEjercicio5();
                    break;
                case 0:
                    ps.println("Volviendo al menú principal...");
                    break;
                default:
                    ps.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}