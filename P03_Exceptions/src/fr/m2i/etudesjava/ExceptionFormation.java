package fr.m2i.etudesjava;

public class ExceptionFormation extends RuntimeException
{
	private int gravite = 0;
	private String[] tbPhones = {"123456789", "23478545485","45456651445", "4841215454"};
	
	/*
	 * Constructeur sans message, juste avec la gravité
	 */
	
	public ExceptionFormation(int gravite)
	{
		this.gravite = gravite;
	}
	
	public ExceptionFormation(int gravite, String message)
	{
		super(message);
		this.gravite = gravite;
	}
	
	public int getGravite()
	{
		return gravite;
	}
	
	@Override
	public String toString()
	{
		String txt = "\n" + getMessage();
		if(gravite >= 5)
		{
			txt += "\nUne intervention urgente est necessaire";
			String telephone;
			switch(gravite)
			{
				case 5:
				case 6:
				case 7:
					telephone = tbPhones[0];
					break;
				case 8:
					telephone = tbPhones[1];
					break;
				default:
					telephone = tbPhones[2];
					break;
			}
			txt += "\n Appeller le numéro : " + telephone;
		}
		else {
			txt = "\nUne anomalie a été constaté mais ce n'est pas grave";
		}
		return txt;
	}
}
