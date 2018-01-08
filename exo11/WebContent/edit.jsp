<%@page import="java.sql.ResultSet"%>
<%@page import="exo11.Sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="" method="get">
	<input type="submit" name="action" value="lire">
	<input type="submit" name="action" value="modifier">
	<input type="submit" name="action" value="vider">
	<input type="submit" name="action" value="remplir">
	
	<%
	if(request.getParameter("action") != null)
	{
		Sql sq = new Sql();
		String caseParameter = request.getParameter("action");
		switch(caseParameter){
		
		case "lire": 
			sq.lire(out);
			
		case "modifier": 
			sq.update(18);
			
		case "vider": 
			sq.vider();
		case "remplir": 
			sq.remplir(15);
		}
	}
	%>
</form>
</body>
</html>