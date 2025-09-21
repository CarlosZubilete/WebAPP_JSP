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
<title>Aplicaciones Web</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="Inicio.jsp">Inicio</a>
			<li />
			<li><a>Agregar Seguros</a>
			<li />
			<li><a href="ServletUsuario?paramhome=1">Listar Seguros</a>
			<li />
			<li />
		</ul>

	</nav>

	<%
	ArrayList<TypeSeguro> listTypes = null;
	DaoTypeSeguro daotype = new DaoTypeSeguro();

	if (request.getAttribute("listTypes") != null) {
		listTypes = daotype.findAll();
	}
	%>
	<h1>Agregar Seguros</h1>

	<form action="ServletUsuario" method="post">
		<div class="formulario_field">
			<label>Id Seguro:</label> <label>FROM DATA BASE</label>
		</div>
		<div class="formulario_field">
			<label for="description">Descripción:</label> <input type="text"
				name="description" />
		</div>

		<select>
			<%
			if (listTypes != null) {
				for (TypeSeguro type : listTypes) {
			%>
			<option value="<%=type.getId()%>">
				<%=type.getDescription()%>
			</option>

			<%
			}
			}
			%>
		</select>
		<div class="formulario_field">
			<label for="contratringCost">Consto contratación:</label> <input
				type="text" name="contratringCost" />
		</div>
		<div class="formulario_field">
			<label for="maxInsuredCost">Consto Máximo Asegurado:</label> <input
				type="text" name="description" />
		</div>
		<input type="submit" value="Enviar" name="btnSend"/>
	</form>
</body>
</html>