package ar.edu.et32.tuti_fruti;

import java.util.Set;
import java.util.regex.Pattern;

public class ValidadorDatos {
    
    private static final Pattern PATRON_LETRA = Pattern.compile("[A-Za-z]");
    private static final Pattern PATRON_ALFANUMERICO = Pattern.compile("[A-Za-z0-9\\s]+");
    
    public boolean empiezaConLetra(String texto, char letra) {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        
        char primeraLetra = Character.toUpperCase(texto.trim().charAt(0));
        char letraComparacion = Character.toUpperCase(letra);
        
        return primeraLetra == letraComparacion;
    }
    

    public boolean esLetraValida(char letra) {
        return Character.isLetter(letra);
    }
    
    public boolean letraNoUsada(char letra, Set<Character> letrasUsadas) {
        return !letrasUsadas.contains(Character.toUpperCase(letra));
    }
    

    public boolean esTextoValido(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        
        // Verificar que contenga solo letras, números y espacios
        return PATRON_ALFANUMERICO.matcher(texto.trim()).matches();
    }
    

    public boolean estaEnRango(int numero, int minimo, int maximo) {
        return numero >= minimo && numero <= maximo;
    }
    

    public boolean esNumeroEntero(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        
        try {
            Integer.parseInt(texto.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    

    public int convertirAEntero(String texto) {
        if (esNumeroEntero(texto)) {
            return Integer.parseInt(texto.trim());
        }
        return 0;
    }
    

    public String limpiarTexto(String texto) {
        if (texto == null) {
            return "";
        }
        
        return texto.trim().replaceAll("\\s+", " ");
    }
    

    public boolean esRegistroValido(RegistroTutiFruti registro) {
        if (registro == null) {
            return false;
        }
        
        char letra = registro.getLetra();
        
        return esLetraValida(letra) &&
               empiezaConLetra(registro.getColor(), letra) &&
               empiezaConLetra(registro.getAnimal(), letra) &&
               empiezaConLetra(registro.getObjetos(), letra) &&
               empiezaConLetra(registro.getAlimento(), letra) &&
               esTextoValido(registro.getColor()) &&
               esTextoValido(registro.getAnimal()) &&
               esTextoValido(registro.getObjetos()) &&
               esTextoValido(registro.getAlimento());
    }
    
 
    public String obtenerMensajeError(String campo, String valor, char letra) {
        if (valor == null || valor.trim().isEmpty()) {
            return String.format("El campo %s no puede estar vacío", campo);
        }
        
        if (!esTextoValido(valor)) {
            return String.format("El campo %s contiene caracteres inválidos", campo);
        }
        
        if (!empiezaConLetra(valor, letra)) {
            return String.format("El campo %s debe empezar con la letra %c", campo, letra);
        }
        
        return "";
    }
    

    public String validarYLimpiarCampo(String campo, String valor, char letra) {
        String valorLimpio = limpiarTexto(valor);
        
        if (esTextoValido(valorLimpio) && empiezaConLetra(valorLimpio, letra)) {
            return valorLimpio;
        }
        
        return null;
    }
    

    public String generarLetrasDisponibles(Set<Character> letrasUsadas) {
        StringBuilder disponibles = new StringBuilder();
                 for (char letra = 'A'; letra <= 'Z'; letra++) {
                    if (!letrasUsadas.contains(letra)) {
                        if (disponibles.length() > 0) {
                            disponibles.append(", ");
                        }
                        disponibles.append(letra);
                    }
                }
                
                return disponibles.toString();
            }
        }
