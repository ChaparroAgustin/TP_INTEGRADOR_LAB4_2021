<%@page import="java.util.List" %>
<%@page import="Entidades.Nacionalidad" %>
<%@page import="Entidades.Localidad" %>
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
	
	<h1><b>Modificar Docente</b></h1>
	<h5 align="left" style="padding-left: 63px; margin-bottom: -5px;">Legajo / DNI:</h5>
	<input type="text" name="txtFiltro">
	<input type="submit" name="btnBuscar" value="Buscar" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
	<%
	if(request.getAttribute("mensajeModificarDocente")=="Se encontró un docente.")
	{
		Docente docente = new Docente();
		
		docente = (Docente) session.getAttribute("DocenteEncontrado");
	%>
		<input type="text" name="txtId" style="visibility: hidden;" value="<%=docente.getID() %>">
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
					<h5 style="margin-bottom: 2px;">Nombres:</h5>
					<input type="text" name="txtNombre" value="<%=docente.getNombre()%>">
				</td>	
				<td align="center">
					<h5 style="margin-bottom: 2px;">Apellidos:</h5>
					<input type="text" name="txtApellido" value="<%=docente.getApellido()%>">
				</td>		
			</tr>
			<tr>
				<td align="center">
					<h5 style="margin-bottom: 2px; font-size: 13px; font-weight: 600;">Nacimiento (dd/mm/aaaa):</h5>
					
					<input type="text" name="txtDiaNacimiento" maxlength="2" style="width: 20px;" value="<%=docente.getDiaNac()%>">
					&nbsp;&nbsp;/&nbsp;&nbsp;
					<input type="text" name="txtMesNacimiento" maxlength="2" style="width: 20px; " value="<%=docente.getMesNac()%>">
					&nbsp;&nbsp;/&nbsp;
					<input type="text" name="txtAnioNacimiento" maxlength="4" style="width: 35px; " value="<%=docente.getAnioNac()%>">
				</td>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Dirección:</h5>
					<input type="text" name="txtDireccion" value="<%=docente.getDireccion()%>">
				</td>
			</tr>
			<tr>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Nacionalidad:</h5>
					<select name="selectNacionalidad" style="width: 144px;">		
						<%
							List<Nacionalidad> ListaNacionalidades = null;
							if(session.getAttribute("ListaNacionalidadesSession")!=null)
							{
								ListaNacionalidades = (List<Nacionalidad>) session.getAttribute("ListaNacionalidadesSession");
							}
				
							if(session.getAttribute("ListaNacionalidadesSession")!=null)
							{
	        					for(Nacionalidad n:ListaNacionalidades)
	        					{%>
        							<%if(n.getID()==docente.getNacionalidad().getID()){%>
        								<option selected="true" value="<%=n.getID()%>">
        									<%=n.getDescripcion() %>	
        								</option>
        							<%}else{ %>
        								<option value="<%=n.getID() %>">
        									<%=n.getDescripcion() %>
        								</option>
        							<%} %>
        					<%}
							}
	       				%>		
					</select>
				</td>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Localidad:</h5>
					<select name="selectLocalidad" style="width: 144px;" Value="<%=docente.getLocalidad().getID()%>">	
						<%
							List<Localidad> ListaLocalidades = null;
							if(session.getAttribute("ListaLocalidadesSession")!=null)
							{
								ListaLocalidades = (List<Localidad>) session.getAttribute("ListaLocalidadesSession");
							}
							
							if(session.getAttribute("ListaLocalidadesSession")!=null)
							{
	        					for(Localidad l:ListaLocalidades)
	        					{%>
	        						<%if(l.getID()==docente.getLocalidad().getID()){%>
	        							<option selected="true" value="<%=l.getID()%>">
	        								<%=l.getDescripcion() %>	
	        							</option>
	        						<%}else{ %>
	        							<option value="<%=l.getID() %>">
	        								<%=l.getDescripcion() %>
	        							</option>
	        						<%} %>
	        					<%}
							}
	       				%>					
					</select>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Email:</h5>
					<input type="text" name="txtEmail" value="<%=docente.getEmail()%>">
				</td>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Teléfono:</h5>
					<input type="text" name="txtTelefono" value="<%=docente.getTelefono()%>">
				</td>
			</tr>
		</table>
		
		<br>
		<input type="submit" name="btnConfirmar" value="Modificar" onClick="return confirm('¿Seguro que desea modificar al docente?');" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
	<%} %>	
		<br>
		<br>
		<center>
				<% 
					if(request.getAttribute("mensajeModificarDocente")!=null){
						if(request.getAttribute("mensajeModificarDocente")!="Se encontró un docente.")
						{
						if(request.getAttribute("mensajeModificarDocente")=="Docente modificado correctamente.")
						{%>
							<label Style="color: darkgreen; box-shadow: 0px 0px 10px 0px #000000; padding: 4px; background-color: #ffffff; border-radius: 15px;">
								<b><%=request.getAttribute("mensajeModificarDocente") %></b>
							</label>
						<%} 
						else
						{%>
							<label Style="color: red; box-shadow: 0px 0px 10px 0px #000000; padding: 4px; background-color: #ffffff; border-radius: 15px;">
								<b><%=request.getAttribute("mensajeModificarDocente") %></b>
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