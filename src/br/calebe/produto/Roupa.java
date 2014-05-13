package br.calebe.produto;

import br.calebe.produto.Produto;

public class Roupa extends Produto {

	public Roupa(String nome, double preco) {
		super(nome, preco);
	}
	
	public boolean equals(Roupa operando) {
		return nome.equals(operando.nome) && preco == operando.preco;
	}
}
