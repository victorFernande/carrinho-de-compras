package br.calebe.produto;

import br.calebe.produto.Produto;

public class Eletrodomestico extends Produto {

	public Eletrodomestico(String nome, double preco) {
		super(nome, preco);
	}
	
	public boolean equals(Object operando) {
		return operando instanceof Eletrodomestico?equals((Eletrodomestico)operando):false;
	}
	
	public boolean equals(Eletrodomestico operando) {
		return nome.equals(operando.nome) && preco == operando.preco;
	}
}
