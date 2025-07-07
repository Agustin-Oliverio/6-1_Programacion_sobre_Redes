package ar.edu.et32.tuti_fruti;

public class RegistroTutiFruti {
    private Character letra;
    private String color;
    private String animal;
    private String objetos;
    private String alimento;
    private String letra2 =  String.valueOf( letra );
    
    // Constructor para crear desde línea del archivo original
    public RegistroTutiFruti(String lineaOriginal) {
        String[] partes = lineaOriginal.trim().split("\\.");
        
        
        if (partes.length >= 5) {
        	this.letra2 = partes[0].trim();
            this.color = partes[1].trim();
            this.animal = partes[2].trim();
            this.objetos = partes[3].trim();
            this.alimento = partes[4].trim();
            
            this.letra = detectarLetra();
        } else {
            throw new IllegalArgumentException("Formato de línea inválido: " + lineaOriginal);
        }
    }
    
    // Constructor para crear manualmente
    public RegistroTutiFruti(char letra, String color, String animal, String objetos, String alimento) {
        this.letra = Character.toUpperCase(letra);
        this.color = color.trim();
        this.animal = animal.trim();
        this.objetos = objetos.trim();
        this.alimento = alimento.trim();
    }
    
    // Constructor para crear desde línea CSV
    public RegistroTutiFruti(String lineaCSV, boolean esCSV) {
        if (esCSV) {
            String[] partes = lineaCSV.split(";");
            
            if (partes.length >= 5) {
                this.letra = partes[0].charAt(0);
                this.color = partes[1].trim();
                this.animal = partes[2].trim();
                this.objetos = partes[3].trim();
                this.alimento = partes[4].trim();
            } else {
                throw new IllegalArgumentException("Formato CSV inválido: " + lineaCSV);
            }
        }
    }
    
    private char detectarLetra() {
        // Buscar la primera letra que coincida en todos los campos
        if (!color.isEmpty()) {
            char primeraLetra = Character.toUpperCase(color.charAt(0));
            
            // Verificar si todos los campos empiezan con la misma letra
            if (empiezaConLetra(animal, primeraLetra) && 
                empiezaConLetra(objetos, primeraLetra) && 
                empiezaConLetra(alimento, primeraLetra)) {
                return primeraLetra;
            }
        }
        
        // Si no hay coincidencia, usar la primera letra del color
        return color.isEmpty() ? 'A' : Character.toUpperCase(color.charAt(0));
    }
    
    private boolean empiezaConLetra(String palabra, char letra) {
        return !palabra.isEmpty() && Character.toUpperCase(palabra.charAt(0)) == letra;
    }
    
    public String toCSV() {
        return String.format("%c;%s;%s;%s;%s", 
            letra, color, animal, objetos, alimento);
    }
    
    public String[] toArray() {
        return new String[]{
            String.valueOf(letra),
            color,
            animal,
            objetos,
            alimento
        };
    }
    
    // Getters
    public char getLetra() {
        return letra;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getAnimal() {
        return animal;
    }
    
    public String getObjetos() {
        return objetos;
    }
    
    public String getAlimento() {
        return alimento;
    }
    
}
