package br.com.alura.servletGerenciador.acao;

import java.io.IOException;

import br.com.alura.servletGerenciador.modelo.BancoDeDados;
import br.com.alura.servletGerenciador.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// retorna o conteúdo do parâmetro em forma de string (sempre)
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		System.out.println("Login: " + login);

		BancoDeDados bd = new BancoDeDados();

		Usuario usuario = bd.existeUsuario(login, senha);

		if (usuario != null) {
			String mensagem = String.format("O usuário %s está cadastrado", usuario.getLogin());
			System.out.println(mensagem);
			return "redirect:entrada?acao=ListaEmpresas";
		}else {
			return "redirect:entrada?acao=LoginForm";
		}
		
	}

}
