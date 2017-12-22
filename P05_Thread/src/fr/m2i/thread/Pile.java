package fr.m2i.thread;

import java.util.ArrayList;

public class Pile extends MonContainer implements ContainerStatistique {
	public static int id = 0;
	private ArrayList<Personne> instances = new ArrayList<>();
	
	private ArrayList<Personne> getPile(){
		return instances;
	}
	public void push(Personne personne) {
		instances.add(personne);
	}
	
	public void pop() 
	{
		if(getPile().size() >= 1)
			getPile().remove(getPile().size()-1);
	}
	public void pop(Personne personne) {
		if(getPile().contains(personne))
			getPile().remove(personne);
	}
	
	
	@Override
	public String getNbObjets() {
		return "Le "+ instances.getClass().getSimpleName() + " contient " + instances.size() +" objets";
	}
	
	public String afficherPile() 
	{
		String tabPile = "";
		for(Personne elm : getPile())
		{
			tabPile += "-------------------------------------------\n"+
						id+++"       "+elm.getPrenom()+" "+elm.getNom()+"\n";
		
		}
		tabPile += "-------------------------------------------\n";
		return tabPile;
	}
	
	public void AddGeneratedPersonne() {
			Personne generated = Personne.generatePersonne();
			push(generated);
	}
	@Override
	public float getNbMoyenEntreesParSeconde() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public float getNbMoyenSortiesParSeconde() {
		// TODO Auto-generated method stub
		return 0;
	}

}
