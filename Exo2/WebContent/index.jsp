<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int compteur = 0;
	if(request.getParameter("compteur") != null){
		compteur = Integer.parseInt(request.getParameter("compteur"));
	}
	compteur+=1;
%>
	<form action="index.jsp">
		<input type="text"  name="compteur" value="<%=compteur %>">
		<input type="submit" value="valider">		
	</form>
</body>
</html>