package br.calebe.exemplos.ex01;

import java.util.Map;
import java.util.Set;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

	public Carrinho car;

	@Before
	public void init() {
		car = new Carrinho();
	}

	@After
	public void cleanUp() {
		car.clean();
	}

	@Test
	public void carrinhoCriadoVazioTest() {
		assertTrue(car.isEmpty());
	}

	@Test
	public void colocandoUmProdutoTest() {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		assertEquals(1, car.totalItens());
	}

	@Test
	public void limparCarrinhoTest() {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		car.clean();
		assertTrue(car.isEmpty());
	}

	@Test
	public void colocandoMaisProdutosTest() {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		assertEquals(2, car.totalItens());
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		assertEquals(3, car.totalItens());
	}

	@Test
	public void identidadeDeProdutosTest() {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		assertEquals(2, car.totalItens());
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2);
		assertEquals(2, car.totalProdutos());
	}

	@Test
	public void adicionarXProdutosTest() throws ProdutoQuantidadeException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro, 5);
		assertEquals(5, car.totalItens());
		assertEquals(1, car.totalProdutos());
	}

	@Test(expected = ProdutoQuantidadeException.class)
	public void adicionarXProdutosQuantidadeExceptionTest() throws ProdutoQuantidadeException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro, -5);
	}

	@Test(expected = ProdutoQuantidadeException.class)
	public void adicionarZeroProdutosQuantidadeExceptionTest() throws ProdutoQuantidadeException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro, 0);
	}

	@Test
	public void totalProdutosTest() throws CarrinhoVazioException, ProdutoQuantidadeException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		Produto livro2 = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro2, 5);
		assertEquals(7, car.totalItens());
	}

	@Test
	public void totalItensTest() throws CarrinhoVazioException, ProdutoQuantidadeException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro, 7);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira, 5);
		assertEquals(2, car.totalProdutos());
	}

	@Test
	public void totalProdutosItemTest() throws CarrinhoVazioException, ProdutoQuantidadeException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro, 10);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira, 7);
		assertEquals(10, car.itens(livro));
	}

	@Test
	public void removerProdutoTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro, 5);
		car.removeProduto(livro);
		assertEquals(1, car.totalProdutos());
		assertEquals(4, car.totalItens());
	}

	@Test(expected = ProdutoInexistenteException.class)
	public void removerProdutoInexistenteExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro, 5);
		Produto blusa = new Produto("Blusa verde", 73.0, Genero.MODA);
		car.removeProduto(blusa);
	}

	@Test(expected = CarrinhoVazioException.class)
	public void removeProdutoDeCarrinhoVazioExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException {
		Produto bala = new Produto("Bala", 0.45, Genero.ALIMENTO);
		car.removeProduto(bala);
	}

	@Test
	public void removerItemTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro, 5);
		car.removeItem(livro);
		assertEquals(0, car.totalProdutos());
		assertEquals(0, car.totalItens());
	}

	@Test(expected = ProdutoInexistenteException.class)
	public void removerItemInexistenteExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException {
		Produto blusa = new Produto("Blusa verde", 73.0, Genero.MODA);
		Produto livro = new Produto("OOP Workbook", 83.5, Genero.LIVRO);
		car.add(livro);
		car.removeProduto(blusa);
	}

	@Test(expected = CarrinhoVazioException.class)
	public void removerItemDeCarrinhoVazioExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException {
		Produto bala = new Produto("Bala", 0.45, Genero.ALIMENTO);
		car.removeProduto(bala);
	}

	@Test
	public void removerXProdutosTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro, 10);
		car.removeXProdutos(livro, 5);
		assertEquals(5, car.totalItens());
	}

	@Test(expected = ProdutoQuantidadeException.class)
	public void removerXProdutosQuantidadeExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro, 2);
		car.removeXProdutos(livro, 99);
	}

	@Test(expected = ProdutoQuantidadeException.class)
	public void removerXProdutosQuantidade2ExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro,5);
		car.removeXProdutos(livro, -1);
	}

	@Test(expected = ProdutoInexistenteException.class)
	public void removerXProdutosInexistenteExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto game = new Produto("Pacman", 35.3, Genero.JOGOS);
		Produto chocolate = new Produto("Chocolate", 1.50, Genero.ALIMENTO);
		car.add(game, 3);
		car.removeXProdutos(chocolate, 3);
	}

	@Test(expected = CarrinhoVazioException.class)
	public void removerXCarrinhoVazioExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.removeXProdutos(livro, 99);
	}

	@Test
	public void totalValorZeroTest() {
		assertEquals(0.0, car.totalValor(), 0.0);
	}

	@Test
	public void totalValorTest() throws ProdutoQuantidadeException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro, 3);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira, 2);
		double somaEsperada = (livro.getPreco() * 3 + geladeira.getPreco() * 2);
		assertEquals(somaEsperada, car.totalValor(), 0.0);
	}

	@Test
	public void obterListaItensTest() throws CarrinhoVazioException, ProdutoQuantidadeException, ProdutoInexistenteException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro, 2);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		Set<Map.Entry<Produto, Integer>> x = car.gerarConjuntoItens();
		int sz = 0;
		for (Map.Entry<Produto, Integer> e : x) {
			sz += e.getValue();
		}
		assertEquals(sz, car.totalItens());
		boolean found = false;
		for (Map.Entry<Produto, Integer> e : x) {
			if (e.getKey().equals(livro)) {
				found = true;
			}
		}
		assertTrue(found);
		found = false;
		car.removeProduto(livro);
		for (Map.Entry<Produto, Integer> e : x) {
			if (e.getKey().equals(livro)) {
				found = true;
			}
		}
		assertTrue(found);
		found = false;
		for (Map.Entry<Produto, Integer> e : x) {
			if (e.getKey().equals(geladeira)) {
				found = true;
			}
		}
		assertTrue(found);
	}

	@Test
	public void obterListaProdutosTest() throws CarrinhoVazioException, ProdutoInexistenteException {
		Produto livro = new Produto("Java em 24 horas", 50.00, Genero.LIVRO);
		car.add(livro);
		Produto geladeira = new Produto("Geladeira", 5000.00, Genero.CASA);
		car.add(geladeira);
		Produto livro2 = new Produto("UML 2.0", 75.00, Genero.LIVRO);
		car.add(livro2);
		Set<Produto> x = car.gerarConjuntoProdutos();
		assertEquals(x.size(), car.totalProdutos());
		assertTrue(x.contains(livro));
		assertTrue(x.contains(geladeira));
		assertTrue(x.contains(livro2));
	}
}
