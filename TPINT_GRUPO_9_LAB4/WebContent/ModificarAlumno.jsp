<%@page import="java.util.List" %>
<%@page import="Entidades.Nacionalidad" %>
<%@page import="Entidades.Provincia" %>
<%@page import="Entidades.Alumno" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumnos</title>
</head>
<body>

<center>
<form name="modificarAlumno" action="servletInternoAlumnos" method="get" style="border: 1px solid #000000; width: 350px; border-radius: 15px; margin-top: 20px; box-shadow: 0px 0px 10px 0px #000000; padding: 15px; background-color: #A1EE9F" >
	
	<h1><b>Modificar Alumno</b></h1>
	<h5 align="left" style="padding-left: 63px; margin-bottom: -5px;">Legajo / DNI:</h5>
	<input type="text" name="txtFiltro">
	<input type="submit" name="btnBuscar" value="Buscar" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
	
	<%
	if(request.getAttribute("mensajeModificarAlumno")=="Se encontró un alumno.")
	{
		Alumno alumno = new Alumno();
		
		alumno = (Alumno) session.getAttribute("AlumnoEncontrado");
	%>
		<input type="text" name="txtId" style="visibility: hidden;" value="<%=alumno.getID() %>">
		<table>
			<tr>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Legajo:</h5>
					<input type="text" name="txtLegajo" value="<%=alumno.getLegajo()%>">
				</td>	
				<td align="center">
					<h5 style="margin-bottom: 2px;">DNI:</h5>
					<input type="text" name="txtDni" value="<%=alumno.getDNI()%>">
				</td>		
			</tr>
			<tr>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Nombres:</h5>
					<input type="text" name="txtNombre" value="<%=alumno.getNombre()%>">
				</td>	
				<td align="center">
					<h5 style="margin-bottom: 2px;">Apellidos:</h5>
					<input type="text" name="txtApellido" value="<%=alumno.getApellido()%>">
				</td>		
			</tr>
			<tr>
				<td align="center">
					<h5 style="margin-bottom: 2px; font-size: 13px; font-weight: 600;">Nacimiento (dd/mm/aaaa):</h5>
					
					<input type="text" name="txtDiaNacimiento" maxlength="2" style="width: 20px;" value="<%=alumno.getDiaNac()%>">
					&nbsp;&nbsp;/&nbsp;&nbsp;
					<input type="text" name="txtMesNacimiento" maxlength="2" style="width: 20px; " value="<%=alumno.getMesNac()%>">
					&nbsp;&nbsp;/&nbsp;
					<input type="text" name="txtAnioNacimiento" maxlength="4" style="width: 35px; " value="<%=alumno.getAnioNac()%>">
				</td>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Dirección:</h5>
					<input type="text" name="txtDireccion" value="<%=alumno.getDireccion()%>">
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
        							<%if(n.getID()==alumno.getNacionalidad().getID()){%>
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
					<h5 style="margin-bottom: 2px;">Provincia:</h5>
					<select name="selectProvincia" style="width: 144px;" Value="<%=alumno.getProvincia().getID()%>">	
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
	        						<%if(p.getID()==alumno.getProvincia().getID()){%>
	        							<option selected="true" value="<%=p.getID()%>">
	        								<%=p.getDescripcion() %>	
	        							</option>
	        						<%}else{ %>
	        							<option value="<%=p.getID() %>">
	        								<%=p.getDescripcion() %>
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
					<input type="text" name="txtEmail" value="<%=alumno.getEmail()%>">
				</td>
				<td align="center">
					<h5 style="margin-bottom: 2px;">Teléfono:</h5>
					<input type="text" name="txtTelefono" value="<%=alumno.getTelefono()%>">
				</td>
			</tr>
		</table>
		
		<br>
		<input type="submit" name="btnConfirmar" value="Modificar" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
	<%} %>
		<br>
		<br>
			<center>
				<% 
					if(request.getAttribute("mensajeModificarAlumno")!=null){
						if(request.getAttribute("mensajeModificarAlumno")!="Se encontró un alumno.")
						{
						if(request.getAttribute("mensajeModificarAlumno")=="Alumno modificado correctamente.")
						{%>
							<label Style="color: darkgreen; box-shadow: 0px 0px 10px 0px #000000; padding: 4px; background-color: #ffffff; border-radius: 15px;">
								<b><%=request.getAttribute("mensajeModificarAlumno") %></b>
							</label>
						<%} 
						else
						{%>
							<label Style="color: red; box-shadow: 0px 0px 10px 0px #000000; padding: 4px; background-color: #ffffff; border-radius: 15px;">
								<b><%=request.getAttribute("mensajeModificarAlumno") %></b>
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

<script>

/*function disableEnable(){
	var btnFiltro = document.getElementById('btnFiltro'),
		inputText = document.getElementById('txtNombre');

	btnFiltro.addEventListener('click', function (e) {
    e.preventDefault();
   	inputText.removeAttribute("disabled");
});
}*/

window.addEventListener("load", function() {
	  modificarAlumno.txtLegajo.addEventListener("keypress", soloNumeros, false);
	  modificarAlumno.txtDni.addEventListener("keypress", soloNumeros, false);
	  modificarAlumno.txtDiaNacimiento.addEventListener("keypress", soloNumeros, false);
	  modificarAlumno.txtMesNacimiento.addEventListener("keypress", soloNumeros, false);
	  modificarAlumno.txtAnioNacimiento.addEventListener("keypress", soloNumeros, false);
	  modificarAlumno.txtTelefono.addEventListener("keypress", soloNumeros, false);
	  modificarAlumno.txtNombre.addEventListener("keypress", soloLetras, false);
	  modificarAlumno.txtApellido.addEventListener("keypress", soloLetras, false);
	  modificarAlumno.btnBuscar.addEventListener("click", disableEnable, false);
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