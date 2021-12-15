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

import Entidades.Alumno;
import Entidades.AlumnoPorCurso;
import Entidades.Curso;
import Entidades.Docente;
import Entidades.Materia;
import Negocio.AlumnoNegocio;
import Negocio.CursoNegocio;
import Negocio.DocenteNegocio;
import Negocio.MateriaNegocio;

@WebServlet("/servletInternoCursos")
public class servletInternoCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public servletInternoCursos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnVolverModificarNotas")!=null)
		{
			CursoNegocio cNeg = new CursoNegocio();
			ArrayList<Curso> Lista = new ArrayList<Curso>();
			Lista = cNeg.Listar();
			request.getSession().setAttribute("listadoCursos", Lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("ListarCursos.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnModificarNotas")!=null)
		{
			if(request.getParameter("IdCurso")!=null)
			{
				int IdCurso = Integer.parseInt(request.getParameter("IdCurso"));
				
				ArrayList<AlumnoPorCurso> ListApC = new ArrayList<AlumnoPorCurso>();
				CursoNegocio cNeg = new CursoNegocio();
				
				ListApC = cNeg.ListarAlumnosPorCurso(IdCurso);
				
				request.getSession().setAttribute("listadoAlumnosPorCursoID", ListApC);
				
				ArrayList<Curso> Lista = new ArrayList<Curso>();
				Lista = cNeg.Listar();
				Curso c = new Curso();
				
				for(Curso curso : Lista)
				{
					if(curso.getID() == IdCurso)
					{
						c.setID(curso.getID());
						c.setMateria(curso.getMateria());
						c.setDocente(curso.getDocente());
						c.setSemestre(curso.getSemestre());
						c.setAnio(curso.getAnio());
					}
				}
				
				request.getSession().setAttribute("CursoSeleccionado", c);
				
				RequestDispatcher rd = request.getRequestDispatcher("ModificarNotas.jsp");
				rd.forward(request, response);
			}
		}
		
		if(request.getParameter("btnConfirmarAlumnosCurso")!=null)
		{
			Curso c = new Curso();
			CursoNegocio cNeg = new CursoNegocio();
			String mensaje;
			int estado = 0;
			int estado2 = 0;
			int cantidad = 0;
			
			String idMateria = (String) request.getSession().getAttribute("codigoMateriaElegida");
			String semestre = (String) request.getSession().getAttribute("codigoSemestreElegido");
			String anio = (String) request.getSession().getAttribute("codigoAnioElegido");
			String idDocente = (String) request.getSession().getAttribute("codigoCodigoDocenteElegido");
			
			c.setIdMateria(Integer.parseInt(idMateria));
			c.setSemestre(Integer.parseInt(semestre));
			c.setAnio(Integer.parseInt(anio));
			c.setIdDocente(Integer.parseInt(idDocente));
			
			//Preguntar si ya existe algún curso con estos datos ( si existe alguno, estado = -1).
			cantidad = cNeg.Contar(c);
			if(cantidad > 0)
			{
				estado = -3;
			}
			else
			{
				//Agregar curso a la DB (si se agrega bien, estado = 1).
				estado = cNeg.Agregar(c);
				if(estado == 1)
				{
					//Si estado = 1, obtener el ID del curso ingresado.
					c.setID(cNeg.BuscarID());
					
					//Agregar alumnos al curso (si se agregan bien, estado2 = 1).
					if (request.getSession().getAttribute("listadoAlumnosCurso")!=null) 
					{
						AlumnoNegocio AlumnoN = new AlumnoNegocio();
						ArrayList<Alumno> Lista = AlumnoN.ListarAlumnos();
					
						for(Alumno a : Lista)
						{
							if(request.getParameter("chk"+a.getID())!=null)
							{
								cNeg.AgregarAlumnosCurso(a.getID(), c.getID());
							}
						}
						estado2 = 1;
					}
					else
					{
						estado2 = -2;
					}
				}
			}
			
			if(estado == 1 && estado2 == 1)
			{
				mensaje = "Curso y alumno/s agregados correctamente.";
				request.setAttribute("mensajeCurso", mensaje);
			}
			else if(estado == -3)
			{
				mensaje = "Ya existe un curso con los datos seleccionados.";
				request.setAttribute("mensajeCurso", mensaje);
			}
			else if(estado == 1 && estado2 == -1)
			{
				mensaje = "Curso agregado. Alumno/s no agregados.";
				request.setAttribute("mensajeCurso", mensaje);
			}
			else if(estado2 == -2)
			{
				mensaje = "No se pudo cargar el listado de alumnos.";
				request.setAttribute("mensajeCurso", mensaje);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("AgregarCurso.jsp");
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
		
		if(request.getParameter("btnAgregarAlumnosCurso")!=null)
		{
			String mensaje;
			String codigoMateria = request.getParameter("selectMateria");
			String semestre = request.getParameter("selectSemestre");
			String anio = request.getParameter("selectAnios");
			String codigoDocente = request.getParameter("selectDocente");
			
			Curso c = new Curso();
			c.setIdMateria(Integer.parseInt(codigoMateria));
			c.setSemestre(Integer.parseInt(semestre));
			c.setAnio(Integer.parseInt(anio));
			c.setIdDocente(Integer.parseInt(codigoDocente));
			
			CursoNegocio cNeg = new CursoNegocio();
			int cantidad = cNeg.Contar(c);
			
			if(cantidad == 0)
			{
				AlumnoNegocio AlumnoN = new AlumnoNegocio();
				ArrayList<Alumno> Lista = AlumnoN.ListarAlumnos();

				request.setAttribute("ListaAlumnosCurso", Lista);
				
				request.getSession().setAttribute("codigoMateriaElegida", codigoMateria);
				request.getSession().setAttribute("codigoSemestreElegido", semestre);
				request.getSession().setAttribute("codigoAnioElegido", anio);
				request.getSession().setAttribute("codigoCodigoDocenteElegido", codigoDocente);
				
				RequestDispatcher rd = request.getRequestDispatcher("AgregarAlumnosCurso.jsp");
				rd.forward(request, response);
			}
			else
			{
				mensaje = "Ya existe un curso con los datos seleccionados.";
				request.setAttribute("mensajeCurso", mensaje);
				
				List<Integer> listaAnios = new ArrayList<Integer>();
				int principio = 2020;
				int fin = LocalDateTime.now().getYear()+5;
				while(principio <= fin)
				{
					listaAnios.add(principio);
					principio++;
				}
				request.setAttribute("listaAnios", listaAnios);
				
				DocenteNegocio dNeg = new DocenteNegocio();
				MateriaNegocio mNeg = new MateriaNegocio();
				
				List<Docente> listaDocentes = dNeg.listarDocentes(); 
				request.setAttribute("listaDocentes", listaDocentes);
				
				List<Materia> listaMaterias = mNeg.listarDocentes();
				request.setAttribute("listaMaterias", listaMaterias);
				
				RequestDispatcher rd = request.getRequestDispatcher("AgregarCurso.jsp");
				rd.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
