package br.calebe.exemplos.ex01;

public abstract class Produto {

	private String nome;
	private double preco;

	public Produto(String nome, double preco, Genero genero) {
		this.nome = nome.toUpperCase();
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	public int hashCode() {
		return nome.hashCode() + Long.valueOf(Double.doubleToLongBits(preco)).hashCode();
	}
}
