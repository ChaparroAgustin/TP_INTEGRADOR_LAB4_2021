package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Negocio.AlumnoNegocio;
import Entidades.Alumno;

@WebServlet("/servletInternoAlumnos")
public class servletInternoAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public servletInternoAlumnos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnFiltrar")!=null)
		{
			String textoFiltro = request.getParameter("txtBuscado");
			
			AlumnoNegocio AlumnoN = new AlumnoNegocio();
			ArrayList<Alumno> Lista = AlumnoN.FiltrarAlumnos(textoFiltro);

			request.setAttribute("ListaAlumnos", Lista);

			RequestDispatcher rd = request.getRequestDispatcher("ListarAlumnos.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnVolver")!=null)
		{
			RequestDispatcher rede = request.getRequestDispatcher("Alumnos.jsp");
			rede.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
