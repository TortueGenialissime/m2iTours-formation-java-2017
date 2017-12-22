package fr.m2i.etudesjava;

/*
 * Une interface est une collection de : 
 * - Méthodes sans corps en précisant seulement leurs signatures et type 
 * de retours 
 * - Des constantes static du genre => static final ...
 * 
 * Les classes qui implémentent une interface doivent proposer un corps pour toutes les méthodes imposées par 
 * l'interface
 * 
 * De ce point de vue, on peut voir l'interface comme un contrat : 
 * les classes qui signent le contrat doivent respecter ses clauses (c'est à dire implémenter
 * les méthodes de l'interfaces)
 * 
 * Une classe peut hériter d'une seule autre classe (Java n'autorise pas l'héritage multiple)
 * mais peut implémenter plusieurs interfaces (pas de limites)
 * 
 * Tout comme les classes et les énumérations, une interfaces définit un type 
 * si une classe A est héritée par une classe B et si la classe B implémente l'interface C, la classe B est du type : 
 * - A
 * - B
 * - C
 * 
 * Une même classe peut avoir donc plusieurs profils
 * On appelle ceci le polymorphisme
 */
interface IMesurable
{
	double calculerPerimetre();
}
/*
interface Iinscriptible
{
	int getAngles();
}
*/


interface Iinscriptible extends IMesurable
{
	int getAngles();
}

interface Iimposable 
{
	default String getAdresseCentreImpot() 
	{
		return "Centre Impot Paris, 1 rue Rivoli, 75001 Paris";
	}
	
	default String getAdresseImposable()
	{
		return "Paris";
	}
	
	public double calculerImpot();
}


/*
 * Je constate que les figures géométrique qui sont Iinscriptible sont aussi Imesurable
 * Cela me fait penser que Iinscriptble et Imesurable se trouve dans une association "is a" (est un/une) : 
 * une figure Iinscriptible et IMesurable aussi 
 * Conclusion ; Iinscriptible peut être héritée de IMesurable
 * 
 * Ici : 
 * - IMesurable s'appelle SuperInterface
 * - Iinscriptible s'appelle SousInterface
 * Maintenant l'interface Iinscriptible impose l'implémentaion 
 * des méthodes héritées (ici une seule : calculerPerimetre)
 * et de ses propres méthodes
 */

interface ITrajectoireCirculaire
{
	double calculerForceCentrifuge();
}
