package br.com.alura.servletGerenciador.acao;

import java.io.IOException;

import br.com.alura.servletGerenciador.modelo.BancoDeDados;
import br.com.alura.servletGerenciador.modelo.Empresa;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//Classe responsável por chamar o arquivo que contém o formulário de cadastro de novas empresas
public class NovaEmpresaForm {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		return "forward:formNovaEmpresa.html";
	
	}

}
