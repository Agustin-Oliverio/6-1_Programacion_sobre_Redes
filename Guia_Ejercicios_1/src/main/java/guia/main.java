package guia;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
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
        
        
        // EJERCICIO 2
        
        try {
        	ps.print("Ingrese el primer apellido: ");
        	String apellido1 = br.readLine();
        	ps.print("Ingrese el segundo apellido: ");
        	String apellido2 = br.readLine();
        	ps.print("Ingrese el tercer apellido: ");
        	String apellido3 = br.readLine();
        	
        	String[] apellidos = {apellido1, apellido2, apellido3};
            
            Arrays.sort(apellidos);

            ps.println("Apellidos ordenados alfabéticamente:");
            for (String apellido : apellidos) {
                ps.println(apellido);
            }
        } catch (IOException e) {
            psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
        	psErr.println("Error: " + e.getMessage());
        }
        
        
        
        try {
        	ps.print("Ingrese el primer numero: ");
        	double num1 = Double.parseDouble(br.readLine());
        	ps.print("Ingrese el segundo numero: ");
        	double num2 = Double.parseDouble(br.readLine());
        	ps.print("Ingrese el tercer numero: ");
        	double num3 = Double.parseDouble(br.readLine());
        	ps.print("Ingrese el cuarto numero: ");
        	double num4 = Double.parseDouble(br.readLine());
        	
        	double[] numeros = {num1, num2, num3, num4};
        	
        	Arrays.sort(numeros);
        	
        	ps.println("El numero mas chico ingresado es: " + numeros[0]);
        	
        } catch (IOException e) {
            psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
        	psErr.println("Error: " + e.getMessage());
        }
        
        
        
        try {
        	ps.print("Ingrese un numero entero: ");
        	int num = Integer.parseInt(br.readLine());
        	
        	if (num % 2 == 0) {
        		ps.println("El numero ingresado es par");
        		ps.println("Te quiero :3");
        	} else {
        		ps.println("El numero ingresado es impar");
        		ps.println("Te quiero igual :3");
        	}
        	
        } catch (IOException e) {
            psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
        	psErr.println("Error: " + e.getMessage());
        }
        
        
        
        try {
        	ps.print("Ingrese el primer numero: ");
        	double num1 = Double.parseDouble(br.readLine());
        	ps.print("Ingrese el segundo numero: ");
        	double num2 = Double.parseDouble(br.readLine());
        	
        	double[] numeros = {num1, num2};
        	
        	Arrays.sort(numeros);
        	
        	if (numeros[1] % numeros[0] == 0) {
        		ps.println("El numero " + numeros[1] + " es divisible por " + numeros[0]);
        	} else {
        		ps.println("El numero " + numeros[1] + " no es divisible por " + numeros[0]);
        	}
        	
        } catch (IOException e) {
            psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
        	psErr.println("Error: " + e.getMessage());
        }
        
        
        
        try {
        	ps.print("Ingresá tu día de nacimiento (1-31): ");
            int dia = Integer.parseInt(br.readLine());

            ps.print("Ingresá tu mes de nacimiento (1-12): ");
            int mes = Integer.parseInt(br.readLine());

            String signo = null;

            if (mes == 1) {
                signo = (dia < 20) ? "Capricornio" : "Acuario";
            } else if (mes == 2) {
                signo = (dia < 19) ? "Acuario" : "Piscis";
            } else if (mes == 3) {
                signo = (dia < 21) ? "Piscis" : "Aries";
            } else if (mes == 4) {
                signo = (dia < 20) ? "Aries" : "Tauro";
            } else if (mes == 5) {
                signo = (dia < 21) ? "Tauro" : "Géminis";
            } else if (mes == 6) {
                signo = (dia < 21) ? "Géminis" : "Cáncer";
            } else if (mes == 7) {
                signo = (dia < 23) ? "Cáncer" : "Leo";
            } else if (mes == 8) {
                signo = (dia < 23) ? "Leo" : "Virgo";
            } else if (mes == 9) {
                signo = (dia < 23) ? "Virgo" : "Libra";
            } else if (mes == 10) {
                signo = (dia < 23) ? "Libra" : "Escorpio";
            } else if (mes == 11) {
                signo = (dia < 22) ? "Escorpio" : "Sagitario";
            } else if (mes == 12) {
                signo = (dia < 22) ? "Sagitario" : "Capricornio";
            }

            if (signo != null) {
                ps.println("Tu signo zodiacal es: " + signo);
            } else {
                ps.println("Fecha inválida.");
            }

        } catch (IOException e) {
            psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
        	psErr.println("Error: " + e.getMessage());
        }
        
        
        
        try {
        	ps.print("Ingrese el nombre y apellido de la primer persona: ");
        	String nombre1 = br.readLine();
        	ps.print("Ingrese el nombre y apellido de la segunda persona: ");
        	String nombre2 = br.readLine();
        	
        	String[] lista1 = nombre1.split(" ");
        	ps.println(lista1[1]);
        	String[] lista2 = nombre2.split(" ");
        	ps.println(lista2[1]);
        	
        	if (lista1.length < 2 || lista2.length < 2) {
        	    ps.println("Por favor, ingresá nombre y apellido para ambas personas.");
        	} else {
        		if (lista1[1].length() > lista2[1].length()) {
            		ps.println(nombre1 + " tiene el apellido mas largo");
            	}
        	}
        	
        } catch (IOException e) {
            psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
        	psErr.println("Error: " + e.getMessage());
        }
        
        
        
        try {
        	ps.print("Ingrese un número natural: ");
            int num = Integer.parseInt(br.readLine());

            if (num <= 0) {
                ps.println("Por favor, ingresá un número natural (mayor que 0)");
            } else {
                ps.println("Tabla de multiplicar del " + num + ":");
                for (int i = 1; i <= 10; i++) {
                    ps.println(num + " x " + i + " = " + (num * i));
                }
            }
        	
        } catch (IOException e) {
            psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
        	psErr.println("Error: " + e.getMessage());
        }
        
        
        
        try {
        	ps.print("Ingrese un numero natural: ");
        	int num = Integer.parseInt(br.readLine());
        	
        	boolean esPrimo = true;
        	
        	if (num <= 1) {
                esPrimo = false;
            } else {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        esPrimo = false;
                        break;
                    }
                }
            }
        	
        	if (esPrimo) {
        		ps.println("El numero ingresado es primo");
        	} else {
        		ps.println("El numero ingresado no es primo");
        	}

        	
        } catch (IOException e) {
            psErr.println("Error de entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
        	psErr.println("Error: " + e.getMessage());
        }
        */
    }
}
