/*
 * Nouvelle version de la classe employe qui utilise une autre façon de définir l'énumération
 * des services 
 */
package fr.m2i.etudesjava;

public class Employe2 extends Personne implements Iimposable
{
	private float salaire;
	private String societe;
	/*
	 * cette fois, je voudrais associer des valeurs personnalisées à chaque item de l'énumération
	 * Direction = 3, ..
	 */
	public static enum ServicesV2
	{
		DIRECTION(2), COMMERCIAL(0), RELATION_CLIENTS(3), SAV(1);
		
		/*
		 * champs d'instance qui contiendra la valeur associée 
		 */
		
		private int valeur;
		
		// constructeur de l'énumération
		
		private ServicesV2(int valeur) 
		{
			this.valeur = valeur;
		}
		
		/*
		 * getter capable de fournir la valeur associée à chaque item
		 */
		
		public int getValeur() 
		{
			return valeur;
		}
		
	};
	private ServicesV2 service;

	public Employe2(String nom, String prenom, int civilite, float salaire, String societe, ServicesV2 service) {
		super(nom, prenom, civilite);
		this.salaire = salaire;
		this.societe = societe;
		this.service = service;
	}
	
	@Override
	protected String getDetails() 
	{
		return super.getDetails() + ", salaire : " + salaire + "€, societe : " + societe + ", service : "
	+ tbServices[service.getValeur()];
	}
	
	private String[] tbServices = 
			{"Service commercial", 
			"Service après-vente",
			"Direction", 
			"Relation clients"
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

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	
	
}
