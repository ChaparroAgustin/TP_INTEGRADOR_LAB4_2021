package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletCursos")
public class servletCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public servletCursos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAgregar")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("AgregarCurso.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnListar")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("ListarCursos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnVolver")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Menú.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
