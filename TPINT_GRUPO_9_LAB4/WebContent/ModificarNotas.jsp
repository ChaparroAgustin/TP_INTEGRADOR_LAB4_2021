<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.AlumnoPorCurso" %>
<%@page import="java.util.ArrayList" %>
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

<title>Cursos</title>
</head>
<body>

<center>
<form action="servletInternoCursos" method="get" style="border: 1px solid #000000; width: 60%; border-radius: 15px; margin-top: 20px; box-shadow: 0px 0px 10px 0px #000000; padding: 15px; background-color: #A1EE9F" >
	
<%
if(session.getAttribute("usuarioLogueado")==null)
{
	String redirectURL = "http://localhost:8080/Maquina_Virtual/Login.jsp";
	response.sendRedirect(redirectURL);
}
%>
	
	<h1><b>Modificar Notas</b></h1>
	<%--<h5 align="left" style="padding-left: 195px; margin-bottom: -5px;">Filtro:</h5>
	<input type="text" name="txtFiltro">
	<input type="submit" name="btnFiltrar" value="Filtrar" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;">
	--%>
	<br><br>
	
	<%
	ArrayList<AlumnoPorCurso> Lista = null;
	if (session.getAttribute("listadoAlumnosPorCursoID")!=null) 
	{
		Lista = (ArrayList<AlumnoPorCurso>)session.getAttribute("listadoAlumnosPorCursoID");
	%>
	<table id="tablax" border="1" border-color="black">
    <thead>
        <tr style="background-color: #002060; color: #ffffff; text-shadow: #808080 1.5px 1px; padding: 1px;">
            <th>Legajo</th>
            <th>DNI</th>
            <th>Nombre y Apellido</th>
            <th>Nota 1</th>
            <th>Nota 2</th>
            <th>Nota 3</th>
            <th>Nota 4</th>
            <th>Estado</th>
        </tr>
    </thead>
    <tbody>    	
		
    		<%for(AlumnoPorCurso aPc : Lista){%>
    <form action="servletInternoCursos" method="get">
		<tr style="background-color: LightBlue; color: Black;">  
		    <td align="center"><%=aPc.getLegajo()%></td>
		    <td align="center"><%=aPc.getDni()%></td>
		    <td align="center"><%=aPc.getNombre() +" "+ aPc.getApellido()%></td>
		    <td>
		    	<input type="text" name="txtNota1" value="<%=aPc.getNota1() %>">
		    </td>
		    <td>
		    	<input type="text" name="txtNota1" value="<%=aPc.getNota2() %>">
		    </td>
		    <td>
		    	<input type="text" name="txtNota1" value="<%=aPc.getNota3() %>">
		    </td>
		    <td>
		    	<input type="text" name="txtNota1" value="<%=aPc.getNota4() %>">
		    </td>
		    <td>
		    	<select name="selectEstado" style="width: 144px;">
		    		<%if(aPc.getEstado() == 1){%>
        				<option selected="true" value="1">Regular</option>
        			<%}else{ %>
        				<option value="0">Libre</option>
        			<%} %>				
        		</select>
		    </td>
		</tr>
	</form>
		<% }%>
    </tbody>
	</table>
		<% }
		else
		{
		%>
			No hay cursos en el sistema
		<%
		}
		%>
		<br><br>
		<input type="submit" name="btnVolverModificarNotas" value="Volver" style="border: 2px solid #797777; background-color: #F3E276; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px; margin-left: 80%;">
	
		
</form>
</center>
<br>
<label style="margin-left: 27%;">Usuario Logueado: <b><%=session.getAttribute("usuarioLogueado") %></b></label>

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
                    info: "Mostrando del _START_ al _END_ de un total de _TOTAL_ alumnos",
                    infoEmpty: "",
                    infoFiltered: "",
                    infoPostFix: "",
                    loadingRecords: "Cargando...",
                    zeroRecords: "No se encontraron alumnos que coincidan con tu búsqueda",
                    emptyTable: "No hay alumnos disponibles en el sistema.",
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