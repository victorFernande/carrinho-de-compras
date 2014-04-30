package br.calebe.exemplos.ex01;

import br.calebe.exemplos.ex01.CarrinhoVazioExpected;
import java.util.HashMap;
import java.util.Map;

public class Carrinho {

	private Map<Produto, Integer> itens;

	public Carrinho() {
		itens = new HashMap<Produto, Integer>();
	}

	public int totalProdutos() throws CarrinhoVazioExpected {
		if(!isEmpty());
		int sum = 0;
		for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
			sum += entry.getValue();
		}
		return sum;
	}
	
	public int totalItens(){
		return itens.size();
	}

	public double totalValor() throws CarrinhoVazioExpected {
		if(!isEmpty());
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

	public boolean isEmpty() throws CarrinhoVazioExpected {
		if(itens.isEmpty())
			throw new CarrinhoVazioExpected();
		return itens.isEmpty();
	}
}
