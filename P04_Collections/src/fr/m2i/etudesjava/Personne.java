/*
 * Etudier les aspects fondamentaux de la POO :
 * - classes, objets
 * - Pilliers de la POO : 
 *		- encapsulation
 *		- héritage
 *		- polymorphisme + surcharge
 */

/*
 * Classe = modèle 
 * Objet = instance créée à partir du modèle
 * Dans une classe, on trouve : 
 *		- des champs : 
 *			- de classe (ou statique)
 *			- d'instance
 *		- des méthodes :
 *			- de classe 
 *			- d'instance
 *
 * Un champ statique appartient à la classe et existe même si aucune instance
 * de la classe n'a été créée 
 * Exemples : 
 * 	- vitesse maximum sur l'autoroute (130)
 * 	- le nombre de roues d'une automobile (4)
 * 
 * Un champ d'instance appartient à l'instance et son contenu varie d'une instance
 * à l'autre
 * Exemple : 
 * 	- la couleur d'une voiture
 * 	- la vitesse instantanée d'une voiture 
 * 	- l'age d'une personne 
 * 	- nom, prénom 
 * 	- (...)
 * 
 * Les méthodes définissent des comportements (des actions)
 * Ces méthodes peuvent executer des traitements, véhiculer des données
 * (créer, modifier, changer, sauvegarder, communiquer par des fichiers ou 
 * par réseau etc.)
 * 
 * Les méthodes classe appartiennent aux classes et ne peuvent pas accéder aux 
 * membres (champs ou méthodes) d'instances.
 * Exemples : 
 * 	- ChangerVMaxAutoroute()
 * 	- retourner la formule chimique de l'eau
 * 
 * Les méthodes d'instance appartiennent aux instances (aux objets)
 * Exemples : 
 * 	- freiner(), accelerer(), changeProprietaire
 * 	- augmenterSalaire(), changerSociete()
 * 
 *  ----------------- ENCAPSULATION -----------------
 *  Ensemble de techniques permettant de séparer, d'isoler l'interieur d'un 
 *  objet par rapport à l'exterieur
 *	Cette séparation est mise en oeuvre par : 
 *		- des modificateur d'accès
 *		- des accesseurs
 *
 *	Les modificateurs d'accès : mots clés qui gèrent la visibilité (l'accès) aux
 *	champs est aux méthodes des restrictions d'accès).
 *	Java connait : 
 *		- Private : 
 *		- Protected : 
 *		- Public
 * 
 * 	Un champs ou une méthode 'private' n'est accessible qu'à l'interieur de la classe
 * 
 * 	Un champs ou une méthode 'protected' n'est accessible qu'à l'interieur de la classe
 * 	et dans les classes héritées 
 * 
 * 	Un champs ou une méthode 'public' est accessible sans restriction
 * 
 * 	Si aucun modificateur d'accès n'est précisé, les champs et méthodes sont : 
 * 		- Accessibles à l'interieur de la classe 
 * 		- Accessibles aux classes faisant partie du même package.
 * 		- Inaccessibles aux autres classes 
 * 
 * 	Une classe ne peut être que 'public' ou rien (pas de modificateur d'accès)
 * 	Néanmoins, les classes internes (inner classes) peuvent être 'private' ou 
 * 	'protected'.
 *  
 * 
 */


package fr.m2i.etudesjava;

import java.util.ArrayList;
import java.util.List;

public class Personne implements Iidentifiable 
{
	private String nom;
	private String prenom;
	private int civilite;
	private int langue = Commun.FR;
	private static int nbPersonne = 0;
	private static List<Personne> instances = new ArrayList<Personne>();
	
	
	public String getNom() 
	{
		return this.nom;	
	}
	
	public static List<Personne> getInstances() {
		return instances;
	}
	
	public static int getNbInstances() 
	{
		return Personne.nbPersonne;	
	}
	
	public String getPrenom() 
	{
		return this.prenom;	
	}
	
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}
	
	public static final int M = 0;
	public static final int MME = 1;
	public static final int MELLE = 2;
	
	public Personne(String nom, String prenom)
	{
		setNom(nom);
		setPrenom(prenom);
		Personne.nbPersonne++;
		instances.add(this);
	}
	
	public Personne(String nom, String prenom, int civilite){	
		this(nom, prenom);
		if(!civiliteTest(civilite)) 
			throw new RuntimeException("Civilité "+civilite+" non valide.");	
		this.civilite = civilite;
	}
	public String toString() {
		return getClass().getSimpleName()+ " : "+getDetails();
	}

	private static String[][] tableauCivilite =
		{
				{"Monsieur","Madame","Mademoiselle"},
				{"Mister","Missis","Miss"},
				{"Heir","Frau","Fraulein"}
				
		};

	private String getCiviliteTexte() {
		return tableauCivilite[langue][civilite];
	}

	/*
	 * On a l'habitude de commencer le nom d'un accesseur en lecture par get, et en écriture
	 * pas set.
	 */

	int getCivilite() {
		return civilite;
	}

	/*
	 * Pour protéger l'intégrité des données stockées dans l'instance, je dois tester la valeur
	 * de la civilité passée en paramètre.
	 * 
	 */


	void setCivilite(int civilite) {
		if(civiliteTest(civilite) != true) {
			System.out.println(civilite+" n'est pas correct. Saisir correctement votre civilité.\n");
			return;
		}
		this.civilite = civilite;
	}

	private static boolean civiliteTest(int civiliteATester) {
		return civiliteATester >= 0 && civiliteATester <= 2;
	}
	

	protected String getDetails() {
		return getCiviliteTexte() + " " + nom + " " + prenom;
	}
	public static List<Personne> searchByNom(String nom)
	{
		List<Personne> result = new ArrayList<Personne>();
		for(Personne personne : Personne.getInstances())
		{
			if(nom.toLowerCase().contains(personne.getNom().toLowerCase()))
			{
				result.add(personne);
			}
		}
		return result;
	}
	
	public void modifierPersonne(String nom, String prenom) 
	{
		setNom(nom);
		setPrenom(prenom);
	}
	
	public void modifierPersonne(String nom, int civilite) 
	{
		setNom(nom);
		setCivilite(civilite);
	}
	public void modifierPersonne(int langue, String prenom) 
	{
		if(!Commun.estLangueSupportee(langue)) {
			System.out.println("Langue proposée n'est pas validée. La modification n'est pas faite");
			return;
		}
		
		setPrenom(prenom);
		this.langue = langue;
	}
	
	/*
	 * Java ne propose pas de destructeur
	 * A la place, il est possible d'override la methode hérité finalize()
	 * Cette méthode n'est jamais appellé directement mais par la VM Java 
	 * quand le GC a décidé de supprimer l'instance en question de la mémoire 
	 * Il s'agit d'ont d'un appel à la fois indirect aussi bien indirect qu'inderministe
	 * Le role de cette methode finalize est d'assurer une certaine liberation de ressource,
	 * envoyer des messages, etc.
	 * 
	 */	
	
	@Override
	protected void finalize() {
		System.out.println("L'instance " + nom + " " + prenom + "sera détruite");
	}
	static int id = 0;

	@Override
	public String créerClé() {
		String cle = "personne"+id;
		Personne.id++;
		return cle;
	}
	
	
}
