package br.calebe.exemplos.ex01;

import java.util.Map;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

	private Carrinho carrinho;

	@Before
	public void criandoCarrinho() {
		carrinho = new Carrinho();
	}

	public void colocandoZeroProdutoTest() throws CarrinhoVazioExpected {
		assertTrue(carrinho.isEmpty());
	}

	@Test
	public void colocandoUmProdutoTest() throws CarrinhoVazioExpected {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		assertEquals(1, car.totalProdutos());
	}

	@Test
	public void colocandoMaisProdutosTest() throws CarrinhoVazioExpected {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		assertEquals(2, car.totalProdutos());
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		assertEquals(3, car.totalProdutos());
		assertEquals(2, car.totalItens());
	}

	
	@Test
	public void identidadeDeProdutosTest() throws CarrinhoVazioExpected {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		assertEquals(1, car.totalItens());
		assertEquals(2, car.totalProdutos());
	}

	@Test
	public void removerProdutoTest() throws CarrinhoVazioExpected, ProdutoInexistenteException {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		car.removeProduto(livro);
		assertEquals(1, car.totalItens());
		assertEquals(1, car.totalProdutos());
	}
	
	@Test
	public void removerItemTest() throws CarrinhoVazioExpected, ProdutoInexistenteException {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		car.removeItem(livro);
		assertEquals(1, car.totalItens());
		assertEquals(1, car.totalProdutos());
	}
	
	@Test
	public void limparCarrinhoTest() throws CarrinhoVazioExpected {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		car.clean();
		assertTrue(car.isEmpty());
	}
	
	@Test
	public void totalValorTest() throws CarrinhoVazioExpected {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		double soma=(livro.getPreco()+livro2.getPreco()+geladeira.getPreco());
		assertEquals(soma, car.totalValor(), 0.0);
	}
	
	@Test
	public void totalProdutosTest() throws CarrinhoVazioExpected {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		assertEquals(3, car.totalProdutos());
	}
	
	@Test
	public void totalItensTest() throws CarrinhoVazioExpected {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		assertEquals(2, car.totalItens());
	}
	
	@Test
	public void totalProdutosItemTest() throws CarrinhoVazioExpected {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		assertEquals(2,car.quantidadeItem(livro2));
	}
	
	@Test
	public void obterListaTest() throws CarrinhoVazioExpected {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		Set<Map.Entry<Produto,Integer>> x = car.gerarConjunto();
		int sz = 0;
		for(Map.Entry<Produto, Integer> e : x)
			sz+=e.getValue();
		assertEquals(sz,car.totalProdutos());
		assertTrue(x.contains(livro));
		assertTrue(x.contains(livro2));
		assertTrue(x.contains(geladeira));
	}
}
