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
			
			RequestDispatcher rd = request.getRequestDispatcher("AgregarAlumno.jsp");
			rd.forward(request, response);
		}
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
