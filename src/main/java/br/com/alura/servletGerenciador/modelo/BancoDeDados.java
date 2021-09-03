package br.com.alura.servletGerenciador.modelo;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

//classe que simula um banco de dados
public class BancoDeDados {

	// atributos da classe (static)
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;

	static { // bloco estático
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Alura");
		empresa1.setData("01/09/1998");
		empresa1.setId(BancoDeDados.chaveSequencial++);

		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setData("27/12/1977");
		empresa2.setId(BancoDeDados.chaveSequencial++);

		BancoDeDados.lista.add(empresa1);
		BancoDeDados.lista.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setLogin("Thalia");
		u1.setSenha("123");

		Usuario u2 = new Usuario();
		u2.setLogin("Irene");
		u2.setSenha("321");

		BancoDeDados.listaUsuarios.add(u1);
		BancoDeDados.listaUsuarios.add(u2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(BancoDeDados.chaveSequencial++);
		BancoDeDados.lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return BancoDeDados.lista;
	}

	// remove a empresa pelo seu id
	public void removeEmpresa(Integer id) {

		Iterator<Empresa> it = BancoDeDados.lista.iterator();

		while (it.hasNext()) {
			Empresa empresa = it.next();
			if (empresa.getId() == id) {
				it.remove();
				break;
			}
		}
	}

	// busca a empresa pelo seu id
	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		throw new ElementoNaoEncontradoException("A empresa não está na lista");
	}

	// adiciona usuario
	public void adicionaUsuario(Usuario usuario) {
		BancoDeDados.listaUsuarios.add(usuario);
	}

	// verifica se o usuario está cadastrado no baco de dados
	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : BancoDeDados.listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
