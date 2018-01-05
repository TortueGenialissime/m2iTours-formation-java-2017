
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.lang.Enum" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body{
font-size: 0px;}
button {
border: none;
display: inline-block;
padding: 10px;
background: #2c2c2c;
margin: 0;
color: white;
}
p{
	font-size: 12px;
}
.touche {
background: red;}
</style>
</head>
<body>

<%
boolean isTouched = false;
ArrayList<Integer> touchesSession = (ArrayList<Integer>) new ArrayList();
if(session.getAttribute("boatIsDefined") == null)
{
	int longeurBoat = 3 + (int)(Math.random() * ((5 - 3) + 1));
	int startPos = 0 + (int)(Math.random() * (((20-longeurBoat) - 0) + 1));
	int endPos = startPos+longeurBoat;
	ArrayList<Integer> attacked = new ArrayList<Integer>();
	ArrayList<Integer> touches = new ArrayList<Integer>();
	out.print("<p>Longeur : "+longeurBoat+"</p>");
	out.print("<p>Start : "+startPos+" | End : "+endPos+"</p>");
	session.setAttribute("boatIsDefined", true);
	session.setAttribute("startPos", startPos);
	session.setAttribute("attacked", attacked); 
	session.setAttribute("touches", touches); 
	session.setAttribute("endPos", endPos); 
}

else {
	out.print("<p>Start : "+session.getAttribute("startPos")+" | End : "+session.getAttribute("endPos")+"</p>");
}
if(request.getParameter("attack") != null){
	if(Integer.parseInt(request.getParameter("attack")) >= (int)session.getAttribute("startPos") && Integer.parseInt(request.getParameter("attack")) <= (int)session.getAttribute("endPos")){
		touchesSession = (ArrayList<Integer>)session.getAttribute("touches");
		if(touchesSession.contains(Integer.parseInt(request.getParameter("attack")))){

		}
		else{
			touchesSession = (ArrayList<Integer>)session.getAttribute("touches");
			touchesSession.add(Integer.parseInt(request.getParameter("attack")));
			session.setAttribute("touches", touchesSession);
		}
		out.print("<p>"+touchesSession+"</p>");
	}
	
}
Enumeration em = session.getAttributeNames();
while(em.hasMoreElements()){
	String element = (String)em.nextElement();
	session.removeAttribute(element);
}
%>
<form action="" method="get">
	<%
	for(int i = 1; i <= 20; i++)
	{
	%>
	
	<button class="<% if(touchesSession.contains(i)){out.print("touche");} %>" type="submit" name="attack" value="<%=i%>"><%=i%></button>
	
	<%
	}
	%>
	
	
	</form>
</body>
</html>