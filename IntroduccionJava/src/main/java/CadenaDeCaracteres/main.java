package CadenaDeCaracteres;

public class main {

	public static void main(String[] args) {
		
		String palabra = "LinKevin";
		
		palabra.charAt( 5 );			// Agarra un caracter x de la palabra original
		palabra.compareTo( "Kevin" );	// va a devolver "false" - compara el texto con la palabra orginal. Deben ser exactamente iguales
		palabra.compareToIgnoreCase( "linkevin" );	//va a devolver "true" - compara con la palabra original pero ignora las mayúsculas y minúsculas
		palabra.concat( "/profile" );	//agrega texto al final
		palabra.contains( "K" );		//Devuelve si existe el texto dentro de la palabra original
		palabra.indexOf( '\n' );		//Lo mismo que charAt pero busca la ubicación de un caracter
		palabra.indexOf( "Ke" );		//Ubicación de ese texto en la palabra palabra
		palabra.length();				//Largo total de la cadena
		palabra.lastIndexOf('i');		//Ultima aparición de un texto o caracter
		palabra.replace("Kevin", "Roman");	//Quedará LinRoman - Reemplaza un texto o caracter por otro
		palabra.replace("i", "X");			//Quedará: LXnKevin - solo reemplaza la primera aparición del texto o caracter
		palabra.replaceAll("i", "UwU");		//Quedará LUwUnKevUwUn - reemplaza todas las apariciones del texto o caracter
		palabra.toString();					//Convierte todo a string
		palabra.valueOf(5);					//transforma el numero en texto usando el código ASCII
		palabra.trim();						//quita los espacios en blanco al principio y al final
		palabra.toLowerCase();				//Convierte todo en minúsculas
		palabra.toUpperCase();				//Convierte todo en mayúsculas
		palabra.toCharArray();				//Convierte un string en un vector
		// ['L', 'i', 'n', 'K', 'e', 'v', 'i', 'n']
		palabra.split("K");					//Divide la palabra original en el texto o caracter indicado.
		// vec[] => { "Lin", "evin" } Lin evin
		palabra.substring( 2, 4 );			//LinKevin -> nKev
		
		//conversion de Enteros a texto y viceversa
		//Tokenized
		
	}

}
