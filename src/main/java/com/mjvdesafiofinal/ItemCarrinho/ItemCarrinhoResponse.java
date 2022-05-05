package com.mjvdesafiofinal.ItemCarrinho;


import com.mjvdesafiofinal.carrinho.CarrinhoEntity;
import com.mjvdesafiofinal.carrinho.CarrinhoResponse;
import com.mjvdesafiofinal.produto.ProdutoEntity;
import com.mjvdesafiofinal.produto.ProdutoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCarrinhoResponse {

    private Long id;

    private ProdutoResponse produto;
    private CarrinhoResponse carrinho;

    private Integer quantidade;

    public ItemCarrinhoResponse(ItemCarrinho item) {
        this.id = item.getId();
        this.produto = new ProdutoResponse(item.getProduto());
        this.carrinho = new CarrinhoResponse(item.getCarrinho());
        this.quantidade = item.getQuantidade();
    }
}
