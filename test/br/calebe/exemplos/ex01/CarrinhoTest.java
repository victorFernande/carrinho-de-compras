package br.calebe.exemplos.ex01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

	private Carrinho carrinho;

	@Before
	public void criandoCarrinho() {
		carrinho = new Carrinho();
	}

	public void colocandoZeroProduto() throws CarrinhoVazioExpected {
		assertTrue(carrinho.isEmpty());
	}

	@Test
	public void colocandoUmProduto() throws CarrinhoVazioExpected {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		assertEquals(1, car.totalProdutos());
	}

	@Test
	public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		assertEquals(2, car.totalProdutos());
	}

	@Test
	public void identidadeDeProdutos() throws CarrinhoVazioExpected {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		assertEquals(1, car.totalItens());
		assertEquals(2, car.totalProdutos());
	}

}
