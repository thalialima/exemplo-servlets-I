package br.com.alura.servletGerenciador.acao;

import java.io.IOException;

import br.com.alura.servletGerenciador.modelo.BancoDeDados;
import br.com.alura.servletGerenciador.modelo.Empresa;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NovaEmpresa {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//pega os dados da requisição
		String parametroNome = request.getParameter("nome");
		String parametroData = request.getParameter("data");
		
		Empresa empresa = new Empresa();
		empresa.setNome(parametroNome);
		empresa.setData(parametroData);
		
		BancoDeDados bd = new BancoDeDados();
		
		bd.adiciona(empresa);
		
		return "redirect:entrada?acao=ListaEmpresas";
	
	}

}
