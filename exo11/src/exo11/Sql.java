package exo11;

import java.sql.*;

import javax.servlet.jsp.JspWriter;

public class Sql 
{
	Connection conn ;
	String query ;
    Statement st ;
    ResultSet rs;
	public Sql ()		
	{
		try{
			// Lire la table cours
			// connecter IP de mysql + base 
			String myDriver = "org.gjt.mm.mysql.Driver"; 
	      	String myUrl = "jdbc:mysql://localhost/formation";
	      	Class.forName(myDriver);
	      	conn = DriverManager.getConnection(myUrl, "root", "");		
	      	st = conn.createStatement();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void lire (JspWriter out)
	{
		try
		{
			// executer une requete
			String query = "select * from cours";		       
		    rs = st.executeQuery(query);
			
		    // Lire le resultat
			// Affiche le resultat
		    while (rs.next())
	      	{
	        	out.println (rs.getString("libelle") + "<br/>");
	      	}		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void remplir (int max )
	{
		try
		{	      			     
	      	for (int i=0; i<max; i++)
	      	{
				String query = String.format("insert into cours (libelle) values ('Formation%d')", i);
				// executer une requete
			    st.execute(query);
	      	}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void update (int id)
	{
		try
		{
	      			      
			String query = String.format("update cours set libelle = 'obsolette' where id = %d",id);
			// executer une requete
		    st.execute(query);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}	
	public void vider ()
	{
		try
		{	        
			String query = "delete from cours";
			// executer une requete
		    st.execute(query);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}