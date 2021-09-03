package br.com.alura.servletGerenciador.servlet;

import java.io.IOException;

import br.com.alura.servletGerenciador.acao.AlteraEmpresa;
import br.com.alura.servletGerenciador.acao.ListaEmpresas;
import br.com.alura.servletGerenciador.acao.MostraEmpresa;
import br.com.alura.servletGerenciador.acao.NovaEmpresa;
import br.com.alura.servletGerenciador.acao.NovaEmpresaForm;
import br.com.alura.servletGerenciador.acao.RemoveEmpresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Lê o parametro que define a ação
		String parametroDaAcao = request.getParameter("acao");

		// Variável global
		String nome = null;

		if (parametroDaAcao.equals("ListaEmpresas")) {

			ListaEmpresas acao = new ListaEmpresas();
			// recebe o caminho do recurso
			nome = acao.executa(request, response);

		} else if (parametroDaAcao.equals("RemoveEmpresa")) {

			RemoveEmpresa acao = new RemoveEmpresa();
			// recebe o caminho do recurso
			nome = acao.executa(request, response);

		} else if (parametroDaAcao.equals("MostraEmpresa")) {

			MostraEmpresa acao = new MostraEmpresa();
			// recebe o caminho do recurso
			nome = acao.executa(request, response);

		} else if (parametroDaAcao.equals("AlteraEmpresa")) {

			AlteraEmpresa acao = new AlteraEmpresa();
			// recebe o caminho do recurso
			nome = acao.executa(request, response);

		} else if (parametroDaAcao.equals("NovaEmpresa")) {

			NovaEmpresa acao = new NovaEmpresa();
			// recebe o caminho do recurso
			nome = acao.executa(request, response);

		} else if (parametroDaAcao.equals("NovaEmpresaForm")) {

			NovaEmpresaForm acao = new NovaEmpresaForm();
			// recebe o caminho do recurso
			nome = acao.executa(request, response);

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
