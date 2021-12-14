<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trabajo Integrador</title>
</head>
<body>

<center>
<form action="servletLogin" method="post" style="border: 1px solid #000000; width: 350px; border-radius: 15px; margin-top: 20px; box-shadow: 0px 0px 10px 0px #000000; padding: 15px; background-color: #A1EE9F">

	
		<h3>Usuario:</h3>
			<input type="text" name="txtUsuario">
	<br><br>
		<h3>Contraseña:</h3>
			<input id="password" type="password" name="txtClave">
			<br>
			<input type="checkbox" id="ver" class="ver" onChange="hideOrShowPassword()" style="margin-left: -24%; margin-top: 3px;" />
    		<label class="text" style="font-size: 13px;">Mostrar</label>
	<br><br>
		<input type="submit" name="btnLoguear" value="Ingresar" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;" >
		

</form>	
</center>

<% 
	if(request.getAttribute("mensaje")!=null){ %>
	
		<br><br>
		<%=request.getAttribute("mensaje") %>
	<%}
%>

<script>

function hideOrShowPassword(){
	  var password, check;

	  password=document.getElementById("password");
	  check=document.getElementById("ver");

	  if(check.checked==true)
	  {
	      password.type = "text";
	  }
	  else // Si no está activada
	  {
	      password.type = "password";
	  }
	}

</script>

</body>
</html>