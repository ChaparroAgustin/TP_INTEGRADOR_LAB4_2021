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
import Entidades.Localidad;
import Entidades.Nacionalidad;
import Entidades.Provincia;
import Negocio.AlumnoNegocio;
import Negocio.DocenteNegocio;
import Negocio.LocalidadNegocio;
import Negocio.NacionalidadNegocio;
import Negocio.ProvinciaNegocio;

@WebServlet("/servletDocentes")
public class servletDocentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public servletDocentes() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAgregar")!=null)
		{
			NacionalidadNegocio nacNeg = new NacionalidadNegocio();
			LocalidadNegocio locNeg = new LocalidadNegocio();
			
			ArrayList<Nacionalidad> ListaNacionalidades = nacNeg.ListarNacionalidades();
			ArrayList<Localidad> ListaLocalidades = locNeg.ListarLocalidades();
			
			request.getSession().setAttribute("ListaNacionalidadesSession", ListaNacionalidades);
			request.getSession().setAttribute("ListaLocalidadesSession", ListaLocalidades);
			
			RequestDispatcher rd = request.getRequestDispatcher("AgregarDocente.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnModificar")!=null)
		{
			NacionalidadNegocio nacNeg = new NacionalidadNegocio();
			ProvinciaNegocio provNeg = new ProvinciaNegocio();
			LocalidadNegocio locNeg = new LocalidadNegocio();
			
			ArrayList<Nacionalidad> ListaNacionalidades = nacNeg.ListarNacionalidades();
			ArrayList<Provincia> ListaProvincias = provNeg.ListarProvincias();
			ArrayList<Localidad> ListaLocalidades = locNeg.ListarLocalidades();
			
			request.getSession().setAttribute("ListaNacionalidadesSession", ListaNacionalidades);
			request.getSession().setAttribute("ListaProvinciasSession", ListaProvincias);
			request.getSession().setAttribute("ListaLocalidadesSession", ListaLocalidades);
			
			RequestDispatcher rd = request.getRequestDispatcher("ModificarDocente.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnEliminar")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("BajaDocente.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnListar")!=null)
		{
			DocenteNegocio docenteNeg = new DocenteNegocio();
			ArrayList<Docente> Lista = docenteNeg.listarDocentes();

			request.setAttribute("ListadoDocentes", Lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("ListarDocentes.jsp");
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
