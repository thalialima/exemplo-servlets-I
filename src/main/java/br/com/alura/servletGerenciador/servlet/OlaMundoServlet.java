package br.com.alura.servletGerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ola")//registra a url da classe (mapeamento)
public class OlaMundoServlet extends HttpServlet{ //essa classe é um servlet

	@Override
	// esse método atende a uma requisição HTTP
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		PrintWriter saida = response.getWriter(); //esse objeto devolve caracteres
		
		saida.println("<html>"); //imprimindo no fluxo de resposta para o navegador
		saida.println("<body><h3>Testando o primeiro servlet</h3></body>");
		saida.println("</html>");
		
		System.out.println("O servlet OlaMundo foi chamado!");
		
	}
}
