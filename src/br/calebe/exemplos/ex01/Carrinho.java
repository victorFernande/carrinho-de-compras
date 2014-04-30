package br.calebe.exemplos.ex01;

import java.util.HashMap;
import java.util.Map;

public class Carrinho {

	private Map<Produto, Integer> itens;

	public Carrinho() {
		itens = new HashMap<Produto, Integer>();
	}

	public int totalItens() {
		int sum = 0;
		for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
			sum += entry.getValue();
		}
		return sum;
	}

	public double total() {
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

	public boolean isEmpty() {
		return itens.isEmpty();
	}
}
