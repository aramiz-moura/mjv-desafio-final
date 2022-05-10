package com.mjvdesafiofinal.carrinho;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mjvdesafiofinal.ItemCarrinho.ItemCarrinho;
import com.mjvdesafiofinal.ItemCarrinho.ItemCarrinhoResponse;
import com.mjvdesafiofinal.usuario.UsuarioResponse;
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
    private UsuarioResponse usuario;
    private List<ItemCarrinhoResponse> itens;

    public CarrinhoResponse (CarrinhoEntity entity) {
        this.id = entity.getId();
//        this.usuario = new UsuarioResponse(entity.getUsuario());
        if(entity.getItens() == null){
            List<ItemCarrinho> lista = new ArrayList<>();
            entity.setItens(lista);
        } else {
            this.itens = entity.getItens().stream().map(ItemCarrinhoResponse::new).collect(Collectors.toList());
        }


    }
}
