<%@ page language="java" contentType="text/html; charset=UTF-8"
   import="java.util.ArrayList, java.util.Enumeration" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
* {
padding: 0;
margin:0;
font-family: calibri;
}
    form{
        display: inline-block;
    }
#grille {
width: 315px;
height: 500px;
font-size: 0;
    float: left;
}
#grilleFom {
display: flex;
width: 250px;
height: 500px;
flex-direction: column;
flex-wrap: wrap;
}

button {
width:25%;
height: 10%;
border: none;
border: 1px solid black;
background: #2c2c2c;
color: white;
}

p, span{
font-size: 12px;
}
    h1{
        padding: 10px 20px;
    }
h2{
font-size: 16px;
color: #333;
font-family: calibri;
}

.nb {
display: inline-block;
height: 40px;
width: 40px;
border-radius: 20px;
background: #ff4444;
text-align: center;
line-height: 40px;
color: white;
    margin-top: 10px;
    margin-right: 5px;
}
#reset {
display: inline-block;
height: 50px;
width: 315px;
border: none;
color: white;
background: #ff4444;
}

.selected {
background: #ff4444;
}
    
    #nbContainer{
        display: inline-block;
        width: 305px;
        min-height: 90px;
        background: #f8f8f8;
        text-align: center;
    }
    
    #nbContainer h2 {
        text-align: left;
        padding-left: 20px;
        padding-top: 5px;
    }
    
    .clear {
        clear: both;
    }
</style>
</head>
<body>
    <h1>Le loto du turfu</h1>
<div id="grille">
<% 

if(session.getAttribute("started") != null)
{
	if(request.getParameter("nb") != null)
	{
		ArrayList<Integer> nbTab = (ArrayList<Integer>)session.getAttribute("nbTab");
		if(nbTab.contains(Integer.parseInt(request.getParameter("nb")))){
			
		}
		else {
			if(nbTab.size() < 6){
				nbTab.add(Integer.parseInt(request.getParameter("nb")));
				session.setAttribute("nbTab", nbTab);	
			}
		}
		
	}
	else {
		
	}	
}
else {
	session.setAttribute("started", true);
	session.setAttribute("nbTab", new ArrayList<Integer>());
}
if(request.getParameter("delete") != null)
{
	Enumeration em = session.getAttributeNames();
	while(em.hasMoreElements()){
		String element = (String)em.nextElement();
		session.removeAttribute(element);
		response.setHeader("Refresh", "0, URL="+request.getContextPath());
	}
}
%>
<form id="grilleFom" action="" method="post">
<%
for(int i = 0; i < 50; i++)
{
    if(i != 0)
    {
%>
<button type="submit" class="<% if(session.getAttribute("nbTab") != null){ 
ArrayList<Integer> nbTab = (ArrayList<Integer>)session.getAttribute("nbTab");
		if(nbTab.contains(i)){
			out.print("selected");
		}
	}
	%>" name="nb" value="<%=i%>"><%=i%></button>
<%
   }
   else {
   out.print("<button></button>");
   }
}
%>
</form>
</div>
        <div id="nbContainer">
<h2>Vos numéros</h1>
<%
if(session.getAttribute("nbTab") != null){
	for(int i : (ArrayList<Integer>)session.getAttribute("nbTab")){
		out.print("<span class=\"nb\">"+i+"</span>");
	}
}
%>
    </div>
    <div class="clear">
    </div>
<form method="post" action="">
	<button id="reset" type="submit" name="delete" value="1">Recommencer</button>
</form>
</body>
</html>