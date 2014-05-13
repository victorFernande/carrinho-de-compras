package br.calebe.produto;

import br.calebe.produto.Produto;

public class Alimento extends Produto {

	public Alimento(String nome, double preco) {
		super(nome, preco);
	}
	
	public boolean equals(Object operando) {
		return operando instanceof Alimento?equals((Alimento)operando):false;
	}
	
	public boolean equals(Alimento operando) {
		return nome.equals(operando.nome) && preco == operando.preco;
	}
}
