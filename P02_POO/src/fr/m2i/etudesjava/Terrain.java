package fr.m2i.etudesjava;

public class Terrain implements Iimposable
{
	/*
	 * La taxe foncière dépend de la nature du terrain
	 */
	
	public static enum TypesTerrain{
		AGRICOLE(0.1), 
		CONTRUCTIBLE(0.5);
	
		public double taux;
		
		private TypesTerrain(double taux)
		{
			this.taux = taux;
		}
		
		public double getTaux()
		{
			return taux;
		}
	
	};
	private double surface;
	private TypesTerrain typeTerrain;
	
	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public TypesTerrain getTypeTerrain() {
		return typeTerrain;
	}

	public void setTypeTerrain(TypesTerrain typeTerrain) {
		this.typeTerrain = typeTerrain;
	}

	public Terrain(double surface, TypesTerrain typeTerrain) {
		this.surface = surface;
		this.typeTerrain = typeTerrain;
	}
	
	@Override
	public double calculerImpot()
	{
		return typeTerrain.getTaux() * getSurface();
	}
	
	
}
