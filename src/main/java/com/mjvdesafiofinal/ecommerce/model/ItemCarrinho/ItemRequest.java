package com.mjvdesafiofinal.ecommerce.model.ItemCarrinho;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    private Long produtoId;
    private Integer quantidade;
}
