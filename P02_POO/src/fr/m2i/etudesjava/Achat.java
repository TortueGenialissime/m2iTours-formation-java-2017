package fr.m2i.etudesjava;

public class Achat implements Iimposable{
	public static enum TypesTVA{TVA0, TVA1, TVA5, TVA20};
	
	private double prixHT;
	private TypesTVA typeTVA;
	public Achat(double prixHT, TypesTVA typeTVA) {
		this.prixHT = prixHT;
		this.typeTVA = typeTVA;
	}
	
	@Override
	public double calculerImpot()
	{
		double taux;
		
		switch(typeTVA)
		{
		case TVA0:
			taux = 0;
			break;
		
		case TVA1:
		taux = 0.02;
		break;
	
		case TVA5:
			taux = 0.055;
			break;

		default:
			taux = 0.2;
			break;
		}
		
		return prixHT * taux;
	}
	
	
}
