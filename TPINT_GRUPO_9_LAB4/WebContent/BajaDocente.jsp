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
	
	<h1><b>Baja Docente</b></h1>
	<h5 align="left" style="padding-left: 63px; margin-bottom: -5px;">Ingresar Legajo:</h5>
	<input type="text" name="txtLegajo">
	<input type="submit" name="btnBuscarLegajo" value="Buscar" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
	
	
		<table>
			<tr>
				<td align="center">
					<h5>DNI:</h5>
					<input type="text" name="txtDni" style="background-color: #C1C1C1;">
				</td>	
				<td align="center">
					<h5>Nombre y Apellido:</h5>
					<input type="text" name="txtNomApe" style="background-color: #C1C1C1;">
				</td>		
			</tr>
		</table>	
		<br>
		<br>
		<input type="submit" name="btnBaja" value="Eliminar" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
		<br><br><br>
		<input type="submit" name="btnVolver" value="Volver" style="border: 2px solid #797777; background-color: #F3E276; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px; margin-left: 80%;">


</form>
</center>
<br>
<label style="margin-left: 38%;">Usuario Logueado: <b><%=session.getAttribute("usuarioLogueado") %></b></label>

</body>
</html>