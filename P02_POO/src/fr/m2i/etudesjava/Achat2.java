package fr.m2i.etudesjava;

public class Achat2 implements Iimposable{
	public static enum TypesTVA{
		
		TVA0(0.00),
		TVA1(0.02),
		TVA5(0.05),
		TVA20(0.2);
		
		private double taux;
		private TypesTVA(double taux)
		{
			this.taux = taux;
		}
		
		public double getTaux()
		{
			return taux;
		}
		
	};
	
	private double prixHT;
	private TypesTVA typeTVA;
	public Achat2(double prixHT, TypesTVA typeTVA) {
		this.prixHT = prixHT;
		this.typeTVA = typeTVA;
	}
	
	@Override
	public double calculerImpot()
	{	
		return prixHT * typeTVA.getTaux();
		
	}
	
	
}
