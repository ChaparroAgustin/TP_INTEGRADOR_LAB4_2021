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
	
<%
if(session.getAttribute("usuarioLogueado")==null)
{
	String redirectURL = "http://localhost:8080/Maquina_Virtual/Login.jsp";
	response.sendRedirect(redirectURL);
}
%>
	
	<h1><b>Agregar Curso</b></h1>
	
	<%--Agregar listado de alumno aquí --%>
	Materia Elegida: <%=session.getAttribute("codigoMateriaElegida") %>
	<br>
	Semestre Elegido: <%=session.getAttribute("codigoSemestreElegido") %>
	<br>
	Año Elegido: <%=session.getAttribute("codigoAnioElegido") %>
	<br>
	Docente Elegido: <%=session.getAttribute("codigoCodigoDocenteElegido") %>
	
	<br><br>
	<input type="submit" name="btnConfirmarAlumnosCurso" value="Confirmar" OnClick="return confirm('¿Confirma agregar el curso?');" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
	<br><br><br>
	<input type="submit" name="btnVolverAgregarCurso" value="Volver" OnClick="return confirm('¿Si cancela ahora, deberá ingresar todos los datos nuevamente, seguro?');" style="border: 2px solid #797777; background-color: #F3E276; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px; margin-left: 80%;">
	
</form>
</center>
<br>
<label style="margin-left: 38%;">Usuario Logueado: <b><%=session.getAttribute("usuarioLogueado") %></b></label>

</body>
</html>