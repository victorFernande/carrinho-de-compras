package br.calebe.exemplos.ex01;

public class Produto {

	private String nome;
	private double preco;
	private Genero genero;

	public Produto(String nome, double preco, Genero genero) {
		this.nome = nome.toUpperCase();
		this.preco = preco;
		this.genero = genero;
	}

	public double getPreco() {
		return preco;
	}

	public int hashCode(){
		return nome.hashCode()+Long.valueOf(Double.doubleToLongBits(preco)).hashCode()+genero.hashCode();
	}
	
	public boolean equals(Object obj){
		return equals((Produto)obj);
	}
	
	public boolean equals(Produto obj) {
		return nome.equals(obj.nome) && preco == obj.preco && genero.equals(obj.genero);
	}
}
