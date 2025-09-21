<%@ page import="entities.*"%>
<%@ page import="dao.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="Inicio.jsp"> Inicio </a>
			<li />
			<li><a href="ServletUsuario?param=1">Agregar Seguros</a>
			<li />
			<li><a href="">Listar Seguros</a>
			<li />
		</ul>
	</nav>

	<h1>"Tipo de seguro en la base de datos"</h1>

	<%
	ArrayList<Seguro> listSeguro = null;
	if (request.getAttribute("list") != null) {
		DaoSeguro daoSeguro = new DaoSeguro();
		listSeguro = daoSeguro.findAll();
	}
	%>

	<%
	if (listSeguro != null) {
	%>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Descripción seguro</th>
			<th>Descripción Tipo Seguro</th>
			<th>Consto Contratación</th>
			<th>Costo Máximo Asegurado</th>
		</tr>
		<%
		for (Seguro seguro : listSeguro) {
		%>
		<tr>
			<td><%=seguro.getId()%></td>
			<td><%=seguro.getDescription()%></td>
			<td><%=seguro.getTypeSeguro().getDescription()%></td>
			<td><%=seguro.getContractingCost()%></td>
			<td><%=seguro.getInsuranceCost()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>

</body>
</html>