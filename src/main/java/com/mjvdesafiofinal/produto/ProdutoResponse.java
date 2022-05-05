package com.mjvdesafiofinal.produto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;


@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProdutoResponse {
    private Long id;
    private String nome;
    private String descricao;
    private TipoMidia tipoMidia;
    private String plataforma;


    public ProdutoResponse(ProdutoEntity produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.tipoMidia = produto.getTipoMidia();
        this.plataforma = produto.getPlataforma();
    }
}
