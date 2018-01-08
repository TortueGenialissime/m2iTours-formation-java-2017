package exo12;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

public class Index extends HttpServlet {

	 public  void doGet(HttpServletRequest request, HttpServletResponse response)
	 {
		 try {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("monument.jsp");
	            System.out.println(request.getParameter("monument"));
				requestDispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}