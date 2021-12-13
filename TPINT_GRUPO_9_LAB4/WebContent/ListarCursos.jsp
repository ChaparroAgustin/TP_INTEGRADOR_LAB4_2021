<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cursos</title>
</head>
<body>

<center>
<form action="servletInternoCursos" method="get" style="border: 1px solid #000000; width: 600px; border-radius: 15px; margin-top: 20px; box-shadow: 0px 0px 10px 0px #000000; padding: 15px; background-color: #A1EE9F" >
	
<%
if(session.getAttribute("usuarioLogueado")==null)
{
	String redirectURL = "http://localhost:8080/Maquina_Virtual/Login.jsp";
	response.sendRedirect(redirectURL);
}
%>
	
	<h1><b>Listar Cursos</b></h1>
	<h5 align="left" style="padding-left: 195px; margin-bottom: -5px;">Filtro:</h5>
	<input type="text" name="txtFiltro">
	<input type="submit" name="btnFiltrar" value="Filtrar" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
	<br><br>
	
	<table>
	<tr>
	<th>
	<center>Materia</center>
	<input type="text" name="txtMateria">
	</th>
	<th>
	<center>Docente</center>
	<input type="text" name="txtDocente">
	</th>
	</tr>
	<tr>
	<th>
	<center>Semestre</center>
	<input type="text" name="txtSemestre">
	</th>
	<th>
	<center>Año</center>
	<input type="text" name="txtAnio">
	</th>
	</tr>
	</table>
	
	<p align="center" style="font-size: 25"><b>Alumnos</b><p>
	<table border="1">
    <thead>
        <tr>
            <th>Legajo</th>
            <th>Nom. y Ape.</th>
            <th>Mail</th>
            <th>1er Parcial</th>
            <th>2do Parcial</th>
            <th>1er Recuperatorio</th>
            <th>2do Recuperatorio</th>
            <th>Estado</th>
        </tr>
    </thead>
    <tbody>    	
		<tr>  
		    <td align="center">
		    	Datos
		    </td>
		    <td align="center">
		    	Datos
		    </td>
		    <td align="center">
		    	Datos
		    </td>
		    <td align="center">
		    	<input type="text" name="txtParcialUno" style="width: 50px; ">
		    </td>
		    <td align="center">
		    	<input type="text" name="txtParcialDos" style="width: 50px; ">
		    </td>
		    <td align="center">
		    	<input type="text" name="txtRecuUno" style="width: 50px; ">
		    </td>
		    <td align="center">
		    	<input type="text" name="txtRecuDos" style="width: 50px; ">
		    </td>
		    <td align="center">
		    	<select name="selectEstado" style="width: 70px;">		
					<option value="0">-</option>
					<option value="Regular">Regular</option>
					<option value="Libre">Libre</option>		
				</select>
		    </td>
		</tr>
    </tbody>
	</table>
		
		<br><br>
		<input type="submit" name="btnCambiarNotas" value="Modificar notas" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
		<br><br><br>
		<input type="submit" name="btnVolver" value="Volver" style="border: 2px solid #797777; background-color: #F3E276; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px; margin-left: 80%;">
	
		
</form>
</center>
<br>
<label style="margin-left: 27%;">Usuario Logueado: <b><%=session.getAttribute("usuarioLogueado") %></b></label>

</body>
</html>