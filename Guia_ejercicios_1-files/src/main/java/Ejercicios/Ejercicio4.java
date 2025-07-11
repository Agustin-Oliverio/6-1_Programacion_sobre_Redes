// Archivo: Ejercicio4.java
package Ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Ejercicio4 {
    public static PrintStream ps = new PrintStream(System.out);
    public static PrintStream psErr = new PrintStream(System.err);
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   
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
    
    

    private static String leerLineaConsola() {
        try {
            return br.readLine();
        } catch (IOException e) {
            ps.println("\u001B[31mError al leer desde consola.\u001B[0m");
            return "";
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
    
    
    private static void leerValores() throws IOException {
        ps.println("Ingrese valores numéricos enteros (ingrese -99 para terminar):");
        while (true) {
            ps.print("Valor: ");
            String input = br.readLine();
            int valor = convertirAEntero(input);

            if (valor == -99) {
                break;
            }
            
            if (valor != -1 || input.trim().equals("0")) {
                valoresNumericos.add(valor);
            } else {
                ps.println("Entrada inválida. Por favor, ingrese un número entero válido.");
            }
        }
    }
    
    
    private static double calcularSuma() {
        double suma = 0;
        for (Integer num : valoresNumericos) {
            suma += num;
        }
        return suma;
    }
    
    
    private static void mostrarResultados() {
        double suma = calcularSuma();
        double media = suma / valoresNumericos.size();
        int mayoresQueMedia = 0;

        ps.println("\n--- Resultados ---");
        ps.println("Número de valores leídos: " + valoresNumericos.size());
        ps.println("Suma de los valores: " + suma);
        ps.printf("Media de los valores: %.2f\n", media);

        ps.print("Valores leídos: ");
        for (Integer num : valoresNumericos) {
            ps.print(num + " ");
            if (num > media) {
                mayoresQueMedia++;
            }
        }
        ps.println();
        ps.println("Valores mayores que la media: " + mayoresQueMedia);
    }
    

    
    
    
    // EJERCICIO 1
    
    private static List<Integer> valoresNumericos;

    public static void coleccionesEjercicio1() throws IOException {
        ps.println("\n=== EJERCICIO COLECCIONES 1: Análisis de Valores Numéricos ===");
        valoresNumericos = new ArrayList<>();

        leerValores();
        if (valoresNumericos.isEmpty()) {
            ps.println("No se ingresaron valores para analizar.");
        } else {
            mostrarResultados();
        }

        ps.println("Presione ENTER para continuar");
        br.readLine();
    }
    

    // EJERCICIO 2
    
    private static Colegio colegio = new Colegio();

    public static void coleccionesEjercicio2() throws IOException {
        ps.println("\n=== EJERCICIO COLECCIONES 2: Gestión de Colegio ===");

        while (true) {
            ps.println("\n--- Menú Colegio ---");
            ps.println("1. Añadir alumno");
            ps.println("2. Mostrar todas las nacionalidades");
            ps.println("3. Mostrar alumnos por nacionalidad");
            ps.println("4. Cuántas nacionalidades diferentes");
            ps.println("5. Borrar todos los datos");
            ps.println("0. Volver al menú de Colecciones");
            ps.print("Seleccione una opción: ");

            String input = br.readLine();
            int opcion = convertirAEntero(input);

            if (opcion == -1) {
                ps.println("Opción no válida");
                continue;
            }

            switch (opcion) {
                case 1:
                    ps.print("Ingrese nacionalidad del alumno: ");
                    colegio.addAlumno(leerLineaConsola());
                    break;
                case 2:
                    colegio.showAll();
                    break;
                case 3:
                    ps.print("Ingrese la nacionalidad a buscar: ");
                    colegio.showNacionalidad(leerLineaConsola());
                    break;
                case 4:
                    colegio.cuantos();
                    break;
                case 5:
                    colegio.borra();
                    break;
                case 0:
                    return;
                default:
                    ps.println("Opción no válida");
            }
            ps.println("Presione ENTER para continuar");
            br.readLine();
        }
    }

    
    private static class Colegio {
        
        private Map<String, Integer> alumnosPorNacionalidad;

        public Colegio() {
            alumnosPorNacionalidad = new HashMap<>();
        }
        

        public void addAlumno(String nacionalidad) {
            nacionalidad = nacionalidad.trim();
            if (nacionalidad.isEmpty()) {
                ps.println("La nacionalidad no puede estar vacía.");
                return;
            }
            alumnosPorNacionalidad.put(nacionalidad, alumnosPorNacionalidad.getOrDefault(nacionalidad, 0) + 1);
            ps.println("Alumno de nacionalidad '" + nacionalidad + "' añadido.");
        }
        

        public void showAll() {
            if (alumnosPorNacionalidad.isEmpty()) {
                ps.println("No hay alumnos registrados.");
                return;
            }
            ps.println("\n--- Alumnos por Nacionalidad ---");
            for (Map.Entry<String, Integer> entry : alumnosPorNacionalidad.entrySet()) {
                ps.println("Nacionalidad: " + entry.getKey() + " -> Alumnos: " + entry.getValue());
            }
        }
        

        public void showNacionalidad(String nacionalidad) {
            nacionalidad = nacionalidad.trim();
            if (nacionalidad.isEmpty()) {
                ps.println("La nacionalidad no puede estar vacía.");
                return;
            }
            if (alumnosPorNacionalidad.containsKey(nacionalidad)) {
                ps.println("Nacionalidad: " + nacionalidad + " -> Alumnos: " + alumnosPorNacionalidad.get(nacionalidad));
            } else {
                ps.println("No hay alumnos registrados para la nacionalidad '" + nacionalidad + "'.");
            }
        }
        

        public void cuantos() {
            ps.println("Existen " + alumnosPorNacionalidad.size() + " nacionalidades diferentes en el colegio.");
        }
        

        public void borra() {
            alumnosPorNacionalidad.clear();
            ps.println("Todos los datos de alumnos han sido eliminados.");
        }
    }


    // EJERCICIO 3
    public static void coleccionesEjercicio3() throws IOException {
        ps.println("\n=== EJERCICIO COLECCIONES 3: Días de la Semana ===");

        List<String> listDias = new ArrayList<>();
        listDias.add("Lunes");
        listDias.add("Martes");
        listDias.add("Miércoles");
        listDias.add("Jueves");
        listDias.add("Viernes");
        listDias.add("Sábado");
        listDias.add("Domingo");
        ps.println("Lista inicial de días: " + listDias);

        
        listDias.add(4, "Juernes");
        ps.println("Lista con 'Juernes' en posición 4: " + listDias);
        
        List<String> listaDos = new ArrayList<>(listDias);
        ps.println("Copia (listaDos): " + listaDos);

        listDias.addAll(listaDos);
        ps.println("listDias después de añadir listaDos: " + listDias);

        
        // Muestra el contenido de las posiciones 3 y 4 de la lista original y lo duplica.
        ps.println("Contenido de la posición 3: " + listDias.get(3));
        ps.println("Contenido de la posición 4: " + listDias.get(4));

        // Muestra el primer elemento y el último de la lista original.
        ps.println("Primer elemento: " + listDias.get(0));
        ps.println("Último elemento: " + listDias.get(listDias.size() - 1));

        // Elimina el elemento que contenga «Juernes» de la lista y comprueba si elimina algo o no.
        boolean eliminado = listDias.remove("Juernes"); // Elimina la primera ocurrencia
        if (eliminado) {
            ps.println("Se eliminó la primera ocurrencia de 'Juernes'.");
        } else {
            ps.println("No se encontró 'Juernes' para eliminar.");
        }
        ps.println("Lista después de eliminar 'Juernes': " + listDias);

        // Muestra uno a uno los valores de la lista original a través de un Objeto Iterador.
        ps.println("\nValores de la lista usando Iterador:");
        Iterator<String> it = listDias.iterator();
        while (it.hasNext()) {
            ps.println("- " + it.next());
        }

        // Busca si existe en la lista un elemento que se denomine «Lunes». No importa si está en mayúscula o minúscula.
        boolean encontradoLunes = false;
        for (String dia : listDias) {
            if (dia.equalsIgnoreCase("Lunes")) {
                encontradoLunes = true;
                break;
            }
        }
        if (encontradoLunes) {
            ps.println("Se encontró 'Lunes' (ignorando mayúsculas/minúsculas) en la lista.");
        } else {
            ps.println("No se encontró 'Lunes' en la lista.");
        }

        // Ordena la lista y muestra su contenido.
        Collections.sort(listDias);
        ps.println("Lista ordenada: " + listDias);

        ps.println("Presione ENTER para continuar");
        br.readLine();
    }


    // EJERCICIO 4
    
    public static void coleccionesEjercicio4() throws IOException {
        ps.println("\n=== EJERCICIO COLECCIONES 4: Gestión de Jugadores (Set) ===");

        Set<String> jugadores = new HashSet<>();

        jugadores.add("Jordi Alba");
        jugadores.add("Pique");
        jugadores.add("Busquets");
        jugadores.add("Iniesta");
        jugadores.add("Messi");
        ps.println("Jugadores iniciales: " + jugadores);

        // Realiza una Iteracion sobre los jugadores del conjunto y muestra sus nombres.
        ps.println("\nIterando sobre jugadores:");
        for (String jugador : jugadores) {
            ps.println("- " + jugador);
        }

        // Consulta si en el conjunto existe el jugador «Neymar JR». Avisa si existe o no.
        if (jugadores.contains("Neymar JR")) {
            ps.println("Neymar JR SÍ existe en el conjunto.");
        } else {
            ps.println("Neymar JR NO existe en el conjunto.");
        }

        // Crea un segundo conjunto jugadores2 con los jugadores «Piqué» y «Busquets».
        Set<String> jugadores2 = new HashSet<>();
        jugadores2.add("Pique");
        jugadores2.add("Busquets");
        ps.println("Jugadores2: " + jugadores2);
        

        // Consulta si todos los elementos de jugadores2 existen en jugadores.
        if (jugadores.containsAll(jugadores2)) {
            ps.println("Todos los elementos de jugadores2 SÍ existen en jugadores.");
        } else {
            ps.println("No todos los elementos de jugadores2 existen en jugadores.");
        }

        // Unifica los conjuntos jugadores y jugadores2.
        Set<String> unionJugadores = new HashSet<>(jugadores); // Copia jugadores
        unionJugadores.addAll(jugadores2); // Añade todos los de jugadores2 (los duplicados no se añaden)
        ps.println("Unión de jugadores y jugadores2: " + unionJugadores);

        // Trate de ingresar a «Piqué» a la primera coleccion de tal manera que la coleccion elegida no permite ingresarlo esta vez.
        // Dado que 'jugadores' ya es un HashSet, y los Sets no permiten duplicados,
        // al intentar añadir "Pique" de nuevo, el método add() devolverá false y no lo añadirá.
        boolean addedPique = jugadores.add("Pique");
        if (addedPique) {
            ps.println("Se logró añadir 'Pique' (esto no debería pasar en un HashSet si ya existía).");
        } else {
            ps.println("No se pudo añadir 'Pique' a la primera colección (ya existía y HashSet no permite duplicados).");
        }
        ps.println("Jugadores después de intentar añadir 'Pique': " + jugadores); // Mostrar para confirmar que no cambió

        ps.println("Presione ENTER para continuar");
        br.readLine();
    }


    // EJERCICIO 5
    public static void coleccionesEjercicio5() throws IOException {
        ps.println("\n=== EJERCICIO COLECCIONES 5: Generador de Bolas de Dos Colores ===");

        Random random = new Random();
        Set<Integer> bolasRojas = new HashSet<>();
        
        // Generar 6 números de bolas rojas (1-33) sin repetición
        while (bolasRojas.size() < 6) {
            bolasRojas.add(random.nextInt(33) + 1); // Números del 1 al 33
        }

        // Generar 1 número de bola azul (1-16)
        int bolaAzul = random.nextInt(16) + 1; // Números del 1 al 16

        ps.println("Números de Bola Roja: " + bolasRojas);
        ps.println("Número de Bola Azul: " + bolaAzul);

        ps.println("Presione ENTER para continuar");
        br.readLine();
    }
}