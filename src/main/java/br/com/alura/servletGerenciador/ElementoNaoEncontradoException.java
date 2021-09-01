package br.com.alura.servletGerenciador;

public class ElementoNaoEncontradoException extends RuntimeException{
	
	public ElementoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

}
