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
import Negocio.ValidacionesNegocio;

@WebServlet("/servletInternoDocentes")
public class servletInternoDocentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public servletInternoDocentes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnBuscarBaja")!=null)
		{
			String mensaje;
			
			if(request.getParameter("txtFiltroBaja").length() == 0)
			{
				mensaje = "Filtro de búsqueda vacío.";
				request.setAttribute("mensajeBajaDocente", mensaje);
			}
			else
			{
				int coincidencia = 0;
				DocenteNegocio docenteNeg = new DocenteNegocio();
				String filtroTexto = request.getParameter("txtFiltroBaja");
				
				coincidencia = docenteNeg.Contar(filtroTexto);
				
				if(coincidencia != 1)
				{
					mensaje = "No se econtraron coincidencias exactas.";
					request.setAttribute("mensajeBajaDocente", mensaje);
				}
				else
				{
					Docente docente = new Docente();
					docente = docenteNeg.Buscar(filtroTexto);
					
					mensaje = "Se encontró un docente.";
					request.setAttribute("mensajeBajaDocente", mensaje);
					
					request.getSession().setAttribute("DocenteEncontradoBaja", docente);
				}
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("BajaDocente.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnBaja")!=null)
		{
			String mensaje;
			int bajado = 0;
			
			DocenteNegocio aNeg = new DocenteNegocio();
			Docente docente = new Docente();
			docente = (Docente) request.getSession().getAttribute("DocenteEncontradoBaja");
			
			bajado = aNeg.Baja(docente);
			
			if(bajado == 1)
			{
				mensaje = "Docente correctamente dado de baja.";
				request.setAttribute("mensajeBajaDocente", mensaje);
			}
			else if(bajado == 0)
			{
				mensaje = "No se pudo dar de baja al docente.";
				request.setAttribute("mensajeBajaDocente", mensaje);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("BajaDocente.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnBuscar")!=null)
		{
			String mensaje;
			
			if(request.getParameter("txtFiltro").length() == 0)
			{
				mensaje = "Filtro de búsqueda vacío.";
				request.setAttribute("mensajeModificarDocente", mensaje);
			}
			else
			{
				int coincidencia = 0;
				DocenteNegocio docenteNeg = new DocenteNegocio();
				String filtroTexto = request.getParameter("txtFiltro");
				
				coincidencia = docenteNeg.Contar(filtroTexto);
				
				if(coincidencia != 1)
				{
					mensaje = "No se econtraron coincidencias exactas.";
					request.setAttribute("mensajeModificarDocente", mensaje);
				}
				else
				{
					Docente docente = new Docente();
					docente = docenteNeg.Buscar(filtroTexto);
					
					mensaje = "Se encontró un docente.";
					request.setAttribute("mensajeModificarDocente", mensaje);
					
					request.getSession().setAttribute("DocenteEncontrado", docente);
				}
			}
			
			NacionalidadNegocio nacNeg = new NacionalidadNegocio();
			LocalidadNegocio locNeg = new LocalidadNegocio();
			
			ArrayList<Nacionalidad> ListaNacionalidades = nacNeg.ListarNacionalidades();
			ArrayList<Localidad> ListaLocalidades = locNeg.ListarLocalidades();
			
			request.getSession().setAttribute("ListaNacionalidadesSession", ListaNacionalidades);
			request.getSession().setAttribute("ListaLocalidadesSession", ListaLocalidades);
			
			RequestDispatcher rd = request.getRequestDispatcher("ModificarDocente.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnConfirmar")!=null)
		{
			String mensaje;
			
			if(request.getParameter("txtLegajo").length() == 0
					|| request.getParameter("txtDni").length() == 0
					|| request.getParameter("txtNombre").length() == 0
					|| request.getParameter("txtApellido").length() == 0
					|| request.getParameter("txtDiaNacimiento").length() == 0
					|| request.getParameter("txtMesNacimiento").length() == 0
					|| request.getParameter("txtAnioNacimiento").length() == 0
					|| request.getParameter("txtDireccion").length() == 0
					|| request.getParameter("txtEmail").length() == 0
					|| request.getParameter("txtTelefono").length() == 0)
					{
						mensaje = "Hay campos vacíos.";
						request.setAttribute("mensajeModificarDocente", mensaje);
					}
			else
			{
				Docente docente = new Docente();
				DocenteNegocio dNeg = new DocenteNegocio();
				int confirmacion = 0;
				
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
					
					docente.setID(Integer.parseInt(request.getParameter("txtId")));
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
					
					int cantidadDni = dNeg.ContarModificar(docente.getDni(), docente.getID());
					int cantidadLegajo = dNeg.ContarModificar(docente.getLegajo(), docente.getID());
					
					if(cantidadDni != 0 && cantidadLegajo != 0)
					{
						confirmacion = -3;
					}
					else
					{
						confirmacion = dNeg.Modificar(docente);
					}
				}
				else
				{
					confirmacion = -2;
				}
				
				if(confirmacion == 1)
				{
					mensaje = "Docente modificado correctamente.";
					request.setAttribute("mensajeModificarDocente", mensaje);
				}
				else if(confirmacion == 0)
				{
					mensaje = "Docente no modificado.";
					request.setAttribute("mensajeModificarDocente", mensaje);
				}
				else if(confirmacion == -2)
				{
					mensaje = "Fecha inválida.";
					request.setAttribute("mensajeModificarDocente", mensaje);
				}
				else if(confirmacion == -3)
				{
					mensaje = "El DNI/Legajo ingresado ya existe.";
					request.setAttribute("mensajeModificarDocente", mensaje);
				}
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("ModificarDocente.jsp");
			rd.forward(request, response);
		}
		
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
			
			NacionalidadNegocio nacNeg = new NacionalidadNegocio();
			LocalidadNegocio locNeg = new LocalidadNegocio();
			
			ArrayList<Nacionalidad> ListaNacionalidades = nacNeg.ListarNacionalidades();
			ArrayList<Localidad> ListaLocalidades = locNeg.ListarLocalidades();
			
			request.getSession().setAttribute("ListaNacionalidadesSession", ListaNacionalidades);
			request.getSession().setAttribute("ListaLocalidadesSession", ListaLocalidades);
			
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
