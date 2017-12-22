/*
 * Sujets traités : 
 * - variables, types de variables
 * - instruction de contrôle
 * - opérateurs
 * - tableaux
 * - évoquer quelques classes souvent utilisées
 * - méthodes, paramêtres et passage de paramêtres
 * - etc
 */
package com.m2i.formation;

import java.math.BigDecimal;
import java.text.DecimalFormat;
public class Fondamentaux 
{
	public static void main(String[] args) 
	{
		float vf = 0.123456789123456789f;
		DecimalFormat df = new DecimalFormat("######.00");
		System.out.println("vf : " + df.format(vf));
		
		df =  new DecimalFormat("######.##");
		System.out.println("vf : " + df.format(vf));
		
		// une autre façon de formater les valeurs en sortie est d'utiliser 
		// le format C like
		
		System.out.printf("vf=%.1f, rapport = %f", vf, 1.f/3);
		
		// on a constaté plus haut que le précision dans un float est d'nviron 7 décimales
		// et celle d'un double d'environ 17 décimales 
		// Parfois, cette précision ne suffit pas
		
		System.out.println("1.3 - 1.2 = " + (1.3f - 1.2f));
		System.out.println("1.3 - 1.2 = " + (1.3 - 1.2));
		
		// pour résoudre un tel cas où la précision est vraiment necessaire, on 
		// peut utiliser la classe BigDecimal
		
		BigDecimal bd1 = new BigDecimal("1.3");
		BigDecimal bd2 = new BigDecimal("1.2");
		
		System.out.println("1.3 - 1.2 = " + bd1.subtract(bd2));
		
		// autres types prédéfinis (primaires)
		/*
		 * short : entier sur 2 octets
		 */
		
		System.out.println("A + 3 = " + 'A' + 3 );
		System.out.println("A + 3 = " + ('A' + 3) );
		System.out.println("A + 3 = " + (char)('A' + 3) );
		
		/*
		 * dans l'instruction précédente ont a utilisé un transtypage (cast) explicite 
		 * Java peut utiliser des transtypage implicites aussi : 
		 * Exemple : int -> long, float -> double
		 *
		 */
		
		int i = 3;
		long l = i;
		/*
		 * Java transforme implicitement la valeur int de i en valeur
		 * long. La réciproque n'est pas vraie
		 * i = l; erreur, on ne peut pas caster implicitement un long en int 
		 * dans ce cas, je dois assumer moi-même la responsabilité de tronquer 
		 * et demander un cast explicite
		 */
		
		i = (int)l;
		l = Integer.MAX_VALUE + 1;
		System.out.println("l =" +1);
		i = (int)l;
		/*
		 * Attention : la valeur sera modifiée si elle dépasse la possibilité
		 * de stockage d'un type int
		 */
		System.out.println("i = "+i);

		/* 
		 * D'autres casts explicites sont impossible et ils ne seront pas acceptés par 
		 * le compilateur
		 */
		
		/*
		 * i = (int)"123" => cast rejeté par le compilateur
		 */
		
		/*
		 * les classes qui contiennent des informations concernant les types
		 * primaires (prédéfinis) contiennent des méthodes utilitaires de type parse() 
		 * qui obtiennent une valeur numérique à partir d'une chaine de caractères
		 *  
		 */
		i = Integer.parseInt("123");
		System.out.println("\"123\" + 1 = " + "123" + i);
		System.out.println("i + 1 = " + (i +1));
		
		// même chose pour un réel simple précision (float)
		
		vf = Float.parseFloat("123.45");
		
		/*
		 *  Type String 
		 *  String est une classe -> les chaines de caractères sont stockés
		 *  dans le tas de l'application et la variable qui 'contient' la chaine de 
		 *  contient en fait l'adresse de l'endroit où la chaien a été déposé
		 */
		
		String nom = "Jean";
		// l'instruction précédente est en fait un raccourci (syntax sugar)
		// de l'instruction suivante
		
		String prenom = new String("Albert");
		
		/*
		 * Comme les variables nom et prenom ne contiennent pas l'information 
		 * mais l'adresse où l'information se trouve, une variable String est une
		 * variable de type référence
		 * En java, une chaine de caractèrs une fois créée n'est pas modifiable
		 * Effectivement, la classe String ne dispose pas de méthode "bang" 
		 * (les méthodes surnomées bang modifient l'instance qui les appelle)
		 */
		
		String formation = "Java";
		String formation2 = "Java";
		String formation3 = "Ja";
		formation3 += "va";
		
		System.out.println("Formation: " + formation + " ,formation 3:" + formation3);
		System.out.println("Formation == formation3 : " + (formation == formation3));
		System.out.println(formation.equals(formation3));
		System.out.println("Formation == formation2 : " + (formation == formation2));
		
		String formations = "Java, HTML, CSS, JavaScript, UML, TypeScript";
		int pos = formations.indexOf("Script");
		System.out.println("Poition de la première occuence de Script : " + pos);
		pos = formations.lastIndexOf("Java");
		System.out.println("Poition de la dernière occuence de Java : " + pos);
		System.out.println("La chaine \"java\" " + ((formations.indexOf("java") >= 0) ? "exite" : "n'existe pas") + " dans la formation");
		
		/*
		 * Pour trouver si une sous-chaine est présente dans une chaine étudiée
		 * on utilise la méthode contains()
		 */
		
		System.out.println((formations.contains("java") ? "oui" : "non" ));
		
		/*
		 * \b - backspace - retour arrière 
		 * \f - formfeed - nouvelle page
		 * \t - tabulation horizon 
		 * \v - tabulation verticale
		 *  
		 */
		
		/*
		 * Extraction de sous chaines
		 * Extraire la sous-chaine à partir de la position 10
		 */
		
		String[] formations2 = formations.split(", ");
		for(int index = 0; index < formations2.length; index++)
		{
			System.out.println(formations2[index]);
		}
		
		/*
		 * Créer un tableau d'entiers vide 
		 * 
		 * Les tableaux : 
		 * - les tableaux ne sont pas extensibles (leur taille est fixe)
		 * - les tableaux n'ont qu'une seuke dimension
		 * (néanmoins, on peut créer des structures de tableaux qui 
		 * se comporte comme des tableaux multidimensionnels (Jagged array = 
		 * tableau déchiqueté)
		 *
		 */
		
		int[] tb = new int[5];
		tb[0] = 420;
		tb[1] = 13;
		tb[2] = 37;
		
		/*
		 * Evidement, les tableaux déchiquetés peuvent contenir
		 * d'autres types de données
		 * Exemple : tableaux contenant des chaines de caractères.
		 */
		
		String[][] tbNomPrenom = 
			{
				{
					"Durant", "Pierre"
				},
				{
					"Ducon", "Martin"
				},
				{
					"Dupond", "Michel"
				},
			};
		
		for(Object[] personne : tbNomPrenom) {
			System.out.println("Je m'appelle "+personne[0]+" "+personne[1]);
		}
		/*
		 * Un tableau est un objet
		 * Un tableau est un type référence
		 * Cela peut avoir des consèquences quand on veut obtenir une 
		 * copie du tableau
		 */
		
		int tb1[] = {1,2,3};
		
		/*
		 * Comme j'ai l'intention de modifier ce tableau, je 
		 * voudrais faire une sauvegarde
		 * 
		 */
		
		int tbSauvegarde[] = tb1;
		
		// Je modifie tb1
		
		tb1[0] = 11;
		AfficherTableau(tb1);
		AfficherTableau(tbSauvegarde);
		
		/*
		 * Pour créer une vraie sauvegarde on peut : 
		 * - créer 2 tableaux et copier les données du 1er
		 * - utiliser la méthode clone qui existe pour tous les objets java
		 */
		
		int[] tbSauvegarde2 = new int[tb1.length];
		for(int n = 0; n < tbSauvegarde2.length; n++) {
			tbSauvegarde2[n] = tb1[n];
		}
		
		// modification de tb1
		
		tb1[0] = 111;
		System.out.println("Le contenu de tb1 après la 2e modif");
		AfficherTableau(tb1);
		System.out.println("Le contenu de tbSauvegarde2 après la 2e modif");
		AfficherTableau(tbSauvegarde2);

		/*
		 * Utilisation de clone()
		 */
		
		int[] tbSauvegarde3 = tb1.clone();
		
		// modification de tb1
		
		tb1[0] = 1111;
		System.out.println("Le contenu de tb1 après la 3 modif");
		AfficherTableau(tb1);
		System.out.println("Le contenu de tbSauvegarde3 après la 2e modif");
		AfficherTableau(tbSauvegarde3);
		
	
		
		
	}
	
	/*
	 * Si je veux obtenir une modification, je dois utiliser un objet 
	 * dans ces cas java passe sa référence par copie et le paramêtre contenant cette référence
	 * est copiée, pointe sur le même objet que celui de l'appelant
	 */
	
	int[] tbTest = {1,2};
	
	static void AfficherTableau(int[] tb) 
	{
		for(int element : tb) 
		{
			System.out.print(element + "\t");
		}
		System.out.println();
	} 
	
	static void interchanger2(int[] tb) {
		int tmp = tb[0];
		tb[0] = tb[1];
		tb[1] = tmp;
	}
}
