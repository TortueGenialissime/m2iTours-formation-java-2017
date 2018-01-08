
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
<jsp:setProperty name="c" property="arg1" value="10"/>
<jsp:setProperty name="c" property="arg2" value="20"/>
*Somme = <jsp:getProperty name="c" property="somme"/>
*Somme = <jsp:getProperty name="c" property="produit"/>
</jsp:useBean>
</body>
</html>