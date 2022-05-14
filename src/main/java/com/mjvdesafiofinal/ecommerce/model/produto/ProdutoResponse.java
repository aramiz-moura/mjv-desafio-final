package com.mjvdesafiofinal.ecommerce.model.produto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;


@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProdutoResponse {
    private Long id;
    private String nome;
    private String descricao;
    private TipoMidia tipoMidia;
    private String plataforma;
    private BigDecimal valor;


    public ProdutoResponse(ProdutoEntity produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.tipoMidia = produto.getTipoMidia();
        this.plataforma = produto.getPlataforma();
        this.valor = produto.getValor();
    }
}
