package com.mjvdesafiofinal.ecommerce.model.produto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequest {
    private String nome;
    private String descricao;
    private TipoMidia tipoMidia;
    private String plataforma;
    private BigDecimal valor;
}
