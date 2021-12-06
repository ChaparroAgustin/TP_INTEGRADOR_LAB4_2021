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

import Entidades.Docente;
import Entidades.Materia;
import Negocio.DocenteNegocio;
import Negocio.MateriaNegocio;

@WebServlet("/servletCursos")
public class servletCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public servletCursos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAgregar")!=null)
		{
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
		if(request.getParameter("btnListar")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("ListarCursos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnVolver")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Men�.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
