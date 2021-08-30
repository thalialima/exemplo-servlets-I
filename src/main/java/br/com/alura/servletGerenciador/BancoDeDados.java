package br.com.alura.servletGerenciador;

import java.util.ArrayList;
import java.util.List;

//classe que simula um banco de dados
public class BancoDeDados {

	//atributo da classe (static)
	private static List<Empresa> lista = new ArrayList<>();
	
	static { //bloco estático
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		
		BancoDeDados.lista.add(empresa1);
		BancoDeDados.lista.add(empresa2);
	}
	
	
	public void adiciona(Empresa empresa) {
		BancoDeDados.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return BancoDeDados.lista;
	}

}
