package fr.m2i.thread;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CarnetAdresses extends MonContainer {
	public static TreeMap<Integer, Personne> instances = new TreeMap<>();
	private static int countPersonnes = 0;
	
	public TreeMap<Integer, Personne> getCarnet()
	{
		return instances;
	}
	
	@Override
	public String getNbObjets() {
		return "L'"+ instances.getClass().getSimpleName() + "contient" + instances.size();
	}
	
	public boolean exist(Personne personne)
	{
		boolean bool = false;
		String name = personne.getPrenom();
		String surname = personne.getNom();
		for(Map.Entry<Integer, Personne> entry : getCarnet().entrySet()) 
		{
			if((entry.getValue().getNom()+entry.getValue().getPrenom()).toLowerCase().equals((personne.getNom()+personne.getPrenom()).toLowerCase()))
			{
				bool = true;
				break;
			}
			else {
				bool = false;
			}				
		}
		return bool;
	}
	
	public boolean exist(String nom, String prenom)
	{
		boolean bool = false;
		String name = nom;
		String surname = prenom;
		for(Map.Entry<Integer, Personne> entry : getCarnet().entrySet()) 
		{
			if((entry.getValue().getNom()+entry.getValue().getPrenom()).toLowerCase().equals((nom+prenom).toLowerCase()))
			{
				bool = true;
				break;
			}
			else {
				bool = false;
			}				
		}
		return bool;
	}
	
	public void insert(Personne personne)
	{
		if(!exist(personne))
		{
			instances.put(countPersonnes++, personne);
			
		}
		else {
			throw new RuntimeException("Une personne avec un nom ou prénom identique existe déjà dans le carnet");
		}
	}
	
	public void delete(Personne personne) 
	{
		for(Map.Entry<Integer, Personne> entry : getCarnet().entrySet()) 
		{
			if(entry.getValue().equals(personne))
			{
				instances.remove(entry.getKey());
				break;
			}
		}
	}
	
	public void delete(String nom, String prenom)
	{
		for(Map.Entry<Integer, Personne> entry : getCarnet().entrySet()) 
		{
			if((entry.getValue().getNom()+entry.getValue().getPrenom()).toLowerCase().equals((nom+prenom).toLowerCase()))
			{
				instances.remove(entry.getKey());
				break;
			}

		}
	}
	
	public String afficherCarnet() 
	{
		String tabPile = "";
		for(Map.Entry<Integer, Personne> entry : getCarnet().entrySet()) 
		{
			tabPile += "----------------------------------------------------------------------------------------------\n"+
						entry.getValue().toString()+"\n";
		
		}
		tabPile += "----------------------------------------------------------------------------------------------\n";
		return tabPile;
	}
	public void AddGeneratedPersonne() {
		while(true)
		{
			Personne generated = Personne.generatePersonne();
			if(!exist(generated))
				insert(generated);
				break;
		}
	}
	
}
