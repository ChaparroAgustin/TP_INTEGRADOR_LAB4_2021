package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.scene.layout.region.Margins.Converter;

import Entidades.Alumno;
import Entidades.Nacionalidad;
import Entidades.Provincia;
import Negocio.AlumnoNegocio;

@WebServlet("/servletAgregarAlumno")
public class servletAgregarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public servletAgregarAlumno() {
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
					|| request.getParameter("txtNacimiento").toString().length()==0
					|| request.getParameter("txtDireccion").toString().length()==0
					|| request.getParameter("selectNacionalidad").toString().length()==0
					|| request.getParameter("selectProvincia").toString().length()==0
					|| request.getParameter("txtEmail").toString().length()==0
					|| request.getParameter("txtTelefono").toString().length()==0)
			{
				estado = 0;
			}
			
			String mensaje;
			
			Alumno alumno = new Alumno();
			AlumnoNegocio alumnoNeg = new AlumnoNegocio();
			Nacionalidad nac = new Nacionalidad();
			Provincia prov = new Provincia();
			
			alumno.setLegajo(request.getParameter("txtLegajo"));
			alumno.setDNI(request.getParameter("txtDni"));
			alumno.setNombre(request.getParameter("txtNombre"));
			alumno.setApellido(request.getParameter("txtApellido"));
			alumno.setFechaNac(request.getParameter("txtNacimiento"));
			alumno.setDireccion(request.getParameter("txtDireccion"));
			nac.setDescripcion(request.getParameter("selectNacionalidad"));
			alumno.setNacionalidad(nac);
			prov.setDescripcion(request.getParameter("selectProvincia"));
			alumno.setProvincia(prov);
			alumno.setEmail(request.getParameter("txtEmail"));
			alumno.setTelefono(request.getParameter("txtTelefono"));
			
			estado = alumnoNeg.AgregarAlumno(alumno);
			
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
				mensaje = "Error en la base de datos. Reintente más tarde.";
				request.setAttribute("mensajeAgregarAlumno", mensaje);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("AgregarAlumno.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
