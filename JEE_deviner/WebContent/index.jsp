<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
* {
margin: 0;
padding: 0;
    font-family: calibri;
    
}
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background: #2c2c2c;
    }
input{
    display: inline-block;
    border: none;
    outline-color: transparent;
    outline-style: none;
    height: 30px;
    background: #fff;
    width: 200px;
    box-sizing: border-box;
    margin-bottom: 10px;
    padding-left: 10px;
}
    
    input[type=submit]
    {
        width: 80px;
        margin-left: 10px;
        display: inline-block;
        background: #444;
        color: white;
        padding-left: 0;
    }
    label {
        display: inline-block;
        color: white;
        width: 80px;
        text-align: left;
    }
    form{
        text-align: right;
    }
    h1{
        color: white;
    }
    .error {
    background: #d9534f;
    margin-bottom: 10px;
    }
    
    .error p {
    color: white;
    text-align:center;
    padding: 10px 0;
    }
 
    
</style>
</head>
<body>
<%
	String message = "";
	int essai = 0;
if(request.getParameter("essai") != null)
{
	 essai = Integer.parseInt(request.getParameter("essai"));
}
else {
	essai = 0;
}	
%>
	<form action="action.jsp" method="GET">
            <h1>DEVINER UN NOMBRE</h1><br>
        <label for="nom">Essai</label>
        <input type="text" name="essai"><br>
        <div class="error">
        <p>Trop petit</p>
        </div>
        <input type="submit"  value="Envoyer">
	</form>
</body>
</html>