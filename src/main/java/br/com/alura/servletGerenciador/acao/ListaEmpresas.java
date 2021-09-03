package br.com.alura.servletGerenciador.acao;

import java.io.IOException;
import java.util.List;

import br.com.alura.servletGerenciador.modelo.BancoDeDados;
import br.com.alura.servletGerenciador.modelo.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Essa classe não é um servlet
public class ListaEmpresas {

	public void executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("Listando empresas cadastradas");
		
		BancoDeDados bd = new BancoDeDados();
		List<Empresa> lista = bd.getEmpresas();

		// joga o atributo na requisição
		request.setAttribute("listaDeEmpresas", lista);
		
		// chama o JSP
		//o getRequestDispacher() retorna um objeto que serve como um wrapper para o recurso localizado no caminho passado
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");

		//envia a requisição para o JSP
		rd.forward(request, response);
	}
}
