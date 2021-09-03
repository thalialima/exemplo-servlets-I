<%@page import="br.com.alura.servletGerenciador.modelo.Empresa"%>

<!DOCTYPE html>
<html lang="pt">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Mukta:wght@200;300;400;500;600;700;800&display=swap"
	rel="stylesheet">
<title>Alterar Cadastro</title>

</head>

<body>
	<!-- Cabe�alho (t�tulo e subt�tulo) -->
	<header>
		<div>
			<h1 id="titulo">Alterar Cadastro</h1>
			<br>
		</div>
	</header>

	<!-- In�cio do formul�rio -->
	<form action="entrada" method="post">
		<!-- define para onde a requisi��o ser� enviada ao submeter o form -->
		<!-- por pad�o o formul�rio envia uma requisi��o GET, mas isso pode ser alterado por meio do "method" -->
		<!-- o m�todo post esconde os par�metros dentro do corpo da requisi��o-->

		<%
		//pega o atributo da requisi��o e armazena em um objeto
		Empresa empresa = (Empresa) request.getAttribute("empresa");
		%>

		<fieldset class="grupo">
			<!-- Campo do nome com legenda "nome"-->
			<div class="campo">
				<label for="nome"><strong>Nome da Empresa:</strong></label> <input
					type="text" name="nome" id="nome" value="<%=empresa.getNome()%>"
					required />
			</div>
			<br>

			<!--  Campo de data com legenda "data"  -->
			<div class="campo">
				<label for="id"><strong>Data de Abertura:</strong></label> <input
					type="text" name="data" id="data" value="<%=empresa.getData()%>"
					required />
			</div>

			<!--  Campo de id com legenda "id"  -->
			<div class="campo">
				<input type="hidden" name="id" id="id" value="<%=empresa.getId()%>"
					required />
				<!--  o tipo hidden deixa a input escondida -->
			</div>

			<!--  Campo de acao com legenda "acao"  -->
			<div class="campo">
				<input type="hidden" name="acao" id="acao" value="AlteraEmpresa"
					required />
				<!--  o tipo hidden deixa a input escondida -->
			</div>

			<br> <input type="submit">

		</fieldset>
	</form>
<body>
</html>