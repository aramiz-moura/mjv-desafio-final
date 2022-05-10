package com.mjvdesafiofinal.carrinho;

import com.mjvdesafiofinal.ItemCarrinho.ItemCarrinho;
import com.mjvdesafiofinal.usuario.UsuarioEntity;
import lombok.Data;


import javax.persistence.*;

import java.util.List;

@Entity
@Data
@Table(name = "CARRINHOS")
public class CarrinhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="item_carrinho_id")
    private List<ItemCarrinho> itens;

    public CarrinhoEntity( List<ItemCarrinho> itens) {
        this.itens = itens;
    }


    public CarrinhoEntity() {

    }
}
