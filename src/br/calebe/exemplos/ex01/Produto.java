package br.calebe.exemplos.ex01;

public class Produto {

	private String nome;
	private double preco;
	private String genero;

	public Produto(String nome, double preco) {
		this.nome = nome.toUpperCase();
		this.preco = preco;
		this.genero = genero;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public boolean equals(Object obj) {
		return equals((Produto) obj);
	}

	public boolean equals(Produto obj) {
		return nome.equals(obj.nome) && preco==obj.preco && genero.equals(obj.genero);
	}
}
