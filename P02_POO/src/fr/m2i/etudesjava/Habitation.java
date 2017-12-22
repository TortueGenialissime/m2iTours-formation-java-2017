package fr.m2i.etudesjava;

public class Habitation implements Iimposable 
{
	/*
	 * La taxe habitation dépend de : 
	 * - la surface de l'appartement
	 * - de la localisation de l'appartement
	 */
	
	private double surface;
	private int departement;
	
	public Habitation(double surface, int departement) {
		setSurface(surface);
		setDepartement(departement);
	}
	
	@Override
	public double calculerImpot()
	{
		switch(departement)
		{
		case 75:
		case 59:
		case 93:
			return 20 * getSurface();
			
		case 34:
		case 33:
			return 22 * getSurface();
		case 69:
			return 19 * getSurface();
		default:
			return 21 * getSurface();
		}
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public int getDepartement() {
		return departement;
	}

	public void setDepartement(int departement) {
		this.departement = departement;
	}
	
	
}
