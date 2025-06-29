package TP2;

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

public class main {

    static PrintStream ps = System.out;
    static File f = new File("Inventario.txt");
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static FileWriter fw = null;
    static BufferedWriter bw = null;
    static BufferedReader fileReader = null;

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            String opcion = leerTexto("Ingrese una opción: ");

            switch (opcion) {
                case "1":
                    agregarProducto();
                    break;
                case "2":
                    mostrarProductos();
                    break;
                case "3":
                    eliminarProducto();
                    break;
                case "4":
                    editarProducto();
                    break;
                case "5":
                    ps.println("\u001B[32m\nGracias por utilizar el sistema.\u001B[0m");
                    return;
                default:
                    ps.println("\u001B[31m\nOpción inválida.\u001B[0m");
            }
        }
    }

    static void mostrarMenu() {
        ps.println("\u001B[34m\n========== MENÚ PRINCIPAL =========\u001B[0m");
        ps.println("\t1. Agregar producto");
        ps.println("\t2. Mostrar productos");
        ps.println("\t3. Eliminar producto");
        ps.println("\t4. Editar producto");
        ps.println("\t5. Salir");
    }

    static String leerTexto(String mensaje) {
        ps.print("\u001B[36m" + mensaje + "\u001B[0m");
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    static String identificarTipo(String texto) {
        try {
            Integer.parseInt(texto);
            return "entero";
        } catch (NumberFormatException e1) {
            try {
                Float.parseFloat(texto);
                return "decimal";
            } catch (NumberFormatException e2) {
                return "no número";
            }
        }
    }

    static int convertirAInt(String texto) {
        return Integer.parseInt(texto);
    }

    static float convertirAFloat(String texto) {
        return Float.parseFloat(texto);
    }

    static void agregarProducto() {
        String nombre = leerTexto("Ingrese el nombre del producto: ");

        while (true) {
            String precioCompra = leerTexto("Ingrese el precio de compra: ");
            String precioVenta = leerTexto("Ingrese el precio de venta: ");
            String stock = leerTexto("Ingrese la cantidad de stock: ");

            if (!identificarTipo(precioCompra).equals("no número") &&
                !identificarTipo(precioVenta).equals("no número") &&
                identificarTipo(stock).equals("entero")) {

                String linea = nombre + ";" + precioCompra + ";" + precioVenta + ";" + stock;

                try {
                    fw = new FileWriter(f, true);
                    bw = new BufferedWriter(fw);
                    bw.write(linea);
                    bw.newLine();
                    bw.close();
                    fw.close();
                    ps.println("\u001B[32mProducto agregado exitosamente.\u001B[0m");
                } catch (IOException e) {
                    ps.println("\u001B[31mError al escribir en el archivo.\u001B[0m");
                }
                break;
            } else {
                ps.println("\u001B[31mAlguno de los datos es incorrecto. Asegurate de incluir solo datos numéricos\u001B[0m");
            }
        }
    }

    static void mostrarProductos() {
        try {
            fileReader = new BufferedReader(new FileReader(f));
            ps.println("\u001B[33m\nINVENTARIO:\u001B[0m");
            String linea;
            while ((linea = fileReader.readLine()) != null) {
                String[] datos = linea.split(";");
                ps.printf("\tNombre: %-15s Compra: %-10s Venta: %-10s Stock: %-5s\n", datos[0], datos[1], datos[2], datos[3]);
            }
            fileReader.close();
        } catch (IOException e) {
            ps.println("\u001B[31mError al leer el archivo.\u001B[0m");
        }
    }

    static List<String> leerArchivo() {
        List<String> lineas = new ArrayList<>();
        try {
            fileReader = new BufferedReader(new FileReader(f));
            String linea;
            while ((linea = fileReader.readLine()) != null) {
                lineas.add(linea);
            }
            fileReader.close();
        } catch (IOException e) {
            ps.println("\u001B[31mError al leer archivo.\u001B[0m");
        }
        return lineas;
    }

    static void eliminarProducto() {
        List<String> productos = leerArchivo();
        mostrarProductos();
        String nombre = leerTexto("Ingrese el nombre del producto a eliminar: ");

        boolean eliminado = productos.removeIf(linea -> linea.split(";")[0].equalsIgnoreCase(nombre));

        if (eliminado) {
            guardarLista(productos);
            ps.println("\u001B[32mProducto eliminado.\u001B[0m");
        } else {
            ps.println("\u001B[31mProducto no encontrado.\u001B[0m");
        }
    }

    static void editarProducto() {
        List<String> productos = leerArchivo();
        mostrarProductos();
        String nombre = leerTexto("Ingrese el nombre del producto a editar: ");

        for (int i = 0; i < productos.size(); i++) {
            String[] datos = productos.get(i).split(";");
            if (datos[0].equalsIgnoreCase(nombre)) {
                String nuevoNombre = leerTexto("Nuevo nombre (" + datos[0] + "): ");
                while (true) {
                    String nuevoCompra = leerTexto("Nuevo precio de compra (" + datos[1] + "): ");
                    String nuevoVenta = leerTexto("Nuevo precio de venta (" + datos[2] + "): ");
                    String nuevoStock = leerTexto("Nuevo stock (" + datos[3] + "): ");

                    if (!identificarTipo(nuevoCompra).equals("no número") &&
                        !identificarTipo(nuevoVenta).equals("no número") &&
                        identificarTipo(nuevoStock).equals("entero")) {

                        productos.set(i, nuevoNombre + ";" + nuevoCompra + ";" + nuevoVenta + ";" + nuevoStock);
                        guardarLista(productos);
                        ps.println("\u001B[32mProducto editado.\u001B[0m");
                        break;
                    } else {
                        ps.println("\u001B[31mAlguno de los datos es incorrecto. Asegurate de incluir solo datos numéricos\u001B[0m");
                    }
                }
                return;
            }
        }
        ps.println("\u001B[31mProducto no encontrado.\u001B[0m");
    }

    static void guardarLista(List<String> lineas) {
        try {
            fw = new FileWriter(f, false);
            bw = new BufferedWriter(fw);
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            ps.println("\u001B[31mError al guardar el archivo.\u001B[0m");
        }
    }
} 