<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="Entidades.Docente" %>
<%@page import ="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Docentes</title>
</head>
<body>

<center>
<form action="servletInternoDocentes" method="get" style="border: 1px solid #000000; width: 70%; border-radius: 15px; margin-top: 20px; box-shadow: 0px 0px 10px 0px #000000; padding: 15px; background-color: #A1EE9F" >
	
	<h1><b>Listar Docentes</b></h1>
	<h5 style="margin-left: -180px; margin-bottom: -5px;">Filtro:</h5>
	<input type="text" name="txtBuscado">
	<input type="submit" name="btnFiltrar" value="Filtrar" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
	<br><br>
	<%
	ArrayList<Docente> Lista = null;
	if (request.getAttribute("ListadoDocentes")!=null) 
	{
		Lista = (ArrayList<Docente>)request.getAttribute("ListadoDocentes");
	}
		
	%>
	<table border="1">
    <thead>
        <tr>
            <th>Legajo</th>
            <th>DNI</th>
            <th>Nom. y Ape.</th>
            <th>Fec. Nacimiento</th>
            <th>Dirección</th>
            <th>Localidad</th>
            <th>Nacionalidad</th>
            <th>Email</th>
            <th>Teléfono</th>
        </tr>
    </thead>
    <tbody>    	
		<%if(Lista!=null)
    		for(Docente docente : Lista){%>
		<tr>  
		    <td align="center"><%=docente.getLegajo() %></td>
		    <td align="center"><%=docente.getDni() %></td>
		    <td align="center"><%=docente.getNombre() + " " + docente.getApellido()%></td>
		    <td align="center"><%=docente.getFechaNac() %></td>
		    <td align="center"><%=docente.getDireccion() %></td>
		    <td align="center"><%=docente.getLocalidad().getDescripcion() %></td>
		    <td align="center"><%=docente.getNacionalidad().getDescripcion() %></td>
		    <td align="center"><%=docente.getEmail() %></td>
		    <td align="center"><%=docente.getTelefono() %></td>
		</tr>
		<% }%>
    </tbody>
	</table>
		
	<br><br><br>
	<input type="submit" name="btnVolver" value="Volver" style="border: 2px solid #797777; background-color: #F3E276; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px; margin-left: 90%;">

		
</form>
</center>
<br>
<label style="margin-left: 38%;">Usuario Logueado: <b><%=session.getAttribute("usuarioLogueado") %></b></label>

</body>
</html>