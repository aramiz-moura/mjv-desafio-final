package com.mjvdesafiofinal.produto;


import lombok.Data;


import javax.persistence.*;


@Data
@Entity
@Table(name = "PRODUTOS")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private TipoMidia tipoMidia;
    private String plataforma;


    public ProdutoEntity(String nome, String descricao, TipoMidia tipoMidia, String plataforma) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipoMidia = tipoMidia;
        this.plataforma = plataforma;
    }

    public ProdutoEntity() {

    }
}
