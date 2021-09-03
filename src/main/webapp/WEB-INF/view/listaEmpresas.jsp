
<%@page import="br.com.alura.servletGerenciador.modelo.Empresa"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empresas</title>
</head>
<body>

	<header>
		<div>
			<h1 id="titulo">Lista de Empresas Cadastradas</h1>
		</div>
	</header>

	<font size="5"> <!--  Altera o tamanho da fonte  -->
		<ul>
			<%
			//pega o atributo da requisição e armazena em um objeto
			List<Empresa> listaDeEmpresas = (List<Empresa>) request.getAttribute("listaDeEmpresas");
			for (Empresa e : listaDeEmpresas) {
			%>
			<li><%=e.getNome() + ", "%> <%=e.getData()%> 
			<a href="/servletGerenciador/entrada?acao=MostraEmpresa&id=<%=e.getId()%>">editar</a>
			<a href="/servletGerenciador/entrada?acao=RemoveEmpresa&id=<%=e.getId()%>">remove</a></li>
			<br>
			<%
			}
			%>
		</ul>
	</font>

</body>
</html>