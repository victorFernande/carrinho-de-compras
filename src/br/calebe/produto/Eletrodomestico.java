package br.calebe.produto;

import br.calebe.exemplos.ex01.Genero;
import br.calebe.produto.Produto;

public class Eletrodomestico extends Produto {

	public Eletrodomestico(String nome, double preco, Genero genero) {
		super(nome, preco, genero);
	}
	
	public boolean equals(Eletrodomestico operando) {
		return nome.equals(operando.nome) && preco == operando.preco;
	}
}
