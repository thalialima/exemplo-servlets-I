package br.com.alura.servletGerenciador.acao;

import java.io.IOException;
import java.util.List;

import br.com.alura.servletGerenciador.modelo.BancoDeDados;
import br.com.alura.servletGerenciador.modelo.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//Essa classe não é um servlet
public class ListaEmpresas implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//verificando a sessão do usuario
		HttpSession sessao = request.getSession();
		if(sessao.getAttribute("usuarioLogado") == null) {
			return "redirect:entrada?acao=LoginForm";
		}
		
		System.out.println("Listando empresas cadastradas");
		
		BancoDeDados bd = new BancoDeDados();
		List<Empresa> lista = bd.getEmpresas();

		// joga o atributo na requisição
		request.setAttribute("listaDeEmpresas", lista);
		
		
		return "forward:listaEmpresas.jsp";
	}
}
