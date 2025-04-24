package guia;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.InputStreamReader;


public class main {

	public static void main(String[] args) {
        PrintStream ps = new PrintStream(System.out);
        PrintStream psErr = new PrintStream(System.err);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        // EJERCICIO 1
        
        /*
        try {
            ps.print("Inserte el valor de una hora de trabajo: ");
            int valorHora = Integer.parseInt(br.readLine());

            ps.print("Inserte la cantidad de horas trabajadas: ");
            int cantidadHoras = Integer.parseInt(br.readLine());

            int salario = valorHora * cantidadHoras;
            ps.println("El salario bruto es: " + salario);
            
        } catch (IOException e) {
            psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
            psErr.println("Por favor, ingrese solo números válidos.");
        }
        
        
        
        try {
        	ps.print("Inserte el valor del primer angulo: ");
            int primerAngulo = Integer.parseInt(br.readLine());

            ps.print("Inserte el valor del segundo angulo: ");
            int segundoAngulo = Integer.parseInt(br.readLine());
            
            int tercerAngulo = 180 - primerAngulo - segundoAngulo;
            ps.println("El valor del tercer angulo es de " + tercerAngulo + "º");
            
        } catch (IOException e) {
        	psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
            psErr.println("Por favor, ingrese solo números válidos.");
        }
        
        
        
        try {
        	ps.print("Ingrese la superficie del cuadrado en m2: ");
            int superficie = Integer.parseInt(br.readLine());
            
            double perimetro = 4 * Math.sqrt(superficie);
            ps.println("El perimetro del cuadrado es: " + perimetro + " metros");
            
        } catch (IOException e) {
        	psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
            psErr.println("Por favor, ingrese solo números válidos.");
        }
        
        
        
        try {
        	ps.print("Ingrese la temperatura en grados fahrenheit: ");
            int tempFahr = Integer.parseInt(br.readLine());
            
            double tempCent = (tempFahr - 32) * 0.55555;
            ps.println("La temperatura, expresada en celcius, es de: " + tempCent + "º");
        
        } catch (IOException e) {
        	psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
            psErr.println("Por favor, ingrese solo números válidos.");
        }
        
        
        
        try {
        	ps.print("Ingrese una cantidad de segundos: ");
            int segundosIn = Integer.parseInt(br.readLine());
            
            int segundos = 0;
            int minutos = 0;
            int horas = 0;
            int dias = 0;
            
            while (segundosIn > 0) {
            	if (segundos < 60) {
            		segundos = segundos + 1;
            	} else {
            		minutos = minutos + 1;
            		segundos = 0;
            	}
            	
            	if (minutos == 59) {
            		horas = horas + 1;
            		minutos = 0;
            	}
            	
            	if (horas == 24) {
            		dias = dias + 1;
            		horas = 0;
            	}
            	
            	segundosIn = segundosIn - 1;
            }
            
            ps.println("Los segundos ingresados equivalen a: " + dias + " dias, " + horas + " horas, " + minutos + " minutos y " + segundos + " segundos");
        
        } catch (IOException e) {
        	psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
            psErr.println("Por favor, ingrese solo números válidos.");
        }
        
        
        
        try {
        	ps.print("Ingrese el precio del producto: ");
            int precio = Integer.parseInt(br.readLine());
            
            double plan1 = precio - (precio * 0.1);
            double plan2 = precio + (precio * 0.1);
            double plan2Cont = plan2 / 2;
            double plan2Cuot = plan2Cont / 2;
            double plan3 = precio + (precio * 0.15);
            double plan3Cont = plan3 / 4;
            double plan3Cuot = (plan3 - plan3Cont) / 5;
            double plan4 = precio + (precio * 0.25);
            double plan4Cuot1 = (plan4 * 0.6) / 4;
            double plan4Cuot2 = (plan4 * 0.4) / 4;
            
            ps.println("A continuacion se muestran los precios a pagar en cada plan para este producto:");
            ps.println("Plan 1: $" + plan1 + " (todo al contado)");
            ps.println("Plan 2: $" + plan2 + " ($" + plan2Cont + " al contado y 2 cuotas de $" + plan2Cuot);
            ps.println("Plan 3: $" + plan3 + " ($" + plan3Cont + " al contado y 5 cuotas de $" + plan3Cuot);
            ps.println("Plan 4: $" + plan4 + " (4 cuotas de $" + plan4Cuot1 + " y 4 cuotas de $" + plan4Cuot2);
            
        } catch (IOException e) {
        	psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
            psErr.println("Por favor, ingrese solo números válidos.");
        }
        
        
        
        try {
        	ps.print("Ingrese su signo del zodiaco (todo en minusculas): ");
            String signo = br.readLine();
            
            switch (signo) {
            case "aries":
                ps.println("Mes aproximado: Marzo - Abril");
                break;
            case "tauro":
            	ps.println("Mes aproximado: Abril - Mayo");
                break;
            case "geminis":
            case "géminis":
            	ps.println("Mes aproximado: Mayo - Junio");
                break;
            case "cancer":
            case "cáncer":
            	ps.println("Mes aproximado: Junio - Julio");
                break;
            case "leo":
            	ps.println("Mes aproximado: Julio - Agosto");
                break;
            case "virgo":
            	ps.println("Mes aproximado: Agosto - Septiembre");
                break;
            case "libra":
            	ps.println("Mes aproximado: Septiembre - Octubre");
                break;
            case "escorpio":
            	ps.println("Mes aproximado: Octubre - Noviembre");
                break;
            case "sagitario":
            	ps.println("Mes aproximado: Noviembre - Diciembre");
                break;
            case "capricornio":
            	ps.println("Mes aproximado: Diciembre - Enero");
                break;
            case "acuario":
            	ps.println("Mes aproximado: Enero - Febrero");
                break;
            case "piscis":
            	ps.println("Mes aproximado: Febrero - Marzo");
                break;
            default:
            	ps.println("Signo no reconocido. Asegurate de escribirlo correctamente.");
            }
        	
        } catch (IOException e) {
        	psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
            psErr.println("Por favor, ingrese solo datos válidos.");
        }
        */
        
        // EJERCICIO 2
        
        
    }
}
