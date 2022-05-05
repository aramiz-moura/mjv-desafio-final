package com.mjvdesafiofinal.ItemCarrinho;


import com.mjvdesafiofinal.carrinho.CarrinhoEntity;
import com.mjvdesafiofinal.carrinho.CarrinhoRepository;
import com.mjvdesafiofinal.produto.ProdutoEntity;
import com.mjvdesafiofinal.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {


    @Autowired
    ItemCarrinhoRepository itemCarrinhoRepository;
    @Autowired
    CarrinhoRepository carrinhoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public
}
