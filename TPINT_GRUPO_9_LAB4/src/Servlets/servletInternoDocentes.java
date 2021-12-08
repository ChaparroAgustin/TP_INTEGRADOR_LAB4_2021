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
import Entidades.Docente;
import Negocio.AlumnoNegocio;
import Negocio.DocenteNegocio;

@WebServlet("/servletInternoDocentes")
public class servletInternoDocentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public servletInternoDocentes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnFiltrar")!=null)
		{
			String textoFiltro = request.getParameter("txtBuscado");
			
			DocenteNegocio docenteNeg = new DocenteNegocio();
			ArrayList<Docente> Lista = docenteNeg.listaFiltroDocentes(textoFiltro);

			request.setAttribute("ListadoDocentes", Lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("ListarDocentes.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnVolver")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Docentes.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
