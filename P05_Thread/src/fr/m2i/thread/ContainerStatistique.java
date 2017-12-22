package fr.m2i.thread;

public interface ContainerStatistique {
	
	public float getNbMoyenEntreesParSeconde();
	public float getNbMoyenSortiesParSeconde();
	
	public default int generateTime()
	{
		int randomTime = (int)(Math.random() * ((10 - 2))) * 1000;
		return randomTime;
	}
	
	public default void addEntree()
	{
	}

	
}
