package br.calebe.exemplos.ex01;

public class Item {
    
    private Produto produto;
    private int quantidade;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    @Override
    public boolean equals(Object obj) {
        return equals((Item) obj);
    }

    public boolean equals(Item obj) {
        return produto.equals(obj.produto);
    }
}
