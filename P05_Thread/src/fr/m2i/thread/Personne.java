package fr.m2i.thread;

public class Personne {
	public static String[] tabNom = {"Durand", "Le Gall", "Martin", "Thomas", "Roux", "Richard", "Dubois", "Morel", "Girard" , "Mercier", "Garnier"};
	public static String[] tabPrenom = {"Emma", "Jade", "Louis", "Gabriel", "Julien", "Tom", "Zoé", "Lina", "Eva", "Camille", "Manon", "Théo", "Nathan"};
	public static String[] typeVoie = {"allée", "rue", "cité", "résidence", "boulevard"};
	public static String[] tabVoie = {"de la Gare", "Maréchal Pétain", "Grande Rue", "du Moulin", "du Château", "du Stade", "Pasteur"};
	public static String[] tabVille = {"Lyon", "Tours", "Chartres", "Nantes", "Paris", "Montpellier", "Marseille", "Metz", "Le Havre", "Biaritz", "Quimper"};
	private String nom, prenom, adresse, ville;
	private int codePostal;
	
	public Personne() {
		
	}
	
	public Personne(String nom, String prenom, String adresse, String ville, int codePostal) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getCodePostal() {
		return codePostal;
	}
	@Override
	public String toString() {
		return nom + " " + prenom;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	public static String generateinTab(String[] tab) {
		int max = tab.length-1;
		int min = 0;
		int random = min + (int)(Math.random() * ((max - min) + 1));
		
		return tab[random];
	}
	
	public static String generateAdresse()
	{
		int nbVoie = 10;
		return nbVoie + " "+ generateinTab(typeVoie)+" "+generateinTab(tabVoie);
	}
	
	public static Personne generatePersonne()
	{
		Personne generatedPersonne = new Personne();
		generatedPersonne.setNom(generateinTab(tabNom));
		generatedPersonne.setPrenom(generateinTab(tabPrenom));
		generatedPersonne.setAdresse(generateAdresse());
		generatedPersonne.setVille(generateinTab(tabVille));
		generatedPersonne.setCodePostal(01000 + (int)(Math.random() * ((95999 - 01000) + 1)));
		return generatedPersonne;		
	}
}
