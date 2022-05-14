package com.mjvdesafiofinal.ecommerce.model.carrinho;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mjvdesafiofinal.ecommerce.model.ItemCarrinho.ItemCarrinhoResponse;
import com.mjvdesafiofinal.ecommerce.model.ItemCarrinho.ItemCarrinhoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CarrinhoResponse {



    private Long id;
    private List<ItemCarrinhoResponse> itens;
    private BigDecimal valorTotal;

    public CarrinhoResponse (CarrinhoEntity entity) {
        this.id = entity.getId();
        if(entity.getItens() == null){
            List<ItemCarrinhoEntity> lista = new ArrayList<>();
            entity.setItens(lista);
        } else {
            List<ItemCarrinhoResponse> itemCarrinhoResponses = entity.getItens().stream().map(ItemCarrinhoResponse::new).collect(Collectors.toList());
            this.itens = itemCarrinhoResponses;
            BigDecimal sumofItens = itemCarrinhoResponses.stream().map(item -> item.getQuantidade().multiply(item.getProduto().getValor()))
                    .reduce(BigDecimal.ZERO,BigDecimal::add);
            this.valorTotal = sumofItens;
        }
    }

}
