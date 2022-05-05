package com.mjvdesafiofinal.carrinho;

import com.mjvdesafiofinal.ItemCarrinho.ItemCarrinho;
import com.mjvdesafiofinal.usuario.UsuarioEntity;
import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "CARRINHOS")
public class CarrinhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private UsuarioEntity usuario;


    @OneToMany
    private List<ItemCarrinho> itens = new ArrayList<>();

    public CarrinhoEntity(UsuarioEntity usuario, List<ItemCarrinho> itens) {
        this.usuario = usuario;
        this.itens = itens;
    }

    public CarrinhoEntity() {

    }
}
