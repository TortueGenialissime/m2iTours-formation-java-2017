<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BDD</title>
</head>
<body>
<%!
void lire(JspWriter out){
	try{
	String myDriver = "org.gjt.mm.mysql.Driver";
	String myUrl = "jdbc:mysql://localhost/formation";
	Class.forName(myDriver);
	Connection co = DriverManager.getConnection(myUrl, "root", "");
	String query = "SELECT * FROM cours";
	
	Statement st = co.createStatement();
	ResultSet rs = st.executeQuery(query);
	
	while(rs.next()){
		out.print(rs.getInt("id") + rs.getString("libelle")+"<br>");
	}
	}
	
	catch(Exception e)
	{
		
	}
}

void remplir (int max )
{
    try
    {
        // Lire la table cours
        // connecter IP de mysql + base
        String myDriver = "org.gjt.mm.mysql.Driver"; // mysql.jar
        String myUrl = "jdbc:mysql://localhost/formation";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "");
       
        Statement st = conn.createStatement();
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

void delete(){
    try
    {
        // Lire la table cours
        // connecter IP de mysql + base
        String myDriver = "org.gjt.mm.mysql.Driver"; // mysql.jar
        String myUrl = "jdbc:mysql://localhost/formation";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "");
       
        Statement st = conn.createStatement();
        String query = String.format("truncate table cours");
        st.execute(query);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}

void update(int id){
    try
    {
        // Lire la table cours
        // connecter IP de mysql + base
        String myDriver = "org.gjt.mm.mysql.Driver"; // mysql.jar
        String myUrl = "jdbc:mysql://localhost/formation";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "");
       
        Statement st = conn.createStatement();
        String query = String.format("update cours set libelle='test' where id=%d", id);
        st.execute(query);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}
%>
<%
update(15);
lire(out);
%>
</body>
</html>