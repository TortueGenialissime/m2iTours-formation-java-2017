/*
 * Exception - condition qui sort du traaitement normal assur� �r l'application
 * (condition normale)
 * 
 * Exemple d'exception: division pas z�ro; acc�s � un �lement du tableau en dehors
 * de ses limites, tentatives de lecture d'un fichier qui n'existe pas,
 * tentative de transtypage d'un objet d'un type qui n'existe pas
 * 
 * ces diff�rentes exceptions sont d�finies par des classes d'exception 
 * 
 * par exemple une exception de classe IndexOutOfBoundsException sera lev�:
 * pour un acc�s dans un tableau en dehors de ses limites, IOException
 * sera lev�e quand l'acc�s � un fichier �choue, etc
 * 
 * Une fois lev�e, une exception doit �tre rattrap�e.
 * si elle n'est pas rattrap�e localement(au niveau de la m�thode o� elle a �t� lev�e),
 * elle commence �) se propager : elle monte vers l'appelant 
 * la propagation continue tant que l'exeption n'est pas rattrap�e/trait�e
 * 
 * Si au dernier niveau (le niveau le plus haut, c'est � dire la m�thode main)
 * L'exception n'est pas rattrap�e, l'application plante
 */

package fr.m2i.etudesjava;

import java.util.Random;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String saisie;
		
		while(true)
		{
			//System.out.println("Que voulez vous me dire ?");
			saisie = sc.nextLine();
			if(saisie.toLowerCase().startsWith("q"))
			{
				System.out.println("Au revoir !");
				//break; //sortir de la boucle �ternelle 
				sc.close();
				//si je veux retourner un code de sorti vers l'OS,
				//je peux utiliser exit(code de retour)
				System.exit(0);
			}
			//System.out.println(saisie);
			
			/*
			 * on peut envisager de tous rattraper au niveau le plus �l�v� dans mais dans ce cas il est plus 
			 * il est  plus difficile de prendre une d�cision d'intervenir avec plus d'efficacit�
			 * que si j'assure le rattrapage � un niveau plus rapprocher de l'endroit
			 * o� l'exception a �t� lev�e
			 */
			f1();
				
		}//fin while
	
	}//fin main()
	
	private static void f1()
	{
		Random random = new Random();
		int n = random.nextInt(7);// g�n�re tous les entiers entre 0 et valeurSp�cifi� -1
		//System.out.println(n);
		try
		{
		switch (n) {
		case 0:
			f2a();
			break;
			
		case 1:
			f2b();
			break;
			
		case 2:	
			f2c();
			break;
		
		case 3:		
			f2d();
			break;
		case 4:
			
			//f2e();
			break;
		case 5:
			
			f2f();
			break;
		case 6:	
			f2g();
			break;
		}
		}
		catch (ArithmeticException ex)
		{
			System.out.println("Une exception arithm�tique a �t� lev�e\n " +
		"Raison invoqu�e: " + ex.getMessage());
			
		}
		catch (ClassCastException ex)
		{
			System.out.println("Une exception ClassCastException a �t� lev�e\n " +
					"Raison invoqu�e: " + ex.getMessage());
						
		}
		
		catch (ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Une exception ClassCastException a �t� lev�e\n " +
					"Raison invoqu�e: " + ex.getMessage());
						
		}
		catch (ExceptionFormation ex)
		{
			System.out.println("Une exception ExceptionFormation, a �t� lev�e\n" +
					"Message : " + ex.getMessage() +
					"\nGravité : " + ex.getGravite() + 
					"Infos supplémentaires ; " + ex);
						
		}
		
		/*
		 * Bloc de rattrapage générique où on traite toutes les exceptions 
		 * n'ayant pas de catch personnalisé 
		 */
		catch (Exception ex)
		{
			System.out.println("Une exception Exception, a �t� lev�e\n " +
					"Type d'exception : " + ex.getClass().getSimpleName() +
					"Raison invoqu�e: " + ex.getMessage());
		}
		System.out.println("Fin m�thode f1()");
	}//fin de la m�thode f1
	

	private static void f2a()
	{
		// lever une Exception de r�f�rence null
		String maChaine = null;
		//maChaine.trim();
		
		//cette instruction l�ve une exception car on ne peut pas appeler une m�thode d'instance
		//qui n'existe pas 
		
		//comme il n'y a pas de rattrapage � ce niveau (ici m�me), l'exeption commence
		//sa propagation vers le niveau sup�rieur
		
		//si on veut la rattraper ici mm(arreter sa propagation) il faut utilis� un bloc de rattrapage
		/*
		 * un tel bloc contient une clause try obligatoire
		 * une clause catch(ou plusieurs optionnel)
		 * une clause finally (optionnelle)
		 * 
		 * Remarque: try doit �tre suivi par au moins:
		 * une clause catch
		 * une clause finally
		 */
		try
		{
			maChaine = maChaine.trim();
		} 
		catch (NullPointerException ex)
		{
		//un bloc catch contient les instructions � ex�cuter si une exception
			//a �t� lev�e dans le bloc try
			System.out.println("Le type d'exception lev�e dans f2a(): " +
			ex.getMessage());
			System.out.println("La pile du programme: ");
			
			/*
			 * si dans catch une exception est lev�e sans quel soit contenu dans autre try catch
			 * elle va commenc� � se propager
			 */
			int i = 5/0;
			//apr�s cette expetion qui l�ve une exception le system cherche un blos
			// de rattrapage et il abandonne l'ex�cution normale de l'application
			//pour cette raison l'instruction ne sera pas ex�cuter
			
			System.out.println("Ce message est plac� juste apr�s la division par z�ro");
		}
		finally 
		{
			/* les instructions d'un bloc finally sont toujours ex�cuter
			 * en cas de succ�s
			 * en cas d'�chec
			 * ou mm si une instruction return � �t� recontr�es dans les blocs
			 * try ou catch 
			 */
			System.out.println("je passe par le bloc finally f2a().");
		}
	}//fin f2a()
	
	private static void f2b()
	{
		//lev�e une exception d'indexation
		int[] tb = new int[3];
		
		//initialiser l'�l�ment index� par 5 
		
		tb[5] = 10;
	}

	private static void f2c()
	{
		// lever une exception de transtypage
		
		// cr�er un objet non typ�
		
		Object obj = new Object();
		
		// d�finir une variable capable de contenir un tableau
		
		int[] tb ;
		
		tb = (int[])obj;
		
	}
	
	private static void f2d() {
		int tb[] = null;
		tb[0] = 0;
	}
	
	/*
	 * Méthode qui lève explicitement une exception de type
	 * Exception
	 */
	private static void f2e() throws Exception {
		float temperature = -2;
		if(temperature < 0)
			throw new Exception("Attention temperature négative");
		/* Le simple fait de créer une exception avec new exception n'assure pas sa propagation 
		 * 
		 * Il faut la lever pour qu'elle commence à se propager 
		 * Exception ex = new Exception("message");
		 * throw ex;
		 * 
		 * J'ai utilisé le constructeur avec un argument car cela me permet de passer le message
		 * Effectivement, si je crée une exception sans message, je ne peux plus l'injecter après.
		 * 
		 * Exception ex = new Exception();
		 * ex.setMessage("blabla"); -> Méthode inexistante
		 */
	}
	
	private static void f2f() {
		int stock_iPhoneX = 5;
		if(stock_iPhoneX < 10)
		{
			throw new RuntimeException("Le stock d'iPhone X est insuffisant");
		}
	}
	
	private static void f2g() {
		int stock = 2;
		int gravite;
		
		String message = "";
		
		if(stock < 5)
		{
			gravite = 100;
			message = "Le stock est vide";
		}
		
		else if(stock < 50) 
		{
			gravite = 4;
			message = "Le stock est réduit";
		}
		
		else
		{
			gravite = 0;
		}
		
		if(gravite >= 2)
		{
			throw new ExceptionFormation(gravite, message);
		}
		
		/*
		 * On va lever une exception si la gravité est supérieure à 2
		 */
	}

}//fin classe Main
