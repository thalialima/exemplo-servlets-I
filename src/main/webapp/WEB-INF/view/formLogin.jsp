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
<title>Login</title>

</head>

<body>
	<!-- Cabe�alho (t�tulo e subt�tulo) -->
	<header>
		<div>
			<h1 id="titulo">Login</h1>
			<br>
		</div>
	</header>

	<!-- In�cio do formul�rio -->
	<form action="entrada" method="post">
		<!-- define para onde a requisi��o ser� enviada ao submeter o form -->
		<!-- por pad�o o formul�rio envia uma requisi��o GET, mas isso pode ser alterado por meio do "method" -->
		<!-- o m�todo post esconde os par�metros dentro do corpo da requisi��o-->


		<fieldset class="grupo">
			<!-- Campo do login com legenda "login"-->
			<div class="campo">
				<label for="nome"><strong>Login:</strong></label> <input type="text"
					name="login" id="login" required />
			</div>
			<br>

			<!--  Campo de senha com legenda "senha"  -->
			<div class="campo">
				<label for="id"><strong>Senha:</strong></label> <input
					type="password" name="senha" id="senha" required />
				<!--  o tipo password esconde o texto -->
			</div>

			<!--  Campo de acao com legenda "acao"  -->
			<div class="campo">
				<input type="hidden" name="acao" id="acao" value="Login" />
				<!--  o tipo hidden deixa a input escondida -->
			</div>

			<br> <input type="submit">

		</fieldset>
	</form>
<body>
</html>