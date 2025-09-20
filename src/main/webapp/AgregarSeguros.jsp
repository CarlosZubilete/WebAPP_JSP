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
			<li><a href="">Listar Seguros</a>
			<li />
		</ul>

	</nav>
	<h1>Agregar Seguros</h1>

	<form action="" method="get">
		<div class="formulario_field">
			<label>Id Seguro:</label> <label>FROM DATA BASE</label>
		</div>
		<div class="formulario_field">
			<label for="description">Descripción:</label> <input type="text"
				name="description" />
		</div>
		<div class="formulario_field">
			<label for="typeOfInsurance">Tipo de Seguro:</label> <input type="text"
				name="typeOfInsurance" />
		</div>
		<div class="formulario_field">
			<label for="contratringCost">Consto contratación:</label> <input
				type="text" name="contratringCost" />
		</div>
		<div class="formulario_field">
			<label for="maxInsuredCost">Consto Máximo Asegurado:</label> <input
				type="text" name="description" />
		</div>
	</form>
</body>
</html>