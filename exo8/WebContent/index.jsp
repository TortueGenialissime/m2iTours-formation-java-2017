
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="c" class="Formation.Calcul">
<%

c.setArg1(10);
c.setArg2(20);

int i = c.getSomme();
int j = c.getProduit();
out.println("Somme " +i + "<br>");
out.println("Produit " +j + "<br>");
%>
</jsp:useBean>
</body>
</html>