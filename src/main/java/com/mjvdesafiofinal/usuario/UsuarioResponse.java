package com.mjvdesafiofinal.usuario;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mjvdesafiofinal.carrinho.CarrinhoEntity;
import com.mjvdesafiofinal.carrinho.CarrinhoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.ZonedDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UsuarioResponse {

    private Long id;
    private String nome;
    private String nomeUsuario;
    private ZonedDateTime dataCriacao;
    private ZonedDateTime dataAtualizacao;

    public UsuarioResponse(UsuarioEntity usuarioEntity) {
        this.id = usuarioEntity.getId();
        this.nome = usuarioEntity.getNome();
        this.nomeUsuario = usuarioEntity.getNomeUsuario();
        this.dataCriacao = usuarioEntity.getDataCriacao();
        this.dataAtualizacao = usuarioEntity.getDataAtualizacao();
    }


}
