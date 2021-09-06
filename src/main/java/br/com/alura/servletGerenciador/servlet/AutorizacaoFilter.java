package br.com.alura.servletGerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AutorizacaoFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Autorização Filtro");

		HttpServletRequest request = (HttpServletRequest) servletRequest;

		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// Lê o parametro que define a ação
		String parametroDaAcao = request.getParameter("acao");

		// verificando a sessão do usuário
		HttpSession sessao = request.getSession();

		// variável auxiliar p entender o código
		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;

		// variável auxiliar
		// páginas protegidas são todas as paginas, exceto Login e LoginForm
		boolean ehUmaAcaoProtegida = !(parametroDaAcao.equals("Login") || parametroDaAcao.equals("LoginForm"));

		// loop infinito
		if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?acao=LoginForm");

			// apenas sai do método
			return;
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
