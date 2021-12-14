package Servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletInternoCursos")
public class servletInternoCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public servletInternoCursos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnConfirmarAlumnosCurso")!=null)
		{
			String mensaje;
			int estado = 0;
			
			estado = -1;
			//Agregar curso a la DB;
			
			if(estado == 1)
			{
				mensaje = "Curso agregado correctamente.";
				request.setAttribute("mensajeCurso", mensaje);
				
				RequestDispatcher rd = request.getRequestDispatcher("Cursos.jsp");
				rd.forward(request, response);
			}
			if(estado == -1)
			{
				mensaje = "Ya existe un curso de la materia, semestre y año elegido.";
				request.setAttribute("mensajeCurso", mensaje);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("Cursos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnVolverAgregarCurso")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Cursos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnVolver")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Cursos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnListarCursos")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("ListarCursos.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnAgregarAlumnosCurso")!=null)
		{
			String codigoMateria = request.getParameter("selectMateria");
			String semestre = request.getParameter("selectSemestre");
			String anio = request.getParameter("selectAnios");
			String codigoDocente = request.getParameter("selectDocente");
						
			request.getSession().setAttribute("codigoMateriaElegida", codigoMateria);
			request.getSession().setAttribute("codigoSemestreElegido", semestre);
			request.getSession().setAttribute("codigoAnioElegido", anio);
			request.getSession().setAttribute("codigoCodigoDocenteElegido", codigoDocente);
			
			RequestDispatcher rd = request.getRequestDispatcher("AgregarAlumnosCurso.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
