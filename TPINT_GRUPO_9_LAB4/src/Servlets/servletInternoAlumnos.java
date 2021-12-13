package Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Negocio.AlumnoNegocio;
import Negocio.NacionalidadNegocio;
import Negocio.ProvinciaNegocio;
import Negocio.ValidacionesNegocio;
import Entidades.Alumno;
import Entidades.Nacionalidad;
import Entidades.Provincia;

@WebServlet("/servletInternoAlumnos")
public class servletInternoAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public servletInternoAlumnos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnBuscarBaja")!=null)
		{
			String mensaje;
			
			if(request.getParameter("txtFiltroBaja").length() == 0)
			{
				mensaje = "Filtro de búsqueda vacío.";
				request.setAttribute("mensajeBajaAlumno", mensaje);
			}
			else
			{
				int coincidencia = 0;
				AlumnoNegocio alumnoNeg = new AlumnoNegocio();
				String filtroTexto = request.getParameter("txtFiltroBaja");
				
				coincidencia = alumnoNeg.Contar(filtroTexto);
				
				if(coincidencia != 1)
				{
					mensaje = "No se econtraron coincidencias exactas.";
					request.setAttribute("mensajeBajaAlumno", mensaje);
				}
				else
				{
					Alumno alumno = new Alumno();
					alumno = alumnoNeg.Buscar(filtroTexto);
					
					mensaje = "Se encontró un alumno.";
					request.setAttribute("mensajeBajaAlumno", mensaje);
					
					request.getSession().setAttribute("AlumnoEncontradoBaja", alumno);
				}
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("BajaAlumno.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnBaja")!=null)
		{
			String mensaje;
			int bajado = 0;
			
			AlumnoNegocio aNeg = new AlumnoNegocio();
			Alumno alumno = new Alumno();
			alumno = (Alumno) request.getSession().getAttribute("AlumnoEncontradoBaja");
			
			bajado = aNeg.Baja(alumno);
			
			if(bajado == 1)
			{
				mensaje = "Alumno correctamente dado de baja.";
				request.setAttribute("mensajeBajaAlumno", mensaje);
			}
			else if(bajado == 0)
			{
				mensaje = "No se pudo dar de baja el alumno.";
				request.setAttribute("mensajeBajaAlumno", mensaje);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("BajaAlumno.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnBuscar")!=null)
		{
			String mensaje;
			
			if(request.getParameter("txtFiltro").length() == 0)
			{
				mensaje = "Filtro de búsqueda vacío.";
				request.setAttribute("mensajeModificarAlumno", mensaje);
			}
			else
			{
				int coincidencia = 0;
				AlumnoNegocio alumnoNeg = new AlumnoNegocio();
				String filtroTexto = request.getParameter("txtFiltro");
				
				coincidencia = alumnoNeg.Contar(filtroTexto);
				
				if(coincidencia != 1)
				{
					mensaje = "No se econtraron coincidencias exactas.";
					request.setAttribute("mensajeModificarAlumno", mensaje);
				}
				else
				{
					Alumno alumno = new Alumno();
					alumno = alumnoNeg.Buscar(filtroTexto);
					
					mensaje = "Se encontró un alumno.";
					request.setAttribute("mensajeModificarAlumno", mensaje);
					
					request.getSession().setAttribute("AlumnoEncontrado", alumno);
				}
			}
			
			NacionalidadNegocio nacNeg = new NacionalidadNegocio();
			ProvinciaNegocio provNeg = new ProvinciaNegocio();
			
			ArrayList<Nacionalidad> ListaNacionalidades = nacNeg.ListarNacionalidades();
			ArrayList<Provincia> ListaProvincias = provNeg.ListarProvincias();
			
			request.getSession().setAttribute("ListaNacionalidadesSession", ListaNacionalidades);
			request.getSession().setAttribute("ListaProvinciasSession", ListaProvincias);
			
			RequestDispatcher rd = request.getRequestDispatcher("ModificarAlumno.jsp");
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
						request.setAttribute("mensajeModificarAlumno", mensaje);
					}
			else
			{
				Alumno alumno = new Alumno();
				AlumnoNegocio aNeg = new AlumnoNegocio();
				int confirmacion = 0;
				
				Nacionalidad nac = new Nacionalidad();
				Provincia prov = new Provincia();
				int Anio = Integer.parseInt(request.getParameter("txtAnioNacimiento"));
				int Mes = Integer.parseInt(request.getParameter("txtMesNacimiento"));
				int Dia = Integer.parseInt(request.getParameter("txtDiaNacimiento"));
				
				ValidacionesNegocio validar = new ValidacionesNegocio();
				boolean fechaCorrecta = validar.validarFecha(Anio, Mes, Dia);
				
				if (fechaCorrecta == true)
				{
					String FechaNac = Anio + "-" + Mes + "-" + Dia;
					
					alumno.setID(Integer.parseInt(request.getParameter("txtId")));
					alumno.setLegajo(request.getParameter("txtLegajo"));
					alumno.setDNI(request.getParameter("txtDni"));
					alumno.setNombre(request.getParameter("txtNombre"));
					alumno.setApellido(request.getParameter("txtApellido"));
					alumno.setFechaNac(FechaNac);
					alumno.setDireccion(request.getParameter("txtDireccion"));
					nac.setID(Integer.parseInt(request.getParameter("selectNacionalidad")));
					alumno.setNacionalidad(nac);
					prov.setID(Integer.parseInt(request.getParameter("selectProvincia")));
					alumno.setProvincia(prov);
					alumno.setEmail(request.getParameter("txtEmail"));
					alumno.setTelefono(request.getParameter("txtTelefono"));
					
					int cantidadDni = aNeg.ContarModificar(alumno.getDNI(), alumno.getID());
					int cantidadLegajo = aNeg.ContarModificar(alumno.getLegajo(), alumno.getID());
					
					if(cantidadDni != 0 && cantidadLegajo != 0)
					{
						confirmacion = -3;
					}
					else
					{
						confirmacion = aNeg.Modificar(alumno);
					}
				}
				else
				{
					confirmacion = -2;
				}
				
				if(confirmacion == 1)
				{
					mensaje = "Alumno modificado correctamente.";
					request.setAttribute("mensajeModificarAlumno", mensaje);
				}
				else if(confirmacion == 0)
				{
					mensaje = "Alumno no modificado.";
					request.setAttribute("mensajeModificarAlumno", mensaje);
				}
				else if(confirmacion == -2)
				{
					mensaje = "Fecha inválida.";
					request.setAttribute("mensajeModificarAlumno", mensaje);
				}
				else if(confirmacion == -3)
				{
					mensaje = "El DNI/Legajo ingresado ya existe.";
					request.setAttribute("mensajeModificarAlumno", mensaje);
				}
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("ModificarAlumno.jsp");
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
				Alumno alumno = new Alumno();
				AlumnoNegocio alumnoNeg = new AlumnoNegocio();
				Nacionalidad nac = new Nacionalidad();
				Provincia prov = new Provincia();
				int Anio = Integer.parseInt(request.getParameter("txtAnioNacimiento"));
				int Mes = Integer.parseInt(request.getParameter("txtMesNacimiento"));
				int Dia = Integer.parseInt(request.getParameter("txtDiaNacimiento"));
				
				ValidacionesNegocio validar = new ValidacionesNegocio();
				boolean fechaCorrecta = validar.validarFecha(Anio, Mes, Dia);
				
				if (fechaCorrecta == true)
				{
					String FechaNac = Anio + "-" + Mes + "-" + Dia;
				
					alumno.setLegajo(request.getParameter("txtLegajo"));
					alumno.setDNI(request.getParameter("txtDni"));
					alumno.setNombre(request.getParameter("txtNombre"));
					alumno.setApellido(request.getParameter("txtApellido"));
					alumno.setFechaNac(FechaNac);
					alumno.setDireccion(request.getParameter("txtDireccion"));
					nac.setID(Integer.parseInt(request.getParameter("selectNacionalidad")));
					alumno.setNacionalidad(nac);
					prov.setID(Integer.parseInt(request.getParameter("selectProvincia")));
					alumno.setProvincia(prov);
					alumno.setEmail(request.getParameter("txtEmail"));
					alumno.setTelefono(request.getParameter("txtTelefono"));
			
					estado = alumnoNeg.AgregarAlumno(alumno);
				}
				else
				{
					estado = -2;
				}
			}
			
			String mensaje;
			
			if(estado == 1)
			{
				mensaje = "Alumno agregado correctamente.";
				request.setAttribute("mensajeAgregarAlumno", mensaje);
			}
			else if(estado == 0)
			{
				mensaje = "Faltan completar campos.";
				request.setAttribute("mensajeAgregarAlumno", mensaje);
			}
			else if(estado == -1)
			{
				mensaje = "Legajo/DNI existente.";
				request.setAttribute("mensajeAgregarAlumno", mensaje);
			}
			else if(estado == -2)
			{
				mensaje = "Fecha inválida.";
				request.setAttribute("mensajeAgregarAlumno", mensaje);
			}
			
			NacionalidadNegocio nacNeg = new NacionalidadNegocio();
			ProvinciaNegocio provNeg = new ProvinciaNegocio();
			
			ArrayList<Nacionalidad> ListaNacionalidades = nacNeg.ListarNacionalidades();
			ArrayList<Provincia> ListaProvincias = provNeg.ListarProvincias();
			
			request.getSession().setAttribute("ListaNacionalidadesSession", ListaNacionalidades);
			request.getSession().setAttribute("ListaProvinciasSession", ListaProvincias);
			
			RequestDispatcher rd = request.getRequestDispatcher("AgregarAlumno.jsp");
			rd.forward(request, response);
		}
		/*if(request.getParameter("btnFiltrar")!=null)
		{
			String textoFiltro = request.getParameter("txtBuscado");
			
			AlumnoNegocio AlumnoN = new AlumnoNegocio();
			ArrayList<Alumno> Lista = AlumnoN.FiltrarAlumnos(textoFiltro);

			request.setAttribute("ListaAlumnos", Lista);

			RequestDispatcher rd = request.getRequestDispatcher("ListarAlumnos.jsp");
			rd.forward(request, response);
		}*/
		
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
