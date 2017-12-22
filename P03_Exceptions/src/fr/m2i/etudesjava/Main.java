package fr.m2i.etudesjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Exceptions :
 * - classes d'exception
 * - étudier la propagation d'une exception
 * - lever une exception
 * - rattraper une exception
 * - créer et utiliser une classe d'exception personnalisée 
 * 
 */

public class Main {

	public static void main(String[] args) 
	{
		
		/*
		 * utiliser le clavier pour saisir des données
		 */
		
		/*
		 * Solution 1 : faire appel à l'objet in de la classe System
		 */
		
		BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			try 
			{
				System.out.println("Je suis un peroquet ");
				String saisie = clavier.readLine();
				if(saisie.toUpperCase().startsWith("Q") && saisie.length() == 1)
				{
					System.out.println("Ok je me tais ... ");
					break;
				}
				else
				{
					System.out.println(saisie);
				}
			} 
			catch (IOException e) 
			{
				System.out.println(e.getMessage());
			}
		}

	}

}
