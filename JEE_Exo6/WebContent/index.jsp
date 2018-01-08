<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! 
int somme(int v, int w){
return v+w;
}
int produit(int v, int w){
return v*w;
}
%>
<%
	int i = somme(10,20);
	int j = produit(10, 20);
	out.println("Somme " +i + "<br>");
	out.println("Produit " +j + "<br>");
%>
</body>
</html>