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
			String user = request.getParameter("txtUsuario");
			String pass = request.getParameter("txtClave");
			
			int estado = 0;
			String mensaje = null;
			
			if(request.getParameter("txtUsuario").toString().length()==0
			|| request.getParameter("txtClave").toString().length()==0)
			{
				estado = -1;
			}
			else
			{
				estado = lneg.comprobarLogin(user, pass);
				
				request.getSession().setAttribute("usuarioLogueado", user);
			}
			
			if(estado == 1)
			{
				RequestDispatcher rd = request.getRequestDispatcher("Menú.jsp");
				rd.forward(request, response);
			}
			else if(estado == -1)
			{
				mensaje = "Faltan completar campos.";
				request.setAttribute("mensaje", mensaje);
				
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			else
			{
				mensaje = "Credenciales inexistentes o inválidas.";
				request.setAttribute("mensaje", mensaje);
				
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		}
		
		doGet(request, response);
	}

}
