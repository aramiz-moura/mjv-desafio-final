package com.mjvdesafiofinal.ecommerce.model.ItemCarrinho;


import com.mjvdesafiofinal.ecommerce.model.produto.ProdutoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCarrinhoResponse {

    private Long id;
    private ProdutoResponse produto;
    private BigDecimal quantidade;

    public ItemCarrinhoResponse(ItemCarrinhoEntity item) {
        this.id = item.getId();
        this.produto = new ProdutoResponse(item.getProduto());
        this.quantidade = BigDecimal.valueOf(item.getQuantidade());
    }
}
