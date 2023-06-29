package com.mercadinho.Produtos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarrinhoDeCompras {
    private List<Produto> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void addItem(List<Produto> produtos) {
        Objects.requireNonNull(produtos, "O produto não pode ser nulo.");
        this.itens.addAll(produtos);
    }

    public void removeItem(Produto produto) {
        for (Produto item : itens) {
            if (item.equals(produto)) {
                itens.remove(item);
                break;
            }
        }
    }

    public double calculaTotalItens() {
        double total = 0.0;

        for (Produto item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }

        return total;
    }

    public int getNumeroDeItens() {
        return itens.size();
    }

    public boolean contemItem(Produto produto) {
        return itens.contains(produto);
    }
    
    public int consultarQuantidade(List<Produto> produtos) {
        int quantidade = 0;
        for (Produto item : itens) {
            if (item.equals(produtos)) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public double getValorTotal() {
        return calculaTotalItens();
    }

    public void clear() {
        itens.clear();
    }

    public boolean isEmpty() {
        return false;
    }


}
