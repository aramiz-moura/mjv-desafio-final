package com.mjvdesafiofinal.ItemCarrinho;



import com.mjvdesafiofinal.carrinho.CarrinhoEntity;
import com.mjvdesafiofinal.carrinho.CarrinhoRepository;
import com.mjvdesafiofinal.carrinho.CarrinhoService;
import com.mjvdesafiofinal.produto.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {



    @Autowired
    ItemCarrinhoRepository itemCarrinhoRepository;
    @Autowired
    CarrinhoRepository carrinhoRepository;


    @Autowired
    ProdutoService produtoService;

    @Autowired
    CarrinhoService carrinhoService;

    public ItemCarrinho toEntity(ItemRequest itemRequest) throws Exception {
        ItemCarrinho itemCarrinho = new ItemCarrinho();
        itemCarrinho.setProduto(produtoService.buscaProdutoPorId(itemRequest.getProdutoId()));
        itemCarrinho.setQuantidade(itemRequest.getQuantidade());
        return itemCarrinho;
    }

    public ItemCarrinho salvaItemCarrinho(ItemRequest item) throws Exception {
        ItemCarrinho itemCarrinho = toEntity(item);
        return itemCarrinhoRepository.save(itemCarrinho);
    }


    public ItemCarrinho salvaEntidadeRepository(ItemCarrinho itemCarrinho) {
        return itemCarrinhoRepository.save(itemCarrinho);
    }



}
