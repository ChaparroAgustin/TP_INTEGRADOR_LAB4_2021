package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Docente;
import Entidades.Localidad;
import Entidades.Nacionalidad;
import Negocio.DocenteNegocio;
import Negocio.ValidacionesNegocio;

@WebServlet("/servletInternoDocentes")
public class servletInternoDocentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public servletInternoDocentes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAlta")!=null)
		{
			int estado = 0;
			
			if(request.getParameter("txtLegajo").toString().length()==0
					|| request.getParameter("txtDni").toString().length()==0
					|| request.getParameter("txtNombre").toString().length()==0
					|| request.getParameter("txtApellido").toString().length()==0
					|| request.getParameter("txtDiaNacimiento").toString().length()==0
					|| request.getParameter("txtMesNacimiento").toString().length()==0
					|| request.getParameter("txtAnioNacimiento").toString().length()==0
					|| request.getParameter("txtDireccion").toString().length()==0
					|| request.getParameter("txtEmail").toString().length()==0
					|| request.getParameter("txtTelefono").toString().length()==0)
			{
				estado = 0;
			}
			else
			{
				Docente docente = new Docente();
				DocenteNegocio docenteNeg = new DocenteNegocio();
				Nacionalidad nac = new Nacionalidad();
				Localidad loc = new Localidad();
				int Anio = Integer.parseInt(request.getParameter("txtAnioNacimiento"));
				int Mes = Integer.parseInt(request.getParameter("txtMesNacimiento"));
				int Dia = Integer.parseInt(request.getParameter("txtDiaNacimiento"));
				
				ValidacionesNegocio validar = new ValidacionesNegocio();
				boolean fechaCorrecta = validar.validarFecha(Anio, Mes, Dia);
				
				if (fechaCorrecta == true)
				{
					String FechaNac = Anio + "-" + Mes + "-" + Dia;
				
					docente.setLegajo(request.getParameter("txtLegajo"));
					docente.setDni(request.getParameter("txtDni"));
					docente.setNombre(request.getParameter("txtNombre"));
					docente.setApellido(request.getParameter("txtApellido"));
					docente.setFechaNac(FechaNac);
					docente.setDireccion(request.getParameter("txtDireccion"));
					nac.setID(Integer.parseInt(request.getParameter("selectNacionalidad")));
					docente.setNacionalidad(nac);
					loc.setID(Integer.parseInt(request.getParameter("selectLocalidad")));
					docente.setLocalidad(loc);
					docente.setEmail(request.getParameter("txtEmail"));
					docente.setTelefono(request.getParameter("txtTelefono"));
			
					estado = docenteNeg.AgregarDocente(docente);
				}
				else
				{
					estado = -2;
				}
			}
			
			String mensaje;
			
			if(estado == 1)
			{
				mensaje = "Docente agregado correctamente.";
				request.setAttribute("mensajeAgregarDocente", mensaje);
			}
			else if(estado == 0)
			{
				mensaje = "Faltan completar campos.";
				request.setAttribute("mensajeAgregarDocente", mensaje);
			}
			else if(estado == -1)
			{
				mensaje = "Legajo/DNI existente.";
				request.setAttribute("mensajeAgregarDocente", mensaje);
			}
			else if(estado == -2)
			{
				mensaje = "Fecha inválida.";
				request.setAttribute("mensajeAgregarDocente", mensaje);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("AgregarDocente.jsp");
			rd.forward(request, response);
		}
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
