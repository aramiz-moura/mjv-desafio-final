package com.mjvdesafiofinal.ecommerce.model.usuario;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mjvdesafiofinal.ecommerce.model.carrinho.CarrinhoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UsuarioResponse {

    private Long id;
    private String nome;
    private String nomeUsuario;
    private String dataCriacao;
    private String dataAtualizacao;
    private CarrinhoResponse carrinho;

    public UsuarioResponse(UsuarioEntity usuarioEntity) {
        this.id = usuarioEntity.getId();
        this.nome = usuarioEntity.getNome();
        this.nomeUsuario = usuarioEntity.getNomeUsuario();
        this.dataCriacao = formataDataHora(usuarioEntity.getDataCriacao());
        this.dataAtualizacao = formataDataHora(usuarioEntity.getDataAtualizacao());
        this.carrinho = new CarrinhoResponse(usuarioEntity.getCarrinho());
    }

    public String formataDataHora(ZonedDateTime dataHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        String dataFormatada = dataHora.format(formatter);
        return dataFormatada;
    }

}
