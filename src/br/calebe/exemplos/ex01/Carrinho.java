package br.calebe.exemplos.ex01;

import java.util.HashMap;
import java.util.Map;

public class Carrinho {

	private Map<Produto,Integer> itens;

	public Carrinho() {
		itens = new HashMap<Produto,Integer>();	
	}

	public void add(Produto produto) {
		if(itens.containsKey(produto))
			itens.put(produto,itens.get(produto)+1);
		else	
			itens.put(produto,1);
	}
	
	public boolean isEmpty() {
		return itens.isEmpty();
	}
}
