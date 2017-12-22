package fr.m2i.etudesjava;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import fr.m2i.etudesjava.Achat2.TypesTVA;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Impossible de créer une instance de la classe commun car on a cache le constructeur 
		 * par défaut avec un constructeur personnalisée par nos soins.
		 * On a rendu ce constructeur en 'private '
		 */
		// Commun obj = new Commun;
		
		// création d'une personne
		/*
		 * Tester la méthode finalize() de Personne
		 * Je crée une certaine quantité d'instance de Personne sans stocker 
		 * leur référence
		 * Cela va diminuer la quantité de mémoire disponible et la VM va appeller le GC
		 * (qui va supprimer les instances non référencées)
		 *
		 */
		List<Object> reg = new ArrayList<Object>();
		DecimalFormat df = new DecimalFormat(".##");
		Employe e1 = new Employe("Chirac", "Jacques", Personne.M, 3000f, "Les retraités", Employe.ServicesV1.SAV);
		reg.add(e1);
		System.out.println(e1);
		Employe2 e2 = new Employe2("Croche", "Sarah", Personne.MME, 123456.78f, "Les biatchs", Employe2.ServicesV2.SAV);
		System.out.println(e2);
		reg.add(e2);
		Employe3 e3 = new Employe3("Croche", "Sarah", Personne.MME, 1234.56f, "Les biatchs", Employe3.ServicesV3.COMMERCIAL);
		reg.add(e3);
		System.out.println("Résultat de votre recherche : " + Personne.searchByNom("hjh").size());
		System.out.println(e3);
		
		MonPoint mp = new MonPoint();
		reg.add(mp);
		System.out.println(mp);
		MonRectangle mr = new MonRectangle(1.5, 10);
		reg.add(mr);
		System.out.println(mr);
		MonCarre mc = new MonCarre(10);
		reg.add(mc);
		System.out.println(mc);
		MonTriangle mt = new MonTriangle(10);
		reg.add(mt);
		System.out.println(mt);
		MonCercle mce = new MonCercle(1, 20, 1000);
		reg.add(mce);
		System.out.println(mce.calculerForceCentrifuge());
		MonDisque md = new MonDisque(1, 10, 15, "rouge");
		reg.add(md);
		System.out.println(md);
		/*
		 * L'instanciation suivante ne peut pas être accpetée car la figure géométrique 
		 * est abstraite
		 */
		// FigureGeometrique fg = new FigureGeometrique();
		Iimposable imposable = new Achat2(100, TypesTVA.TVA20);
		System.out.println("Impot : " + imposable.calculerImpot());
		reg.add(imposable);
		imposable = new Habitation(50, 750);
		reg.add(imposable);
		
		imposable = new Terrain(1000, Terrain.TypesTerrain.AGRICOLE);
		reg.add(imposable);
		System.out.println(reg.size());
		int nbFigure = 0, nbRectangle = 0, nbPersonne = 0, nbEmploye = 0;
		double nbImpot = 0;
		for(Object elm : reg)
		{
			if(elm instanceof FigureGeometrique)
			{
				nbFigure++;
			}
			
			if(elm instanceof Iimposable)
			{
				nbImpot += ((Iimposable) elm).calculerImpot();
			}
			if(elm instanceof MonRectangle && !(elm instanceof MonCarre)) {
				nbRectangle++;
			}
			if(elm instanceof Personne)
			{
				nbPersonne++;
			}
			
			if(elm instanceof Employe || elm instanceof Employe2 || elm instanceof Employe3)
			{
				nbEmploye++;
			}
		}
		System.out.println("Somme des impôts : " + nbImpot + " - Il y a "+nbFigure+" figures dont "+nbRectangle+" rectangles. Il y a aussi "+nbPersonne+" personnes dont "+nbEmploye+ " employés");
	}
}
