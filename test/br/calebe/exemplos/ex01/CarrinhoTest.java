package br.calebe.exemplos.ex01;

import java.util.Map;
import java.util.Set;
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

	public void colocandoZeroProdutoTest() throws CarrinhoVazioException {
		assertTrue(carrinho.isEmpty());
	}

	@Test
	public void colocandoUmProdutoTest() throws CarrinhoVazioException {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		assertEquals(1, car.totalProdutos());
	}

	@Test
	public void colocandoMaisProdutosTest() throws CarrinhoVazioException {
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
	public void identidadeDeProdutosTest() throws CarrinhoVazioException {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		assertEquals(1, car.totalItens());
		assertEquals(2, car.totalProdutos());
	}

	@Test
	public void removerProdutoTest() throws CarrinhoVazioException, ProdutoInexistenteException {
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
	public void removerItemTest() throws CarrinhoVazioException, ProdutoInexistenteException {
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
	public void limparCarrinhoTest() throws CarrinhoVazioException {
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
	public void totalValorTest() throws CarrinhoVazioException {
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
	public void totalProdutosTest() throws CarrinhoVazioException {
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
	public void totalItensTest() throws CarrinhoVazioException {
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
	public void totalProdutosItemTest() throws CarrinhoVazioException {
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
	public void obterListaItensTest() throws CarrinhoVazioException {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		Set<Map.Entry<Produto,Integer>> x = car.gerarConjuntoItens();
		int sz = 0;
		for(Map.Entry<Produto, Integer> e : x)
			sz+=e.getValue();
		assertEquals(sz,car.totalProdutos());
		boolean found = false;
		for(Map.Entry<Produto,Integer> e : x)
			if(e.getKey().equals(livro))
				found = true;
		assertTrue(found);
		found = false;
		for(Map.Entry<Produto,Integer> e : x)
			if(e.getKey().equals(livro2))
				found = true;
		assertTrue(found);
		found = false;
		for(Map.Entry<Produto,Integer> e : x)
			if(e.getKey().equals(geladeira))
				found = true;
		assertTrue(found);
	}
	
	@Test
	public void obterListaProdutosTest() throws CarrinhoVazioException {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		Produto livro2 = new Produto("UML 2.0", 75.00, Genero.LIVRO);
		car.add(livro2);
		Set<Produto> x = car.gerarConjuntoProdutos();
		assertEquals(x.size(),car.totalItens());
		assertTrue(x.contains(livro));
		assertTrue(x.contains(geladeira));
		assertTrue(x.contains(livro2));
	}
	
	@Test
	public void removerXProdutosTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		Produto livro3 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro3);
		Produto livro4 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro4);
		Produto livro5 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro5);
		Produto livro6 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro6);
		Produto livro7 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro7);
		Produto livro8 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro8);
		Produto livro9 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro9);
		assertEquals(9,car.totalProdutos());
		car.removerXProdutos(livro, 5);
		assertEquals(4,car.totalProdutos());
	}
	
	@Test (expected = ProdutoQuantidadeException.class)
	public void removerXProdutosExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Carrinho car = new Carrinho();
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		Produto livro3 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro3);
		Produto livro4 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro4);
		Produto livro5 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro5);
		Produto livro6 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro6);
		Produto livro7 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro7);
		Produto livro8 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro8);
		Produto livro9 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro9);
		car.removerXProdutos(livro, 99);
	}
}
