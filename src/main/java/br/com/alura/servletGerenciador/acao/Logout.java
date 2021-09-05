package br.com.alura.servletGerenciador.acao;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//associa o cookie ao objeto httpsession
		HttpSession sessao = request.getSession();
		
		//remove o atributo usuário da sessão
		sessao.removeAttribute("usuarioLogado");
		
		//remove o objeto httpsession, e todos os objetos associados, e destroi o cookie
		sessao.invalidate();
		
		return "redirect:entrada?acao=LoginForm";
	}

}
