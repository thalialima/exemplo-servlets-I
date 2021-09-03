package br.com.alura.servletGerenciador.acao;

import java.io.IOException;

import br.com.alura.servletGerenciador.modelo.BancoDeDados;
import br.com.alura.servletGerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AlteraEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Alterando empresa pela ação");

		// o request representa o objeto que recebe os dados da requisição
		String nomeEmpresa = request.getParameter("nome");// retorna o conteúdo do parâmetro em forma de string (sempre)
		String dataEmpresa = request.getParameter("data");
		String idEmpresa = request.getParameter("id");
		Integer id = Integer.valueOf(idEmpresa);

		System.out.println("Ação altera empresa Id: " + id);

		// alterar banco de dados
		BancoDeDados bd = new BancoDeDados();

		Empresa empresa = bd.buscaEmpresaPeloId(id);

		empresa.setNome(nomeEmpresa);
		empresa.setData(dataEmpresa);
		empresa.setId(id);
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
