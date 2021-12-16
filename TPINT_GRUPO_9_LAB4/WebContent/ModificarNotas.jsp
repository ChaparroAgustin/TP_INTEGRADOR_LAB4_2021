<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Curso" %>
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
<form action="servletInternoCursos" method="post" style="border: 1px solid #000000; width: 70%; border-radius: 15px; margin-top: 20px; box-shadow: 0px 0px 10px 0px #000000; padding: 15px; background-color: #A1EE9F" >
	
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
	Curso c = null;
	if (session.getAttribute("CursoSeleccionado")!=null) 
	{
		c = (Curso)session.getAttribute("CursoSeleccionado");%>
	
			ID:&nbsp;<%=c.getID()%>
			<br>
		    Materia:&nbsp;<%=c.getMateria()%>
		    <br>
		    Semestre:&nbsp;<%=c.getSemestre()%>
		    <br>
		    A�o:&nbsp;<%=c.getAnio()%>
		    <br>
		    Docente:&nbsp;<%=c.getDocente()%>
		    <br><br><br>
		    
	
	<%}
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
            <th>1er Parcial</th>
            <th>2do Parcial</th>
            <th>1er Recup.</th>
            <th>2do Recup.</th>
            <th>Estado</th>
        </tr>
    </thead>
    <tbody>    	
		
    		<%for(AlumnoPorCurso aPc : Lista){%>
    <form action="servletInternoCursos" method="post">
		<tr style="background-color: LightBlue; color: Black;">  
		    <td align="center"><%=aPc.getLegajo()%></td>
		    <td align="center"><%=aPc.getDni()%></td>
		    <td align="center"><%=aPc.getNombre() +" "+ aPc.getApellido()%></td>
		    <td>
		    	<center>
		    		<input name="txtNota1<%=aPc.getIdAlumno()%>" maxlength="4" 
		    		style="width: 50px; background-color: LightBlue; color: Black;"
		    		value="<%=aPc.getNota1()%>">
		    	</center>
		    </td>
		    <td>
		    	<center>
		    		<input name="txtNota2<%=aPc.getIdAlumno()%>" maxlength="4" 
		    		style="width: 50px; background-color: LightBlue; color: Black;"
		    		value="<%=aPc.getNota2()%>">
		    	</center>
		    </td>
		    <td>
		    	<center>
		    		<input name="txtNota3<%=aPc.getIdAlumno()%>" maxlength="4" 
		    		style="width: 50px; background-color: LightBlue; color: Black;"
		    		value="<%=aPc.getNota3()%>">
		    	</center>
		    </td>
		    <td>
		    	<center>
		    		<input name="txtNota4<%=aPc.getIdAlumno()%>" maxlength="4" 
		    		style="width: 50px; background-color: LightBlue; color: Black;"
		    		value="<%=aPc.getNota4()%>">
		    	</center>
		    </td>
		    <td>
		    	<center>
		    	<select name="selectEstado" style="width: 100px; background-color: LightBlue; color: Black;">
		    		
        				<option <%if(aPc.getEstado() == 0){%>selected="true"<%}%> value="0">Regular</option>
        				<option <%if(aPc.getEstado() == 1){%>selected="true"<%}%> value="1">Libre</option>
        					
        		</select>
        		</center>
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
		<input type="submit" name="btnCambiarNotasMasivo" value="Confirmar notas" style="border: 2px solid #3C67E2; background-color: #20FFD0; box-shadow: 0px 0px 10px 0px #000000; border-radius: 15px; font-weight: 400; font-size: 18px; padding-top: 3px; padding-bottom: 3px;padding-inline: 3px;" >
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
                    zeroRecords: "No se encontraron alumnos que coincidan con tu b�squeda",
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