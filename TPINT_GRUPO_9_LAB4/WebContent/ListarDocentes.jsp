<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="UTF-8"%>
<%@page import ="Entidades.Docente" %>
<%@page import ="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">

<style>
		th {
            text-align: center !important;
        }
        .custom-select {
        	position: absolute !important;
            left: 2%;
        }
        body>div {
            box-shadow: 10px 10px 8px #888888;
            border: 2px solid black;
            border-radius: 10px;
        }
    </style>

<title>Docentes</title>
</head>
<body>

<center>
<form action="servletInternoDocentes" method="get" style="border: 1px solid #000000; width: 90%; border-radius: 15px; margin-top: 20px; box-shadow: 0px 0px 10px 0px #000000; padding: 15px; background-color: #A1EE9F" >
	
<%
if(session.getAttribute("usuarioLogueado")==null)
{
	String redirectURL = "http://localhost:8080/Maquina_Virtual/Login.jsp";
	response.sendRedirect(redirectURL);
}
%>
	
	<h1><b>Docentes</b></h1>
	<%--<h5 style="margin-left: -180px; margin-bottom: -5px;">Filtro:</h5>
	<input type="text" name="txtBuscado">
	<input type="submit" name="btnFiltrar" value="Filtrar" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
	--%>
	<br><br>
	<%
	ArrayList<Docente> Lista = null;
	if (request.getAttribute("ListadoDocentes")!=null) 
	{
		Lista = (ArrayList<Docente>)request.getAttribute("ListadoDocentes");
	}
		
	%>
	<table id="tablax" border="1" border-color="black">
    <thead>
        <tr style="background-color: #002060; color: #ffffff; text-shadow: #808080 1.5px 1px; padding: 1px;">
            <th>Legajo</th>
            <th>DNI</th>
            <th>Nombre y Apellido</th>
            <th>Fecha Nacimiento</th>
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
		<tr style="background-color: LightBlue; color: Black;">  
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

<script src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous">
        </script>
    <!-- DATATABLES -->
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js">
    </script>
    <!-- BOOTSTRAP -->
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js">
    </script>
    <script>
        $(document).ready(function () {
            $('#tablax').DataTable({
                language: {
                    processing: "Tratamiento en curso...",
                    search: "Filtrar&nbsp;:",
                    lengthMenu: "_MENU_",
                    info: "Mostrando del _START_ al _END_ de un total de _TOTAL_ docentes",
                    infoEmpty: "",
                    infoFiltered: "",
                    infoPostFix: "",
                    loadingRecords: "Cargando...",
                    zeroRecords: "No se encontraron docentes que coincidan con tu búsqueda",
                    emptyTable: "No hay docentes disponibles en el sistema.",
                    paginate: {
                        first: "Primero",
                        previous: "Anterior",
                        next: "Siguiente",
                        last: "Ultimo"
                    },
                    aria: {
                        sortAscending: ": active para ordenar la columna en orden ascendente",
                        sortDescending: ": active para ordenar la columna en orden descendente"
                    }
                },
                scrollY: 300,
                lengthMenu: [ [5, 10, -1], [5, 10, "All"] ],
            });
        });
    </script>

</body>
</html>