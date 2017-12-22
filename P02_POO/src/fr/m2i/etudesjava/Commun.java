package fr.m2i.etudesjava;

public class Commun {
	
	public static final int FR = 0;
	public static final int EN = 1;
	public static final int DE = 2;
	public static final String[] ProhibitedWords = {"sex, marijuana", "select", "insert"};
	
	/*
	 * 	Comme je ne veux pas permettre que cette classe soit instanciée, je dois 
	 *  faire disparaitre le constructeur par défaut.
	 *  Pour cela, il faut définir un autre constructeur 
	 *  
	 *  Un constructeur est une méthode spéciale qui doit respecter quelques contraintes : 
	 *  elle doit avoir le nom de la classe et qui ne retourne rien, même pas void
	 *  
	 */
	
	private Commun()
	{
		
	}
	/*
	 * Methode static qui permet de savoir si une langue est supporté par mon 
	 * application
	 */
	
	public static boolean estLangueSupportee(int langue)
	{
		return langue == FR || langue == EN || langue == DE;
 	}
}
