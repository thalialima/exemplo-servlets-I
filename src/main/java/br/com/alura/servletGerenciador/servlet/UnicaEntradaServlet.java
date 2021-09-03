package br.com.alura.servletGerenciador.servlet;

import java.io.IOException;

import br.com.alura.servletGerenciador.acao.AlteraEmpresa;
import br.com.alura.servletGerenciador.acao.ListaEmpresas;
import br.com.alura.servletGerenciador.acao.MostraEmpresa;
import br.com.alura.servletGerenciador.acao.NovaEmpresa;
import br.com.alura.servletGerenciador.acao.RemoveEmpresa;
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

		if (parametroDaAcao.equals("ListaEmpresas")) {
		
			ListaEmpresas acao = new ListaEmpresas();
			acao.executa(request, response);
			
		} else if (parametroDaAcao.equals("RemoveEmpresa")) {
		
			RemoveEmpresa acao = new RemoveEmpresa();
			acao.executa(request, response);
			
		} else if (parametroDaAcao.equals("MostraEmpresa")) {
			
			MostraEmpresa acao = new MostraEmpresa();
			acao.executa(request, response);
			
		}else if(parametroDaAcao.equals("AlteraEmpresa")) {
			
			AlteraEmpresa acao = new AlteraEmpresa();
			acao.executa(request, response);
			
		}else if (parametroDaAcao.equals("NovaEmpresa")) {
			
			NovaEmpresa acao = new NovaEmpresa();
			acao.executa(request, response);
		}
	}

}
