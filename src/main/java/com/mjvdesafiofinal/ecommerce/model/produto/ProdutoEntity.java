package com.mjvdesafiofinal.ecommerce.model.produto;


import lombok.Data;


import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "PRODUTO")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private TipoMidia tipoMidia;
    private String plataforma;
    private BigDecimal valor;


    public ProdutoEntity(String nome, String descricao, TipoMidia tipoMidia, String plataforma, BigDecimal valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipoMidia = tipoMidia;
        this.plataforma = plataforma;
        this.valor = valor;
    }

    public ProdutoEntity() {

    }
}
