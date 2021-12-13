<%@page import="Entidades.Docente" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Docentes</title>
</head>
<body>

<center>
<form action="servletInternoDocentes" method="get" style="border: 1px solid #000000; width: 350px; border-radius: 15px; margin-top: 20px; box-shadow: 0px 0px 10px 0px #000000; padding: 15px; background-color: #A1EE9F" >
	
<%
if(session.getAttribute("usuarioLogueado")==null)
{
	String redirectURL = "http://localhost:8080/Maquina_Virtual/Login.jsp";
	response.sendRedirect(redirectURL);
}
%>
	
	<h1><b>Baja Docente</b></h1>
	<h5 align="left" style="padding-left: 63px; margin-bottom: -5px;">Legajo / DNI:</h5>
	<input type="text" name="txtFiltroBaja">
	<input type="submit" name="btnBuscarBaja" value="Buscar" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
	
	<%
	if(request.getAttribute("mensajeBajaDocente")=="Se encontró un docente.")
	{
		Docente docente = new Docente();
		
		docente = (Docente) session.getAttribute("DocenteEncontradoBaja");
	%>
		<table>
			<tr>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Legajo:</h5>
					<input type="text" name="txtLegajo" value="<%=docente.getLegajo()%>">
				</td>	
				<td align="center">
					<h5 style="margin-bottom: 2px;">DNI:</h5>
					<input type="text" name="txtDni" value="<%=docente.getDni()%>">
				</td>		
			</tr>
			<tr>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Nombres y Apellidos:</h5>
					<input type="text" name="txtNomApe" value="<%=docente.getNombre()+" "+docente.getApellido()%>">
				</td>
			</tr>
		</table>	
		<br>
		<br>
		<input type="submit" name="btnBaja" value="Eliminar" onClick="return confirm('¿Seguro que desea eliminar al docente?');" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
		<br>
		<%} %>
		<br>
		<br>
		
		<center>
				<% 
					if(request.getAttribute("mensajeBajaDocente")!=null){
						if(request.getAttribute("mensajeBajaDocente")!="Se encontró un docente.")
						{
						if(request.getAttribute("mensajeBajaDocente")=="Docente correctamente dado de baja.")
						{%>
							<label Style="color: darkgreen; box-shadow: 0px 0px 10px 0px #000000; padding: 4px; background-color: #ffffff; border-radius: 15px;">
								<b><%=request.getAttribute("mensajeBajaDocente") %></b>
							</label>
						<%} 
						else
						{%>
							<label Style="color: red; box-shadow: 0px 0px 10px 0px #000000; padding: 4px; background-color: #ffffff; border-radius: 15px;">
								<b><%=request.getAttribute("mensajeBajaDocente") %></b>
							</label>
							<br>
						<%}} %>
						
					<%}
				%>
			</center>
		
		<br>
		<input type="submit" name="btnVolver" value="Volver" style="border: 2px solid #797777; background-color: #F3E276; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px; margin-left: 80%;">


</form>
</center>
<br>
<label style="margin-left: 38%;">Usuario Logueado: <b><%=session.getAttribute("usuarioLogueado") %></b></label>

</body>
</html>