package com.mjvdesafiofinal.ecommerce.model.ItemCarrinho;



import com.mjvdesafiofinal.ecommerce.model.carrinho.CarrinhoEntity;
import com.mjvdesafiofinal.ecommerce.model.produto.ProdutoEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ITEM_CARRINHO")
public class ItemCarrinhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
   private CarrinhoEntity carrinho;

    private Integer quantidade;

    public ItemCarrinhoEntity(ProdutoEntity produto, Integer quantidade, CarrinhoEntity carrinho) {
        this.produto = produto;
       this.carrinho = carrinho;
        this.quantidade = quantidade;
    }

    public ItemCarrinhoEntity() {

    }
}
