package com.CarrinhoTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mercadinho.Produtos.CarrinhoDeCompras;
import com.mercadinho.Produtos.Produto;

public class CarrinhoTest {
    protected CarrinhoDeCompras carrinho;
    protected List<Produto> produtos;


    @BeforeAll
    public static void setUpClass() {
        // Realize qualquer inicialização necessária para todos os testes
    }

    @BeforeEach
    public void setUp() {
        carrinho = new CarrinhoDeCompras();  // Atribuição à variável de instância carrinho
        produtos = new ArrayList<>();


        produtos.add(new Produto("Maça", 2.99, 8));
        produtos.add(new Produto("Arroz", 22.95, 1));   // Atribuição à variável de instância alimento
        produtos.add(new Produto("Água", 7.90, 3));
        produtos.add(new Produto("Refrigerante", 18.50, 2));
        produtos.add(new Produto("Feijão", 12.90, 3));
        produtos.add(new Produto("Macarrão Gourmet", 3.40, 3));
        produtos.add(new Produto("Café Pilão", 22.79, 2));
        produtos.add(new Produto("Yakult", 3.45, 5));
        produtos.add(new Produto("Ninho", 4.99, 6));
        produtos.add(new Produto("Peito de Frango", 12.90, 3));
        produtos.add(new Produto("Ovos Aline", 22.90, 1));

        carrinho.addItem(produtos);
        

    }

    @Test
    @DisplayName("Teste para adicionar um produto ao carrinho")
    public void testAdicionarProduto() {
        
        Assertions.assertEquals(11, carrinho.getNumeroDeItens());
    }

    
    @Test
    @DisplayName("Teste para remover produtos do carrinho")
    public void testRemoveProduto() {
        
        
        carrinho.removeItem(new Produto("Arroz", 22.95, 1));
        carrinho.removeItem(new Produto("Refrigerante", 18.50, 2));
        carrinho.removeItem(new Produto("Yakult", 3.45, 5));
        carrinho.removeItem(new Produto("Maça", 2.99, 8));

        

        Assertions.assertFalse(carrinho.contemItem(new Produto("Arroz", 22.95, 1)));
        Assertions.assertFalse(carrinho.contemItem(new Produto("Refrigerante", 18.50, 2)));

        Assertions.assertEquals(11, carrinho.getNumeroDeItens());  // O carrinho deve estar vazio após remover o produto
        
       
    }

    
    @Test
    @DisplayName("Teste para calcular o preço total dos produtos")
    public void testCalcularTotalDePrecos() {
        
        double totalPreco = carrinho.calculaTotalItens();

        
        Assertions.assertEquals(310.84, totalPreco);
    }


    @Test
    @DisplayName("Teste para calcular a quantidade de itens do carrinho")
    public int testConsultarQuantidade(){
        int quant = carrinho.consultarQuantidade(produtos);
        return quant;
    }



    @AfterEach
    public void limparCarrinho(){
        carrinho.clear();
        carrinho.isEmpty(); //O carrinho está vazio?
    }

    
}
