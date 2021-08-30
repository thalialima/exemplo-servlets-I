
<%@page import="br.com.alura.servletGerenciador.Empresa"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empresas</title>
</head>
<body>

	<header>
		<div>
			<h2 id="titulo">Lista de Empresas Cadastradas</h2>
			<br>
		</div>
	</header>

	<ul>

		<!-- items são a lista -->
		<c:forEach items="${listaDeEmpresas}" var="empresa">
		
		
		</c:forEach>


	</ul>



	<ul>


		<%
		//pega o atributo da requisição e armazena em uma string
		List<Empresa> listaDeEmpresas = (List<Empresa>) request.getAttribute("listaDeEmpresas");
		for (Empresa e : listaDeEmpresas) {
		%>
		<li><%=e.getNome()%></li>

		<%
		}
		%>
	</ul>

</body>
</html>