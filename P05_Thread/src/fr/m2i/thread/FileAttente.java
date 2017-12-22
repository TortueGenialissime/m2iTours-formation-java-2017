package fr.m2i.thread;

import java.util.Map;
import java.util.Vector;

public class FileAttente extends MonContainer implements ContainerStatistique{
	private int dureeTache = 22;
	private int countEntrees = 0;
	private int countSorties = 0;
	private int dureeEntrees = 0;
	private int dureeSorties = 0;
	private Vector<Personne> instances = new Vector<>();
	private int countPersonnes = instances.size();
	
	public Vector<Personne> getInstances(){
		return this.instances;
	}
	

	public void ajouter(Personne personne, int time) {
		instances.addElement(personne);
		countEntrees++;
		dureeEntrees += time;
	}
	public void retirer(Personne personne, int time) {
		instances.remove(personne);
		countSorties++;
		dureeSorties += time;
	}
	
	public Personne peek(int index)
	{
		return instances.get(index);
	}
	
	public Personne peek() 
	{
		int lastIndex = instances.size()-1;
		return instances.get(lastIndex);
		
	}
	
	public int returnPos(Personne personne)
	{
		int i = 0;
		for(Personne p : instances)
		{
			i++;
			if(p.equals(personne)) {
				break;
			}
		}
		return i+1;
	}
	
	public boolean exist(Personne personne)
	{
		boolean bool = false;
		for(Personne p : instances)
		{
			if(p.equals(personne)) 
			{
				bool = true;
				break;
			}
		}
		return bool;
	}
	
	
	@Override
	public String getNbObjets() {
		return "Le "+ instances.getClass().getSimpleName() + " contient " + instances.size() +" objets";
	}
	
	public void retirerPremier(int time)
	{
		if(instances.size() > 0)
		{
			instances.remove(0);
			countSorties++;
			dureeSorties += time;
		}
	}
	
	public int getAttenteMoyenne(Personne personne)
	{
		if(exist(personne))
		{
			int attente = (int) ((returnPos(personne) * getNbMoyenSortiesParSeconde())/2000);
			return attente;
		}
		else {
			throw new RuntimeException("Calcul impossible : la personne n'est pas dans fille d'attente");
		}
		
	}
	
	public String afficherFile() 
	{
		String tabFile = "";
		for(Personne p : instances) 
		{
			tabFile += "----------------------------------------------------------------------------------------------\n"+
						p.toString()+"Temps d'attente estimée : "+ getAttenteMoyenne(p) +"\n";
		
		}
		tabFile += "----------------------------------------------------------------------------------------------\n";
		return tabFile;
	}
	
	public void AddGeneratedPersonne(int time) {
		while(true)
		{
			Personne generated = Personne.generatePersonne();
			if(!exist(generated))
				ajouter(generated, time);
				break;
		}
	}
	@Override
	public float getNbMoyenEntreesParSeconde() 
	{
		return (countEntrees > 0) ? (dureeEntrees / countEntrees) : 0;
	}
	@Override
	public float getNbMoyenSortiesParSeconde() 
	{
		return (countSorties > 0) ? (dureeSorties / countSorties) : 0;
	}
	
}
