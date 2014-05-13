package br.calebe.produto;

import br.calebe.produto.Produto;

public class Eletrodomestico extends Produto {

	public Eletrodomestico(String nome, double preco) {
		super(nome, preco);
	}
	
	public boolean equals(Eletrodomestico operando) {
		return nome.equals(operando.nome) && preco == operando.preco;
	}
}
