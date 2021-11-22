package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletMenu")
public class servletMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public servletMenu() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAlumnos")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Alumnos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnDocentes")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Docentes.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnCursos")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Cursos.jsp");
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
