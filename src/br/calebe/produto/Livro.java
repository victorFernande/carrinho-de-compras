package br.calebe.produto;

import br.calebe.produto.Produto;

public class Livro extends Produto {

	public Livro(String nome, double preco) {
		super(nome, preco);
	}
	
	public boolean equals(Object operando) {
		return operando instanceof Livro?equals((Livro)operando):false;
	}
	
	public boolean equals(Livro operando) {
		return nome.equals(operando.nome) && preco == operando.preco;
	}
}
