<%@page import="Dominio.DocenteDao"%>
<%@page import="Dominio.MateriaDao"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Docente" %>
<%@page import="Entidades.Materia" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cursos</title>
</head>
<body>

<center>
<form action="servletInternoCursos" method="get" style="border: 1px solid #000000; width: 350px; border-radius: 15px; margin-top: 20px; box-shadow: 0px 0px 10px 0px #000000; padding: 15px; background-color: #A1EE9F" >
	
	<h1><b>Agregar Curso</b></h1>
	<h5 style="margin-bottom: 2px;">Materia:</h5>
	<select name="selectMateria" style="width: 144px;">		
						<%
							List<Materia> listaMaterias = null;
							if(request.getAttribute("listaMaterias")!=null)
							{
								listaMaterias = (List<Materia>) request.getAttribute("listaMaterias");
							}
				
	        				for(Materia m:listaMaterias)
	        				{%>
	        					<option value="<%=m.getCodigo() %>">
	        						<%=m.getDescripcion() %>
	        					</option>
	        				<%} 
	       				%>	
	</select>
	
		<table>
			<tr>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Semestre:</h5>
					<select name="selectSemestre" style="width: 144px;">		
						<option value="primerSemestre">Primer semestre</option>
						<option value="segundoSemestre">Segundo semestre</option>		
					</select>
				</td>	
				<td align="center">
					<h5 style="margin-bottom: 2px;">Año:</h5>
					<select name="selectAnios" style="width: 144px;">		
						<%
							List<Integer> listaAnios = null;
							if(request.getAttribute("listaAnios")!=null)
							{
								listaAnios = (List<Integer>) request.getAttribute("listaAnios");
							}
				
	        				for(Integer a:listaAnios)
	        				{%>
	        					<option value="<%=a %>">
	        						<%=a %>
	        					</option>
	        				<%} 
	       				%>		
					</select>
				</td>		
			</tr>		
		</table>
		<h5 style="margin-bottom: 2px;">Docente:</h5>
					<select name="selectDocente" style="width: 144px;">		
						<%
							List<Docente> listaDocentes = null;
							if(request.getAttribute("listaDocentes")!=null)
							{
								listaDocentes = (List<Docente>) request.getAttribute("listaDocentes");
							}
				
	        				for(Docente d:listaDocentes)
	        				{%>
	        					<option value="<%=d.getCodigo() %>">
	        						<%=d.getNombre() %>&nbsp;<%=d.getApellido() %>
	        					</option>
	        				<%} 
	       				%>		
					</select>	
		<br>
		<br>
		<br>
		<input type="submit" name="btnAgregarAlumnosCurso" value="Agregar Alumnos" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
		<br><br><br>
		<input type="submit" name="btnVolver" value="Volver" style="border: 2px solid #797777; background-color: #F3E276; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px; margin-left: 80%;">
	
</form>
</center>
<br>
<label style="margin-left: 38%;">Usuario Logueado: <b><%=session.getAttribute("usuarioLogueado") %></b></label>

</body>
</html>