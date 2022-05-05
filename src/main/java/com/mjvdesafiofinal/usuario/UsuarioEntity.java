package com.mjvdesafiofinal.usuario;

import com.mjvdesafiofinal.carrinho.CarrinhoEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Data
@Table(name = "USUARIOS")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nomeUsuario;
    private String email;
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrinho_id")
    private CarrinhoEntity carrinho;

    private ZonedDateTime dataCriacao;
    private ZonedDateTime dataAtualizacao;

    public UsuarioEntity(String nome,String nomeUsuario, String email, String cpf, CarrinhoEntity carrinho) {
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.cpf = cpf;
        this.carrinho = carrinho;
        this.dataCriacao = ZonedDateTime.now();
        this.dataAtualizacao = ZonedDateTime.now();
    }

    public UsuarioEntity() {

    }
}
