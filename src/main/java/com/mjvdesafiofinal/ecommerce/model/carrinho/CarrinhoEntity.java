package com.mjvdesafiofinal.ecommerce.model.carrinho;

import com.mjvdesafiofinal.ecommerce.model.ItemCarrinho.ItemCarrinhoEntity;
import lombok.Data;


import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "CARRINHO")
public class CarrinhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="item_carrinho_id")
    private List<ItemCarrinhoEntity> itens;


    private BigDecimal valorTotal;

    public CarrinhoEntity( List<ItemCarrinhoEntity> itens) {
        this.itens = itens;
    }


    public CarrinhoEntity() {

    }
}
