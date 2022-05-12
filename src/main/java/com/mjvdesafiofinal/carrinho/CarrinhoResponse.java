package com.mjvdesafiofinal.carrinho;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mjvdesafiofinal.ItemCarrinho.ItemCarrinhoEntity;
import com.mjvdesafiofinal.ItemCarrinho.ItemCarrinhoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public CarrinhoResponse (CarrinhoEntity entity) {
        this.id = entity.getId();
        if(entity.getItens() == null){
            List<ItemCarrinhoEntity> lista = new ArrayList<>();
            entity.setItens(lista);
        } else {
            this.itens = entity.getItens().stream().map(ItemCarrinhoResponse::new).collect(Collectors.toList());
        }
    }
}
