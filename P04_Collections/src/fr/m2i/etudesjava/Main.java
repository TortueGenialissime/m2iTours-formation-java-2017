package fr.m2i.etudesjava;

import java.util.*;

/*
 * Collectiion : terme générique qui définit globalement les classes implémentant 
 * les interfaces Map, Collection, Set ou List
 * 
 * Les interfaces Set et List sont des sous-interfaces de collection
 * L'interface Collection hérite de l'interface Iterable
 * 
 * L'interface Iterable 
 * ----------------------
 * Elle contient la méthode Iterator() qui retourne qui retourne un objet de type Iterator 
 * 
 * L'interface Iterator conteint 3 méthodes : 
 * - next() 
 * 		|-> permet de passer d'un élément au suivant
 * - hasNext() 
 * 		|-> permet de savoir si un élément a un suivant
 * - remove()
 * 		|-> permet de supprimer un élément
 * 
 * L'interface Map
 * ----------------------
 * Une interface Map est implémentée par des containers associatifs 
 * Container associatif : container qui associe une valeur à une clé
 * 
 * La clé est unique mais la valeur ne l'est pas forcement (on peut trouver la même valeur associée à
 * plusieurs clés)
 * 
 * L'accès en lecture ou écriture à une valeur se fait à l'aide de sa clé.
 * 
 * Les méthodes les plus importantes : 
 * - containsKey(Obj key) -> test la présence d'une clé 
 * - containsValue(Obj value  - test la présece d'une valeur
 * - get(Obj key) - recupére la valeur associé à une clé 
 * - put(K key, V value) - ajoute un binome clé/valeur dans la map
 * - remove() -> supprime un binome clé/valeur
 * - keySet -> retourne ttes les clés 
 * - values -> retourne toutes les valeur 
 * - size() -> retourne le nombre de binome clé/valeur 
 * 
 *  Exemple de classes qui implémentes Map:
 *  - HashTable 
 *  	- n'accepte ppas de clé null
 *  	- n'est pas thread safe
 *  - HashMap 
 *  	- accepte une clé null 
 *  	- est thread safe
 *  - TreeMap
 *  	- n'est pas thread safe
 *  	- n'accepte pas une clé null
 *  
 *  Interface Collection 
 *  -----------------------
 *  Méthodes Importantes : 
 *  - size() : retourn le nombre d'objets stockés
 *  - add(E,e) : ajoute un objet
 *  - remove(Obj o) : supprime un objet
 *  - contains(Object 0) : teste si un certain élément existe
 *  - clear() : vide la collection
 *  - iterator : retourne un objet de type Iterator
 *  
 *  Interface Set
 *  -----------------------
 *  Cette interface est implémentée par les conteneurs qui n'autorisent pas les 
 *  doublons
 *  la valeur null peut être acceptée mais une seule fois
 *  
 *  cette interface ne propose ni un accès indexé, ni un accès basé sur cette
 *  clé, donc le seul moyen de parcourir une collection qui implèmente Set est d'utiliser 
 *  un Iterator
 *  
 *  L'implémentation la plus connue de l'interface Set est la classe HashSet
 *  
 *  L'interface List
 *  ------------------------
 *  Cette interface permet un accès indexé aux éléements de la collection (en plus 
 *  de l'accès par l'iterator)
 *  
 *  Les classes les plus connues qui implémentent cette interface sont : 
 *  - ArrayList : c'est l'équivalent d'un tableau dynamique (qui augmente automatiquement
 *  sa taille au fur et à mesure des insertions)
 *  - LinkedList : c'est une liste chainée 
 * 
 */

public class Main {

