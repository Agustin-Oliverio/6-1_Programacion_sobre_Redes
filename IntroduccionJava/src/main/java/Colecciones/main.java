package Colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class main {

	public static void main(String[] args) {
		
		//vector
		int[] vector = new int[5];
		
		//Crear una Lista
		ArrayList<String> nombres = new ArrayList<>();
		ArrayList comidas = new ArrayList<>();
		List<Integer> numeros = new ArrayList<>();
		
		
		LinkedList<Integer> otraLista = new LinkedList<>();
		
		List<String> productos;
		
		nombres.add("");			//Añade un elemento a la lista
		nombres.addAll( comidas );	//Añade todos los elementos de una lista a otra
		nombres.clear();			//Vacía completamente una lista. Elimina todos sus elementos
		nombres.clone();			//clona la lista (es la unica forma de copiarla)
		nombres.contains("Juan");	//Pregunta si ese elemento esta dentro de la lista
		nombres.containsAll( comidas );		//Pregunta si todo un conjunto de elementos esta dentro de la lista
		nombres.get( 2 );			//Te devuelve el elemento en el index proporcionado
		nombres.indexOf("Juan");	//Devuelve el index del elemento proporcionado
		nombres.isEmpty();			//Devuelve si la lista está vacía o no
		nombres.remove(0);			//Elimina el elemento en el index proporcionado
		nombres.remove("Juan");		//Elimina el elemento propotcionado
		nombres.removeAll(comidas);	//Elimina todo un conjunto de elementos de la lista
		nombres.size(); 			//Devuelve la cantidad de elementos que tiene
		nombres.set(0, null);		//Parecido al "add" pero permite agregar un elemento en un index específico
		nombres.sort(null);			//Ordena una lista: Si son números los va a ordenar de menor a mayor y si son textos los va a ordenar alfabeticamente
		nombres.subList(0, 0);		//agarra los elementos desde el primer index proporcionado hasta el segundo
		nombres.toArray();			//Convierte el "arrayList" en un array para que no pueda ser modificado
		
		
		//hash
		HashMap<Integer, String> diccionario = new HashMap<>();
		LinkedHashMap<CadenaDeCaracteres.main, String> diccEnlace = new LinkedHashMap<>();
		Map<Integer, String> dicc = new HashMap<>();
		
		diccionario.containsKey(5);		//Devuelve si la key se encuentra en el diccionario
		diccionario.get(2);				//Devuelve el contenido asociado a la key
		diccionario.put(4, "hola");		//Reemplaza lo que esta en la key por el nuevo contenido
		diccionario.remove(5);			//Elimina lo que esta en la key
		diccionario.remove(4, "hola");	//Verifica que el contenido coincida antes de eliminarlo
		diccionario.entrySet();
		
		
		HashSet<Integer> DNI = new HashSet<>();
		LinkedHashSet<Integer> CUIL = new LinkedHashSet<>();
		Set<Integer> dni = new HashSet<>();
	}

	public static void recorrido()
	{
		ArrayList<String> nombres = new ArrayList<>();
		
		for(int i = 0; i <= nombres.size(); i++)
		{
			nombres.get(i);
		}
		
		
		for(String item : nombres)
		{
			System.out.println(item);
		}
		
		Iterator it = nombres.iterator();
		while( it.hasNext() )
		{
			System.out.println( it.next() );
		}
	}
}
