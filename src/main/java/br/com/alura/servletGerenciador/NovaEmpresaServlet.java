package br.com.alura.servletGerenciador;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */

public class NovaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; //versão da classe
	//com o método doPost fica especificado que o servidor dá suporte apenas p/ o post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		//o request representa o objeto que recebe os dados da requisição
		String nomeEmpresa = request.getParameter("nome");//retorna o conteúdo do parâmetro em forma de string (sempre)
		String dataEmpresa = request.getParameter("data");
		
		Empresa empresa = new Empresa(); //objeto empresa
		empresa.setNome(nomeEmpresa); //encapsulando nome da empresa
		empresa.setData(dataEmpresa);
		
		BancoDeDados bd = new BancoDeDados();
		bd.adiciona(empresa);
		
		//devolve uma resposta para o navegador p/ redirecionamento (não reenvia o formulário)
		response.sendRedirect("listaEmpresas");
		
//		//chama o JSP
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		
//		//joga o atributo na requisição
//		request.setAttribute("nomeDaEmpresa", empresa.getNome());
//		request.setAttribute("dataDaEmpresa", empresa.getData());
//		
//		//envia a requisição para o JSP
//		rd.forward(request, response);
		
	
	}

}
