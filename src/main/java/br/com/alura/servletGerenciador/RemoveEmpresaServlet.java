package br.com.alura.servletGerenciador;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RemoveEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//retorna o conteúdo do parâmetro em forma de string (sempre)
		String parametroId = request.getParameter("id");
		
		//converte a String em um Integer
		Integer id = Integer.valueOf(parametroId);
		
		System.out.println("Identificador: " + id);
		
		BancoDeDados bd = new BancoDeDados();
		bd.removeEmpresa(id);
		
		//envia uma resposta
		response.sendRedirect("listaEmpresas");
	}
	

}
