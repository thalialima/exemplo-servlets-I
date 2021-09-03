package br.com.alura.servletGerenciador.acao;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Acao {
	//é automaticamente público e abstrato
	String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
