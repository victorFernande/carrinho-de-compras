package br.calebe.produto;

import br.calebe.produto.Produto;

public class Jogos extends Produto {

	public Jogos(String nome, double preco) {
		super(nome, preco);
	}
	
	public boolean equals(Jogos operando) {
		return nome.equals(operando.nome) && preco == operando.preco;
	}
}
