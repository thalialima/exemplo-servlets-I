package br.com.alura.servletGerenciador.modelo;

public class ElementoNaoEncontradoException extends RuntimeException{
	
	public ElementoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

}
