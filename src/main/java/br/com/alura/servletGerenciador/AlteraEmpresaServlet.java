package br.com.alura.servletGerenciador;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlteraEmpresaServlet
 */
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Alterando empresa");

		// o request representa o objeto que recebe os dados da requisição
		String nomeEmpresa = request.getParameter("nome");// retorna o conteúdo do parâmetro em forma de string (sempre)
		String dataEmpresa = request.getParameter("data");
		String idEmpresa = request.getParameter("id");
		Integer id = Integer.valueOf(idEmpresa);

		System.out.println("Id: " + id);
		
		
		//alterar banco de dados
		BancoDeDados bd = new BancoDeDados();
		
		Empresa empresa = bd.buscaEmpresaPeloId(id);
		
		empresa.setNome(nomeEmpresa);
		empresa.setData(dataEmpresa);
		empresa.setId(id);
		
		//redirecionamento para listar os dados para o navegador
		//devolve uma resposta para o navegador p/ redirecionamento (não reenvia o formulário)
		response.sendRedirect("listaEmpresas");
		

	}

}