	public static void main(String[] args) {
		Personne p = new Personne("Mitterrand", "François", Personne.M);
		Automobile a1 = new Automobile("Porsche", "argent", 200000);
		Automobile a2 = new Automobile("Bugatti", "Noir", 1000000);
		Automobile a3 = new Automobile("Renault Twingo", "Noir", 20);

		ArrayList<Object> al = new ArrayList<>();
		// toutes les collections ne contiennent que des objects
		// les valeurs numérique (comme 100 par exemple) ne peuvent pas 
		// être stockés directement dans une collection
		// Une telle valeur doit être "enveloppée" dans une couche objet : 
		al.add(new Integer(100));
		/*
		 * Depuis java 1.5, le compilateur Java assure cette transformation
		 * d'une valeur en objet contenant la valeur automatiquement
		 * On appelle cela 'autoboxing' (mise en boite)
		 */
		al.add(200);
		al.add(p);
		al.add(a1);
		al.add(a2);
		
		// récuperer les objects stockés 
		
		/*
		 * utiliser l'accès indexé (permis par les conteneurs implémentants 
		 * l'interface List)
		 */
		
		// utilisation d'une bouble étendu
		int i = 0;
		for(Object el : al)
		{
			System.out.println("Position : " + i +" - Type object : " + el.getClass().getSimpleName() +"\n\t" + el.toString().toUpperCase());
			i++;
		}
		// utiliser un iterator 
		Iterator<Object> it = al.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		//TreeMap
		
		TreeMap<String, Object> tm = new TreeMap();
		tm.put("int1", 100);
		tm.put("int2", 200);
		tm.put(p.créerClé(), p);
		tm.put(a1.créerClé(), a1);
		tm.put(a2.créerClé(), a2);
		
		// récupérer une valeur par sa clé
		
		System.out.println("L'objet attaché à la clé 'int2' est "+tm.get("int2"));
		System.out.println("L'objet attaché à la clé 'personne0' est "+tm.get("personne0"));
		System.out.println("L'objet attaché à la clé 'auto1' est "+tm.get("auto1"));
		
		// si on veut afficher tout le contenu de la map, on doit récupérer toutes 
		// les clés d'abord et les utiliser pour sortir les valeurs attachées 
		
		Set keys = tm.keySet();
		for(Object k : keys)
		{
			System.out.println("Clé : "+k+" --- Valeur : "+tm.get(k).toString());
		}
		
		/*
		 * On peut aussi récuperer toutes les valeurs sans tenir compte des clés 
		 */
		
		System.out.println("L'ensemble des valeurs de la Treemap : ");
		Collection values = tm.values();
		for(Object k : values)
		{
			System.out.println(k);
		}
		
		//tester si une certaine valeur est contenue dans la liste
		System.out.println("L'objet\n\t" + a3 + "\n" + (al.contains(a3) ? "est" : "n'est pas") + " dans la liste");
		System.out.println("L'objet\n\t" + a2 + "\n" + (al.contains(a2) ? "est" : "n'est pas") + " dans la liste");
		
		/*
		 * tester si une certaine clé existe ou non dans la TreeMap
		 */
		
		System.out.println("La clé auto3 " + (tm.containsKey("auto3") ? "est" : "n'est pas") + " dans la TreeMap");
		System.out.println("La clé personne0 " + (tm.containsKey("personne0") ? "est" : "n'est pas") + " dans la TreeMap");
		
		/*
		 * Tester si un certain objet est dans la treeMap
		 */
		System.out.println("L'objet\n\t" + a3 + "\n" + (tm.containsValue(a3) ? "est" : "n'est pas") + " dans la TreeMap");
		System.out.println("L'objet\n\t" + a2 + "\n" + (tm.containsValue(a2) ? "est" : "n'est pas") + " dans la TreeMap");
	
		// SUPPRESSION dans une ArrayList
		
		// à une certaine position
		
		al.remove(1); // c'est l'objet 200 qui sera supprimé 
		
		// un certain objet 
		
		al.remove(a2);
		
		System.out.println("Le contenu de la liste 'al' après la suppression ");
		
		i = 0;
		for(Object el : al)
		{
			System.out.println("Position : " + i +" - Type object : " + el.getClass().getSimpleName() +"\n\t" + el.toString().toUpperCase());
			i++;
		}
		
		// SUPPRESSION d'une entrée key/value dans une TreeMap 
		
		tm.remove("int2");
		
		System.out.println("Le contenu de la liste 'tm' après la suppression du binome key/value ayant la clé int2 ");
		
		keys = tm.keySet();
		for(Object k : keys)
		{
			System.out.println("Clé : "+k+" --- Valeur : "+tm.get(k).toString());
		}
		

	}

}
















