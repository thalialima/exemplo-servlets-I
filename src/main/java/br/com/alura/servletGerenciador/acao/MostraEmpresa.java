package br.com.alura.servletGerenciador.acao;

import java.io.IOException;

import br.com.alura.servletGerenciador.modelo.BancoDeDados;
import br.com.alura.servletGerenciador.modelo.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MostraEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Mostrando empresa");
		
		// pega o id da requisição
		String parametroId = request.getParameter("id");

		//converte a String em um Integer
		Integer id = Integer.valueOf(parametroId);
		
		//acessando banco de dados
		BancoDeDados bd = new BancoDeDados();
		
		Empresa empresa = bd.buscaEmpresaPeloId(id);
		
		System.out.println("Nome da empresa: " + empresa.getNome());
		
		//joga o atributo na requisição
		request.setAttribute("empresa", empresa);
		
		return "forward:formAlteraEmpresa.jsp";
	}
}
