<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BDD / SGBD</title>
</head>
<body>
<%
	String myDriver = "org.gjt.mm.mysql.Driver";
	String myUrl = "jdbc:mysql://localhost/formation";
	Class.forName(myDriver);
	Connection co = DriverManager.getConnection(myUrl, "root", "");
	String query = "SELECT * FROM cours";
	
	Statement st = co.createStatement();
	ResultSet rs = st.executeQuery(query);
	
	while(rs.next()){
		out.print(rs.getString("libelle")+"<br>");
	}
%>
</body>
</html>