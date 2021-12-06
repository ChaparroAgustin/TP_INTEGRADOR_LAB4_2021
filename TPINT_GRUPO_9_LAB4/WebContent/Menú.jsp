<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menú Principal</title>
</head>
<body>
	
<center>
<form action="servletMenu" method="get" style="border: 1px solid #000000; width: 350px; border-radius: 15px; margin-top: 20px; box-shadow: 0px 0px 10px 0px #000000; padding: 15px; background-color: #A1EE9F">

	<h1>Menú Principal</h1>
	<br>
	<input type="submit" name="btnAlumnos" value="Alumnos" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
	<br><br>
	<input type="submit" name="btnDocentes" value="Docentes" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
	<br><br>
	<input type="submit" name="btnCursos" value="Cursos" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
	<br><br><br>
	<input type="submit" name="btnCerrarSesion" value="Cerrar sesión" Style="margin-left: 250px; border: 2px solid #000000; background-color: #e11e46; color: #FFFFFF; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 600; font-size: 13px; padding-top: 5px; padding-bottom: 5px; width: 103px;">
</form>
</center>
<br>
<label style="margin-left: 38%;">Usuario Logueado: <b><%=session.getAttribute("usuarioLogueado") %></b></label>
	
</body>
</html>