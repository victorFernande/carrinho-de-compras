package br.calebe.exemplos.ex01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Carrinho {

	private Map<Produto, Integer> itens;

	public Carrinho() {
		itens = new HashMap<Produto, Integer>();
	}

	public int quantidadeItem(Produto p) {
		return itens.get(p);
	}
	
	public int totalProdutos() throws CarrinhoVazioExpected {
		if(canUse());
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
		if(canUse());
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
	
	public void removeProduto(Produto produto) throws CarrinhoVazioExpected, ProdutoInexistenteException {
		if(canUse())
			if (!itens.containsKey(produto))
				throw new ProdutoInexistenteException();
			else
				if(itens.get(produto)==1)
					itens.remove(produto);
				else
					itens.put(produto, itens.get(produto)-1);
	}
	
	public void removeItem(Produto produto) throws CarrinhoVazioExpected, ProdutoInexistenteException {
		if(canUse())
			if (!itens.containsKey(produto))
				throw new ProdutoInexistenteException();
			else
				itens.remove(produto);
	}
	
	public void removerXProdutos(Produto produto, Integer x) throws CarrinhoVazioExpected, ProdutoInexistenteException, ProdutoQuantidadeException{
		if (!itens.containsKey(produto))
			throw new ProdutoInexistenteException();
		else
			if(x<=0 || x>itens.get(produto))
				throw new ProdutoQuantidadeException();
			else
				for(int i=0;i!=x;++i)
					removeProduto(produto);
				
	}
	
	public Set<Map.Entry<Produto,Integer>> gerarConjuntoItens(){
		return itens.entrySet();
	}
	
	public Set<Produto> gerarConjuntoProdutos() {
		return itens.keySet();
	}
	
	public void clean() {
		itens.clear();
	}
	
	public boolean canUse() throws CarrinhoVazioExpected{
		if(isEmpty())
			throw new CarrinhoVazioExpected();
		return true;
	}
	
	public boolean isEmpty(){
		return itens.isEmpty();
	}
}
