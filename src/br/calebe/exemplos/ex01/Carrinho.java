package br.calebe.exemplos.ex01;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Carrinho {

	private Map<Produto, Integer> itens;

	public Carrinho() {
		itens = new HashMap<Produto, Integer>();
	}

	public int quantidadeItem(Produto p) {
		return itens.get(p);
	}

	public int totalProdutos() {
		int sum = 0;
		for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
			sum += entry.getValue();
		}
		return sum;
	}

	public int totalItens() {
		return itens.size();
	}

	public double totalValor() {
		double sum = 0;
		for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
			sum += entry.getKey().getPreco() * entry.getValue();
		}
		return sum;
	}

	public void add(Produto produto) {
		if (itens.containsKey(produto)) {
			itens.put(produto, itens.get(produto) + 1);
		} else {
			itens.put(produto, 1);
		}
	}

	private boolean validaQuantidade(Produto produto, int x) {
		return x > 0 && x <= itens.get(produto);
	}

	private boolean validaQuantidade(int x) {
		return x > 0;
	}

	public void add(Produto produto, int x) throws ProdutoQuantidadeException {
		if (!validaQuantidade(x)) {
			throw new ProdutoQuantidadeException();
		}
		if (itens.containsKey(produto)) {
			itens.put(produto, itens.get(produto) + x);
		} else {
			itens.put(produto, x);
		}
	}

	public void removeProduto(Produto produto) throws CarrinhoVazioException, ProdutoInexistenteException {
		if (canUse()) {
			if (!itens.containsKey(produto)) {
				throw new ProdutoInexistenteException();
			} else if (itens.get(produto) == 1) {
				itens.remove(produto);
			} else {
				itens.put(produto, itens.get(produto) - 1);
			}
		}
	}

	public void removeItem(Produto produto) throws CarrinhoVazioException, ProdutoInexistenteException {
		if (canUse()) {
			if (!itens.containsKey(produto)) {
				throw new ProdutoInexistenteException();
			} else {
				itens.remove(produto);
			}
		}
	}

	public void removeXProdutos(Produto produto, Integer x) throws CarrinhoVazioException, ProdutoInexistenteException, ProdutoQuantidadeException {
		if (canUse()) {
			if (!itens.containsKey(produto)) {
				throw new ProdutoInexistenteException();
			} else if (!validaQuantidade(produto, x)) {
				throw new ProdutoQuantidadeException();
			} else {
				if (Objects.equals(x, itens.get(produto))) {
					removeItem(produto);
				} else {
					for (int i = 0; i != x; ++i) {
						removeProduto(produto);
					}
				}
			}
		}
	}

	public Set<Map.Entry<Produto, Integer>> gerarConjuntoItens() {
		return itens.entrySet();
	}

	public Set<Produto> gerarConjuntoProdutos() {
		return itens.keySet();
	}

	public void clean() {
		itens.clear();
	}

	private boolean canUse() throws CarrinhoVazioException {
		if (isEmpty()) {
			throw new CarrinhoVazioException();
		}
		return true;
	}

	public boolean isEmpty() {
		return itens.isEmpty();
	}
}
