/*
 * Si une classe ,n'est pas précédé par le modificateur d'accès public
 * elle est accessible seulement dans son package
 * elle n'est pas forcée de porter le nom du fichier qui la contient 
 * elle peut ne pas être la seule class dans le fichier en question 
 */

package fr.m2i.etudesjava;

import java.text.DecimalFormat;

/*
 * Je veux créer une classe qui sera utiliser comme cadre pour les classes hérités 
 * elle aura une classe toString() pouvant être utilisée sans modification dans la 
 * plupart des sous classesahd 'accord 
 */
abstract class FigureGeometrique
{
	DecimalFormat df = new DecimalFormat(".##");
	@Override
	public String toString()
	{
		
		/*
		 * Cette méthode doit afficher : 
		 * le type de la figure géométrique 
		 * la valeur de sa surface
		 */
		
		return getClass().getSimpleName() + ", Aire : " +df.format(calculerAire())+"m2";
		
	}
	/*
	 * La méthode de calcul de l'aire d'une figure géométrique dépend de la figure 
	 * en question
	 * Conclusion : cette méthode ne peut pas être écrite
	 * Une méthode sans corps est une méthode abstraite, définit par le mot clé "abstract""
	 */
	
	public abstract double calculerAire();
	
	/*
	 * Une classe qui a une ou plusieurs méthodes abstraite doit être déclarée abstraite à son tour 
	 * 
	 * Une classe abstraite ne peut pas être instanciée (elle ne peut pas être utilisée pour 
	 * créer des objets 
	 * une telle classe ne peut servir de cadre pour des classes héritières 
	 */
}

class MonPoint extends FigureGeometrique
{
	/*
	 * je veux que cette classe soit concrète mais elle hérite la méthode abstraite calculerAire()
	 * 	qui rend la classe MonPoint abstraite
	 * 
	 * Pour obtenir une classe concrèten je dois override la/les méthodes abstraite/s et lui donner un corps 
	 */
	@Override
	public double calculerAire()
	{
		return 0;
	}
}

class MonRectangle extends FigureGeometrique implements Iinscriptible
{
	private double l;
	private double h;
	
	public MonRectangle(double l, double h) 
	{
		setL(l);
		setH(h);
	} 
	
	
	
	public double getL() {
		return l;
	}



	public void setL(double l) {
		this.l = l;
	}



	public double getH() {
		return h;
	}



	public void setH(double h) {
		this.h = h;
	}



	@Override
	public double calculerAire()
	{
		return getL()*getH();
	}
	
	public double calculerPerimetre() 
	{
		return (getL()+getH()) * 2;
	}



	@Override
	public int getAngles() {
		return 4;
	}
}

class MonCarre extends MonRectangle
{
	public MonCarre(double l) 
	{
		super(l, l);
	}
}

class MonTriangle extends FigureGeometrique implements Iinscriptible
{
	private double a,b,c;
	
	public MonTriangle(double a, double b, double c)
	{
		super();
		setA(a);
		setB(b);
		setC(c);
	}
	public MonTriangle(double a)
	{
		super();
		setA(a);
		setB(a);
		setC(a);
	}
	
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	@Override
	public double calculerAire() {
		double p = (a+b+c) / 2;
		return Math.sqrt(p * (p-a) * (p-b) * (p-c));
	}
	public double calculerPerimetre() 
	{
		return a+b+c;
	}
	@Override
	public int getAngles() {
		// TODO Auto-generated method stub
		return 3;
	}
	
}

class MonCercle extends FigureGeometrique implements IMesurable,ITrajectoireCirculaire
{
	private double r;
	private double masse, vitesse;
	
	public double getMasse() {
		return masse;
	}

	public void setMasse(double masse) {
		this.masse = masse;
	}

	public double getVitesse() {
		return vitesse;
	}

	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
	}

	public MonCercle(double r, double vitesse, double masse) {
		setR(r);
		setVitesse(vitesse);
		setMasse(masse);
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	@Override
	public double calculerAire()
	{
		return Math.PI * r * r;
	}

	@Override
	public double calculerPerimetre() {
		return 2*Math.PI*r;
	}

	@Override
	public double calculerForceCentrifuge() {
		masse = getMasse();
		vitesse = getVitesse();
		return masse*vitesse*vitesse/getR();
	} 
}

class MonDisque extends MonCercle
{
	private String couleur;

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public MonDisque(double r, double vitesse, double masse, String couleur) {
		super(r, vitesse, masse);
		this.couleur = couleur;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + ", Couleur : " + getCouleur();
	}
	
}

