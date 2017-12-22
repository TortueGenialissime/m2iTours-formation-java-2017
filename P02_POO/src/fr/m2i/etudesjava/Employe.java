package fr.m2i.etudesjava;

public class Employe extends Personne implements Iimposable
{
	private float salaire;
	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	private String societe;
	/*
	private int service;
	public static final int Direction = 0;
	public static final int Comptabilite = 1;
	public static final int ServiceCommercial = 2;
	public static final int SAV = 3;
	*/
	
	/*
	 * On a constaté lors de l'utilisation de la classe personne 
	 * que la définition de la civilité et de la langue comme des 
	 * types int nous a obligé à faire de nombreuses vérifications
	 *  et validations dans les constructeurs et setters (car le type
	 *  int n'interdit pas les valeurs abérantes comme par exemple
	 *  100 pour la langue et 50 pour la civilité
	 *  
	 *  Cette fois, on va utiliser des valeurs autorisés par une énumération
	 *  
	 *  Tout comme les classes et les interfaces, un énumération définit 
	 *  un type
	 */
	
	public static enum ServicesV1{DIRECTION, COMMERCIAL, RELATION_CLIENTS, SAV};
	
	/*
	 * Champs d'instance qui précise le service ou travaille l'mployé 
	 * Comme je ne veux autoriser pour ce champs que des valeurs définies 
	 * par l'énumération ServicesV1, j'utilise ce type ServicesV1 pour mon champ
	 */
	
	private ServicesV1 service;

	/*
	 * revenir ici pour définir d'autres versions possibles pour cette énumération
	 */
	
	public Employe(String nom, String prenom, int civilite, float salaire, String societe, ServicesV1 service) {
		super(nom, prenom, civilite);
		this.salaire = salaire;
		this.societe = societe;
		this.service = service;
	}
	/*
	 * pour afficher le contenu d'un employe, je dois overrider la méthode toString() 
	 * de Personne 
	 * Mais, en regardant son code, je me rends compte que si je réécris seulement 
	 * la methode getDetails, la methode getDetails  conviendra aussi pour Employe 
	 */
	
	@Override
	protected String getDetails() 
	{
		/*
		 * Je veux ajouter les informatiions supplémentaires à la chaîne créée par la 
		 * méthode getDetails de la superclasse 
		 */
	
		// return super.getDetails() + ", salaire : " + salaire + "€, societe : " + societe + ", service : " + service;
		return super.getDetails() + ", salaire : " + salaire + "€, societe : " + societe + ", service : " + tbServices[service.ordinal()];
	}
	/*
	 * Definir un tableau contenant les noms des différents services 
	 */
	
	private String[] tbServices = 
			{"Direction", 
			"Service commercial", 
			"Relation clients", 
			"Service après-vente"
			};
	
	@Override
	public double calculerImpot()
	{
		double seuil1 = 10000, coef1 = 0.1;
		double seuil2 = 25000, coef2 = 0.3;
		double seuil3 = 40000, coef3 = 0.5;
		
		double salaireAnnuel = getSalaire()*12;
		
		if(salaireAnnuel <= seuil1) {
			return 0;
		}
		else if(salaireAnnuel <= seuil2){
			return (salaireAnnuel - seuil1)*coef1;
		}
		else if(salaireAnnuel <= seuil3){
			return (seuil2 - seuil1)*coef1 + (salaireAnnuel - seuil2)*coef2;
		}
		else {
			return (seuil2 - seuil1)*coef1 + (seuil3 - seuil2)*coef2+(salaireAnnuel - seuil3)*coef3;
		}
		
	}
	
}
