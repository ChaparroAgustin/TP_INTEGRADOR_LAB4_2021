<%@page import="Entidades.Provincia"%>
<%@page import="Entidades.Nacionalidad"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumnos</title>
</head>
<body>

<center>
<form name="agregarAlumno" action="servletInternoAlumnos" method="get" style="border: 1px solid #000000; width: 500px; border-radius: 15px; margin-top: 20px; box-shadow: 0px 0px 10px 0px #000000; padding: 15px; background-color: #A1EE9F" >
	
<%
if(session.getAttribute("usuarioLogueado")==null)
{
	String redirectURL = "http://localhost:8080/Maquina_Virtual/Login.jsp";
	response.sendRedirect(redirectURL);
}
%>
	
	<h1><b>Agregar Alumno</b></h1>
	
	
		<table>
			<tr>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Legajo:</h5>
					<input type="text" name="txtLegajo" maxlength="8">
				</td>
				<td align="center">
					<h5 style="margin-bottom: 2px;">DNI:</h5>
					<input type="text" name="txtDni" maxlength="8">
				</td>
			</tr>
			<tr>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Nombres:</h5>
					<input type="text" name="txtNombre" maxlength="50">
				</td>	
				<td align="center">
					<h5 style="margin-bottom: 2px;">Apellidos:</h5>
					<input type="text" name="txtApellido" maxlength="50">
				</td>		
			</tr>
			<tr>
				<td align="center">
					<h5 style="margin-bottom: 2px; font-size: 13px; font-weight: 600;">Nacimiento (dd/mm/aaaa):</h5>
					
					<input type="text" name="txtDiaNacimiento" maxlength="2" style="width: 20px; ">
					&nbsp;&nbsp;/&nbsp;&nbsp;
					<input type="text" name="txtMesNacimiento" maxlength="2" style="width: 20px; ">
					&nbsp;&nbsp;/&nbsp;
					<input type="text" name="txtAnioNacimiento" maxlength="4" style="width: 35px; ">
				</td>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Dirección:</h5>
					<input type="text" name="txtDireccion" maxlength="100">
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
	        						<option value="<%=n.getID() %>">
	        							<%=n.getDescripcion() %>
	        						</option>
	        					<%} 
							}
	       				%>		
					</select>
				</td>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Provincia:</h5>
					<select name="selectProvincia" style="width: 144px;">	
						<%
							List<Provincia> ListaProvincias = null;
							if(session.getAttribute("ListaProvinciasSession")!=null)
							{
								ListaProvincias = (List<Provincia>) session.getAttribute("ListaProvinciasSession");
							}
							
							if(session.getAttribute("ListaProvinciasSession")!=null)
							{
	        					for(Provincia p:ListaProvincias)
	        					{%>
	        						<option value="<%=p.getID() %>">
	        							<%=p.getDescripcion() %>
	        						</option>
	        					<%}
							}
	       				%>					
					</select>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Email:</h5>
					<input type="text" name="txtEmail" maxlength="100">
				</td>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Teléfono:</h5>
					<input type="text" name="txtTelefono" maxlength="10">
				</td>
			</tr>
		</table>
		<br>
			<center>
				<% 
					if(request.getAttribute("mensajeAgregarAlumno")!=null){ 
						if(request.getAttribute("mensajeAgregarAlumno")=="Alumno agregado correctamente.")
						{%>
							<label Style="color: darkgreen; box-shadow: 0px 0px 10px 0px #000000; padding: 4px; background-color: #ffffff; border-radius: 15px;">
								<b><%=request.getAttribute("mensajeAgregarAlumno") %></b>
							</label>
						<%} 
						else
						{%>
							<label Style="color: red; box-shadow: 0px 0px 10px 0px #000000; padding: 4px; background-color: #ffffff; border-radius: 15px;">
								<b><%=request.getAttribute("mensajeAgregarAlumno") %></b>
							</label>
						<%} %>
						
					<%}
				%>
			</center>
		<br>
		<input type="submit" name="btnAlta" value="Agregar" onClick="return confirm('¿Confirma que los datos ingresados son correctos?');" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
		<br><br><br>
		<input type="submit" name="btnVolver" value="Volver" style="border: 2px solid #797777; background-color: #F3E276; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px; margin-left: 80%;">
	
</form>
</center>

<br>
<label style="margin-left: 38%;">Usuario Logueado: <b><%=session.getAttribute("usuarioLogueado") %></b></label>

<script>
window.addEventListener("load", function() {
  agregarAlumno.txtLegajo.addEventListener("keypress", soloNumeros, false);
  agregarAlumno.txtDni.addEventListener("keypress", soloNumeros, false);
  agregarAlumno.txtDiaNacimiento.addEventListener("keypress", soloNumeros, false);
  agregarAlumno.txtMesNacimiento.addEventListener("keypress", soloNumeros, false);
  agregarAlumno.txtAnioNacimiento.addEventListener("keypress", soloNumeros, false);
  agregarAlumno.txtTelefono.addEventListener("keypress", soloNumeros, false);
  agregarAlumno.txtNombre.addEventListener("keypress", soloLetras, false);
  agregarAlumno.txtApellido.addEventListener("keypress", soloLetras, false);
});

function soloNumeros(e){
  var key = window.event ? e.which : e.keyCode;
  if (key < 48 || key > 57) {
    e.preventDefault();
  }
}

function soloLetras(e) {
    var key = window.event ? e.which : e.keyCode;
    if (key >= 48 && key <= 57) 
    {
    	e.preventDefault();
    	return false; 
    }
    return true;
}
</script>
</body>
</html>