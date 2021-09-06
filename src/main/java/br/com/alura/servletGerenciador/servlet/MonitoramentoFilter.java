package br.com.alura.servletGerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

//um filtro e um servlet são quase a mesma coisa
//todas as requisições que vão p/ o servlet chegam antes no filter
@WebFilter(urlPatterns = "/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Monitoramento Filtro");
		
		// retorna os milissegundos desde 1970
		long antes = System.currentTimeMillis();

		String acao = request.getParameter("acao");

		// executa a ação (parecido com o método forward();)
		// faz com que a requisição não fique parada
		chain.doFilter(request, response);

		// retorna os milissegundos desde 1970
		long depois = System.currentTimeMillis();

		System.out.println("Tempo de execução da ação: " + acao + " -> " + (depois - antes));

	}

}
