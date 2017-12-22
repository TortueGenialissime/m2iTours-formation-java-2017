/*
 * Nouvelle version de la classe employe qui utilise une autre façon de définir l'énumération
 * des services 
 */
package fr.m2i.etudesjava;

public class Employe3 extends Personne implements Iimposable
{
	private float salaire;
	private String societe;
	/*
	 * cette fois, j'associe plusieurs valeurs personnalisées à chaque item de 
	 * l'énumération
	 * je veux éliminer le tableau contenant les noms de chaque service et stocker directement ce non 
	 * au niveau de l'énumération 
	 * 
	 */
	public static enum ServicesV3
	{
		DIRECTION(2, "Direction"),
		COMMERCIAL(0, "Service commercial"),
		RELATION_CLIENTS(3, "Relation clients"),
		SAV(1, "Service après-vente");
		
		/*
		 * champs d'instance qui contiendra la valeur associée 
		 */
		
		private int valeur;
		private String libelle;
		
		// constructeur de l'énumération
		
		private ServicesV3(int valeur, String libelle) 
		{
			this.valeur = valeur;
			this.libelle = libelle;
		}
		
		/*
		 * getter capable de fournir la valeur associée à chaque item
		 */
		
		public int getValeur() 
		{
			return valeur;
		}
		
		public String getLibelle()
		{
			return libelle;
		}
		
	};
	private ServicesV3 service;

	public Employe3(String nom, String prenom, int civilite, float salaire, String societe, ServicesV3 service) {
		super(nom, prenom, civilite);
		this.salaire = salaire;
		this.societe = societe;
		this.service = service;
	}
	
	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public ServicesV3 getService() {
		return service;
	}

	public void setService(ServicesV3 service) {
		this.service = service;
	}

	@Override
	protected String getDetails() 
	{
		return super.getDetails() + ", salaire : " + salaire + "€, societe : " + societe + ", service : "
	+ service.getLibelle();
	}
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
