package fr.m2i.thread;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		try {
		// TODO Auto-generated method stub
		FileAttente fa = new FileAttente();
		int count = 0;
		while(true)
		{
			if(count > 0) {
		        Runtime.getRuntime().exec("clear");
				System.out.print("\033[H\033[2J");
		        Runtime.getRuntime().exec("clear");
				System.out.println(fa.afficherFile());
				System.out.println("Une entrée toutes les "+ (float) (fa.getNbMoyenEntreesParSeconde()/1000)+" secondes\n"
						+ "Une sortie toutes les " + (float) (fa.getNbMoyenSortiesParSeconde()/1000)+" secondes\n"+
						fa.getNbObjets());
			}
				
			else {
				System.out.println(fa.afficherFile());
			}
			int randTime = fa.generateTime();
			if((Math.random() < 0.5))
			{
				fa.AddGeneratedPersonne(randTime);
			}
			else 
			{
				fa.retirerPremier(randTime);
			}
			count++;
			Thread.sleep(randTime);
		}
		//System.out.println(fa.afficherFile());
		
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
