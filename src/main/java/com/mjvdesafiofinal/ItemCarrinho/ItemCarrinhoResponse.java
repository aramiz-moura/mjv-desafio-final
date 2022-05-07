package com.mjvdesafiofinal.ItemCarrinho;


import com.mjvdesafiofinal.carrinho.CarrinhoEntity;
import com.mjvdesafiofinal.carrinho.CarrinhoResponse;
import com.mjvdesafiofinal.produto.ProdutoEntity;
import com.mjvdesafiofinal.produto.ProdutoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCarrinhoResponse {

    private Long id;

    private ProdutoResponse produto;


    private Integer quantidade;

    public ItemCarrinhoResponse(ItemCarrinho item) {
        this.id = item.getId();
        this.produto = new ProdutoResponse(item.getProduto());
        this.quantidade = item.getQuantidade();
    }
}
