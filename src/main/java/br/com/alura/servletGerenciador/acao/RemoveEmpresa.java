package br.com.alura.servletGerenciador.acao;

import java.io.IOException;

import br.com.alura.servletGerenciador.modelo.BancoDeDados;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoveEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Removendo empresa");
		

		//o .getParameter() retorna o conteúdo do parâmetro em forma de string (sempre)
		String parametroId = request.getParameter("id");
		
		//converte a String em um Integer
		Integer id = Integer.valueOf(parametroId);
		
		System.out.println("Identificador: " + id);
		
		BancoDeDados bd = new BancoDeDados();
		bd.removeEmpresa(id);
		
		//envia uma resposta ao navegador
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
