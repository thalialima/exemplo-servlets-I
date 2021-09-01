package br.com.alura.servletGerenciador;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostraEmpresaServlet
 */
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// retorna o conteúdo do parâmetro em forma de string (sempre)
		String parametroId = request.getParameter("id");

		// converte a String em um Integer
		Integer id = Integer.valueOf(parametroId);
		
		BancoDeDados bd = new BancoDeDados();
		
		Empresa empresa = bd.buscaEmpresaPeloId(id);
		
		System.out.println("Nome da empresa: " + empresa.getNome());

		// joga o atributo na requisição
		request.setAttribute("empresa", empresa);
		
		// chama o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		
		//envia a requisição para o JSP
		rd.forward(request, response);
	}

}
