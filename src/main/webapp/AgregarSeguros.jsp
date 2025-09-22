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
	DaoSeguro daoSeguro = new DaoSeguro();
	ArrayList<TypeSeguro> listTypes = null;
	DaoTypeSeguro daotype = new DaoTypeSeguro();

	if (request.getAttribute("listTypes") != null) {
		listTypes = daotype.findAll();
	}
	%>
	<h1>Agregar Seguros</h1>

	<form action="ServletUsuario" method="post">
		<div class="formulario_field">
			<label>Id Seguro:</label> <label><b><%=daoSeguro.nextId()%></b></label>
		</div>
		<div class="formulario_field">
			<label for="description">Descripción:</label> <input type="text"
				name="description" required />
		</div>
		<select name="typeSeguro" id="typeSeguro">
			<option value="-1">-- Seleccionar --</option>
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
				type="number" name="contratringCost" required min="1" />
		</div>
		<div class="formulario_field">
			<label for="maxInsuredCost">Consto Máximo Asegurado:</label> <input
				type="number" name="maxInsuredCost" required min="1" />
		</div>
		<input type="submit" value="Enviar" name="btnSend" />
	</form>
	
	<% if(request.getAttribute("message") != null) { %>
		
		<p><%= request.getAttribute("message").toString()%></p>
	<% } %>
</body>
</html>