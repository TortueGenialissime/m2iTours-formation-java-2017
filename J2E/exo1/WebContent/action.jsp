<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.io.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
switch(request.getParameter("action")){
case "Ajouter":
	out.print(request.getRealPath("/"));
	String nom = request.getParameter("nom");
	String age = request.getParameter("age");
	FileWriter fw = new FileWriter(request.getRealPath("/") + nom + ".txt");
	fw.write(String.format("%s,%s" , nom, age));
	break;
case "Retirer":
	String name = request.getParameter("nom");
	File f = new File(request.getRealPath("/") + name + ".txt");
	if(f.exists()){
		f.delete();
	}
	break;
	
case "Lister":
	File folder = new File(request.getRealPath("/") );
	for(File file : folder.listFiles())
	{
		if(file.getName().endsWith(".txt")){
	        BufferedReader br = null;
	        try {
	            br = new BufferedReader(new FileReader(file));
	            String line;
	            while ((line = br.readLine()) != null) {
	               out.println(line+"<br>");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (br != null) {
	                    br.close();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
		}
	}
}
%>
</body>
</html>