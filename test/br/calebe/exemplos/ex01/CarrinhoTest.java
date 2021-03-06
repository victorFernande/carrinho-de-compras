package br.calebe.exemplos.ex01;

import br.calebe.produto.*;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
	public void adicionandoItemTest() {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro);
		assertEquals(1, car.totalItens());
	}

	@Test
	public void limparCarrinhoTest() {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro);
		car.clean();
		assertTrue(car.isEmpty());
	}

	@Test
	public void adicionandoVariosItensTest() {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro);
		Produto geladeira = new Eletrodomestico("Geladeira", 5000.00);
		car.add(geladeira);
		assertEquals(2, car.totalItens());
		Produto livro2 = new Livro("Java em 24 horas", 50.00);
		car.add(livro2);
		assertEquals(3, car.totalItens());
	}

	@Test
	public void quantidadeProdutosTest() {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro);
		Produto geladeira = new Eletrodomestico("Geladeira", 5000.00);
		car.add(geladeira);
		assertEquals(2, car.totalItens());
		Produto livro2 = new Livro("Java em 24 horas", 50.00);
		car.add(livro2);
		assertEquals(2, car.totalProdutos());
	}

	@Test
	public void adicionandoVariosMesmoProdutoTest() throws ProdutoQuantidadeException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro, 5);
		assertEquals(5, car.totalItens());
		assertEquals(1, car.totalProdutos());
	}

	@Test(expected = ProdutoQuantidadeException.class)
	public void adicionandoVariosMesmoProduto_ProdutosQuantidadeExceptionTest() throws ProdutoQuantidadeException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro, -5);
	}

	@Test(expected = ProdutoQuantidadeException.class)
	public void adicionandoZeroProduto_ProdutosQuantidadeExceptionTest() throws ProdutoQuantidadeException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro, 0);
	}

	@Test
	public void obterTotalItemTest() throws CarrinhoVazioException, ProdutoQuantidadeException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro, 10);
		Produto geladeira = new Eletrodomestico("Geladeira", 5000.00);
		car.add(geladeira, 7);
		assertEquals(10, car.totalItens(livro));
	}

	@Test
	public void removerItemTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro, 5);
		car.removeItem(livro);
		assertEquals(1, car.totalProdutos());
		assertEquals(4, car.totalItens());
	}

	@Test(expected = ProdutoInexistenteException.class)
	public void removerItem_ProdutoInexistenteExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro, 5);
		Produto blusa = new Roupa("Blusa verde", 73.0);
		car.removeItem(blusa);
	}

	@Test(expected = CarrinhoVazioException.class)
	public void removeItem_CarrinhoVazioExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException {
		Produto bala = new Alimento("Bala", 0.45);
		car.removeItem(bala);
	}

	@Test
	public void removeProdutoTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro, 5);
		car.removeProduto(livro);
		assertEquals(0, car.totalProdutos());
		assertEquals(0, car.totalItens());
	}

	@Test(expected = ProdutoInexistenteException.class)
	public void removeProduto_ProdutoInexistenteExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException {
		Produto blusa = new Roupa("Blusa verde", 73.0);
		Produto livro = new Livro("OOP Workbook", 83.5);
		car.add(livro);
		car.removeItem(blusa);
	}

	@Test(expected = CarrinhoVazioException.class)
	public void removeProduto_CarrinhoVazioExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException {
		Produto bala = new Alimento("Bala", 0.45);
		car.removeItem(bala);
	}

	@Test
	public void removeVariosMesmoProdutoTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro, 10);
		car.removeProduto(livro, 5);
		assertEquals(5, car.totalItens());
	}

	@Test(expected = ProdutoQuantidadeException.class)
	public void removeVariosMesmoProduto_QuantidadeExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro, 2);
		car.removeProduto(livro, 99);
	}

	@Test(expected = ProdutoQuantidadeException.class)
	public void removeVariosMesmoProduto_ProdutoQuantidade2ExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro, 5);
		car.removeProduto(livro, -1);
	}

	@Test(expected = ProdutoInexistenteException.class)
	public void removeVariosMesmoProduto_ProdutoInexistenteExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto game = new Jogos("Pacman", 35.3);
		Produto chocolate = new Alimento("Chocolate", 1.50);
		car.add(game, 3);
		car.removeProduto(chocolate, 3);
	}

	@Test(expected = CarrinhoVazioException.class)
	public void removeVariosMesmoProduto_CarrinhoVazioExceptionTest() throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.removeProduto(livro, 99);
	}

	@Test
	public void totalValorZeroTest() {
		assertEquals(0.0, car.totalValor(), 0.0);
	}

	@Test
	public void totalValorTest() throws ProdutoQuantidadeException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro, 3);
		Produto geladeira = new Eletrodomestico("Geladeira", 5000.00);
		car.add(geladeira, 2);
		double somaEsperada = 10150.0;
		assertEquals(somaEsperada, car.totalValor(), 0.0);
	}

	@Test
	public void obterListaItensTest() throws ProdutoQuantidadeException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro, 2);
		Produto geladeira = new Eletrodomestico("Geladeira", 5000.00);
		car.add(geladeira);
		assertEquals(car.totalProdutos(),car.produtos().size());
	}

	@Test
	public void integridadeListaItensTest() throws CarrinhoVazioException, ProdutoQuantidadeException, ProdutoInexistenteException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro, 2);
		Produto geladeira = new Eletrodomestico("Geladeira", 5000.00);
		car.add(geladeira);
		Set<Map.Entry<Produto, Integer>> produtos = car.produtos();
		int sz = 0;
		for (Map.Entry<Produto, Integer> valor : produtos) {
			sz += valor.getValue();
		}
		assertEquals(sz, car.totalItens());
		boolean found = false;
		for (Map.Entry<Produto, Integer> valor : produtos) {
			if (valor.getKey().equals(livro)) {
				found = true;
			}
		}
		assertTrue(found);
		found = false;
		car.removeItem(livro);
		for (Map.Entry<Produto, Integer> valor : produtos) {
			if (valor.getKey().equals(livro)) {
				found = true;
			}
		}
		assertTrue(found);
		found = false;
		for (Map.Entry<Produto, Integer> valor : produtos) {
			if (valor.getKey().equals(geladeira)) {
				found = true;
			}
		}
		assertTrue(found);
	}

	@Test
	public void obterListaProdutosTest() throws CarrinhoVazioException, ProdutoInexistenteException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro);
		Produto geladeira = new Eletrodomestico("Geladeira", 5000.00);
		car.add(geladeira);
		Produto livro2 = new Livro("UML 2.0", 75.00);
		car.add(livro2);
		assertEquals(car.itens().size(), car.totalProdutos());
	}
	
	@Test
	public void integridadeListaProdutosTest() throws CarrinhoVazioException, ProdutoInexistenteException {
		Produto livro = new Livro("Java em 24 horas", 50.00);
		car.add(livro);
		Produto geladeira = new Eletrodomestico("Geladeira", 5000.00);
		car.add(geladeira);
		Produto livro2 = new Livro("UML 2.0", 75.00);
		car.add(livro2);
		Set<Produto> itens = car.itens();
		assertTrue(itens.contains(livro));
		assertTrue(itens.contains(geladeira));
		assertTrue(itens.contains(livro2));
	}
}
