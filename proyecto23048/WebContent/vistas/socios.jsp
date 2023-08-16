<%@page import="clases.SociosDAO"%>
<%@page import="clases.Socios"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css" integrity="sha512-10/jx2EXwxxWqCLX/hHth/vu2KY3jCF70dCQB8TSgNjbCVAC/8vai53GfMDrO2Emgwccf2pJqxct9ehpzG+MTw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body style="background-color:#D1F2EB;">
<h1 style="text-align: center;">Listado de Alumnos</h1>

<div  class="container" >
		<div class="row" >
				<a class="btn btn-primary col-4 m-4" href="SociosController?accion=nuevo">Agregar Socio</a>
				
				<table class="table table-primary" >
				<thead>
					<th>Id</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>DNI</th>				
					<th>Mail</th>					
					<th class="text-center">Modificar</th>
					<th class="text-center">Eliminar</th>				
				</thead>
				<% 
				List<Socios> resultado=null;
				SociosDAO socio=new SociosDAO();
				resultado=socio.listarSocios();
				
				for(int i=0;i<resultado.size();i++)
				{
					String ruta="SociosController?accion=modificar&id="+resultado.get(i).getId_socio();
					String rutaE="SociosController?accion=eliminar&id="+resultado.get(i).getId_socio();
				
				%>
				<tr>
				<td><%=resultado.get(i).getId_socio()%></td>
				<td><%=resultado.get(i).getNombre()%></td>
				<td><%=resultado.get(i).getApellido()%></td>
				<td><%=resultado.get(i).getDni()%></td>
				<td><%=resultado.get(i).getMail()%></td>
				<td class="text-center"><a href=<%=ruta%>> <i class="fa-solid fa-arrow-right-arrow-left"></i></a></td>
				<td class="text-center"><a href=<%=rutaE%>><i class="fa-solid fa-arrow-down"></i></a></td>
				</tr>
				<%
				}
				%>					
				
				
				
				</table>
		
		
		
		
		</div>
</div>





</body>
</html>