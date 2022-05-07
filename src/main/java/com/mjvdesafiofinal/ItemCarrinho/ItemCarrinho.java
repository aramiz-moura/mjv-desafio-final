package com.mjvdesafiofinal.ItemCarrinho;



import com.mjvdesafiofinal.carrinho.CarrinhoEntity;
import com.mjvdesafiofinal.produto.ProdutoEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ItemCarrinho {

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

    public ItemCarrinho(ProdutoEntity produto,Integer quantidade, CarrinhoEntity carrinho) {
        this.produto = produto;
       this.carrinho = carrinho;
        this.quantidade = quantidade;
    }

    public ItemCarrinho() {

    }
}
