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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		//o request representa o objeto que recebe os dados da requisição
		String nomeEmpresa = request.getParameter("nome");//retorna o conteúdo do parâmetro em forma de string (sempre)
		
		Empresa empresa = new Empresa(); //objeto empresa
		empresa.setNome(nomeEmpresa); //encapsulando nome da empresa
		
		BancoDeDados bd = new BancoDeDados();
		bd.adiciona(empresa);
		
		//chama o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		
		//joga o atributo na requisição
		request.setAttribute("nomeDaEmpresa", empresa.getNome());
		
		//envia a requisição para o JSP
		rd.forward(request, response);
		
	
	}

}
