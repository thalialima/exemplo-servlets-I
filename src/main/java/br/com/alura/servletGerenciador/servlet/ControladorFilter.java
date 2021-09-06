package br.com.alura.servletGerenciador.servlet;

import java.io.IOException;

import br.com.alura.servletGerenciador.acao.Acao;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//ultimo filtro na cadeia
//o web.xml ainda não foi configurado para definir a ordem dos filtros
@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Controlador Filtro");

		HttpServletRequest request = (HttpServletRequest) servletRequest;

		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// Lê o parametro que define a ação
		String parametroDaAcao = request.getParameter("acao");

		String nomeDaClasse = "br.com.alura.servletGerenciador.acao." + parametroDaAcao;

		// Variável global
		String nome;

		// Padrão de projeto Reflection
		try {

			// do pacote java.lang
			Class classe = Class.forName(nomeDaClasse); // carrega a classe com o nome da String
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] tipoEEndereco = nome.split(":");

		if (tipoEEndereco[0].equals("forward")) {
			// chama o JSP
			// o getRequestDispacher() retorna um objeto que serve como um wrapper para o
			// recurso localizado no caminho passado
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);

			// envia a requisição para o JSP
			rd.forward(request, response);
		} else if (tipoEEndereco[0].equals("redirect")) {

			// envia uma resposta ao navegador
			response.sendRedirect(tipoEEndereco[1]);
		}

	}

}
