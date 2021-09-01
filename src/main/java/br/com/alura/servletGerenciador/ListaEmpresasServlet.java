package br.com.alura.servletGerenciador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresasServlet
 */

//listaEmpresas
public class ListaEmpresasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;// versão da classe

	// com o método doGet fica especificado que o servidor dá suporte apenas p/ o
	// get
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BancoDeDados bd = new BancoDeDados();
		List<Empresa> lista = bd.getEmpresas();

		// joga o atributo na requisição
		request.setAttribute("listaDeEmpresas", lista);
		
		// chama o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");

		//envia a requisição para o JSP
		rd.forward(request, response);


	}

}
