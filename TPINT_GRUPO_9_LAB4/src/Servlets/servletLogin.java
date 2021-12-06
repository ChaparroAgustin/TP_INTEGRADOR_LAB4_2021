package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Localidad;
import Entidades.Nacionalidad;
import Entidades.Provincia;
import Negocio.LocalidadNegocio;
import Negocio.LoginNegocio;
import Negocio.NacionalidadNegocio;
import Negocio.ProvinciaNegocio;

@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public servletLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		//rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnLoguear")!=null)
		{
			LoginNegocio lneg = new LoginNegocio();
			NacionalidadNegocio nacNeg = new NacionalidadNegocio();
			ProvinciaNegocio provNeg = new ProvinciaNegocio();
			LocalidadNegocio locNeg = new LocalidadNegocio();
			
			ArrayList<Nacionalidad> ListaNacionalidades = nacNeg.ListarNacionalidades();
			ArrayList<Provincia> ListaProvincias = provNeg.ListarProvincias();
			ArrayList<Localidad> ListaLocalidades = locNeg.ListarLocalidades();
			
			request.getSession().setAttribute("ListaNacionalidadesSession", ListaNacionalidades);
			request.getSession().setAttribute("ListaProvinciasSession", ListaProvincias);
			request.getSession().setAttribute("ListaLocalidadesSession", ListaLocalidades);
			
			int estado = 0;
			String mensaje = null;
			
			if(request.getParameter("txtUsuario").toString().length()==0
			|| request.getParameter("txtClave").toString().length()==0)
			{
				estado = -1;
			}
			else
			{
				String user = request.getParameter("txtUsuario");
				String pass = request.getParameter("txtClave");
				
				estado = lneg.comprobarLogin(user, pass);
				
				request.getSession().setAttribute("usuarioLogueado", user);
				
				
			}
			
			if(estado == 1)
			{
				RequestDispatcher rd = request.getRequestDispatcher("Men�.jsp");
				rd.forward(request, response);
			}
			else if(estado == -1)
			{
				mensaje = "Faltan completar campos.";
				request.setAttribute("mensaje", mensaje);
			}
			else
			{
				mensaje = "Credenciales inexistentes o inv�lidas.";
				request.setAttribute("mensaje", mensaje);
			}
		}
		
		doGet(request, response);
	}

}
