package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Alumno;
import Negocio.AlumnoNegocio;

@WebServlet("/servletAlumnos")
public class servletAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public servletAlumnos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAgregar")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("AgregarAlumno.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnModificar")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("ModificarAlumno.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnEliminar")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("BajaAlumno.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnListar")!=null)
		{
			AlumnoNegocio AlumnoN = new AlumnoNegocio();
			ArrayList<Alumno> Lista = AlumnoN.ListarAlumnos();

			request.setAttribute("ListaAlumnos", Lista);

			RequestDispatcher rd = request.getRequestDispatcher("ListarAlumnos.jsp");
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
