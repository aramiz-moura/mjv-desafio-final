package com.mjvdesafiofinal.ItemCarrinho;



import com.mjvdesafiofinal.carrinho.CarrinhoRepository;
import com.mjvdesafiofinal.carrinho.CarrinhoService;
import com.mjvdesafiofinal.exception.ApiRequestException;
import com.mjvdesafiofinal.produto.ProdutoService;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class ItemService {

    @Autowired
    ItemCarrinhoRepository itemCarrinhoRepository;
    @Autowired
    CarrinhoRepository carrinhoRepository;
    @Autowired
    ProdutoService produtoService;
    @Autowired
    CarrinhoService carrinhoService;

    public ItemService(ItemCarrinhoRepository itemCarrinhoRepository, CarrinhoRepository carrinhoRepository, ProdutoService produtoService, CarrinhoService carrinhoService) {
        this.itemCarrinhoRepository = itemCarrinhoRepository;
        this.carrinhoRepository = carrinhoRepository;
        this.produtoService = produtoService;
        this.carrinhoService = carrinhoService;
    }

    public ItemCarrinhoEntity toEntity(ItemRequest itemRequest) throws ApiRequestException {
        ItemCarrinhoEntity itemCarrinhoEntity = new ItemCarrinhoEntity();
        itemCarrinhoEntity.setProduto(produtoService.buscaProdutoPorId(itemRequest.getProdutoId()));
        itemCarrinhoEntity.setQuantidade(itemRequest.getQuantidade());
        return itemCarrinhoEntity;
    }

    public ItemCarrinhoEntity salvaItemCarrinho(ItemRequest item) throws ApiRequestException {
        ItemCarrinhoEntity itemCarrinhoEntity = toEntity(item);
        return itemCarrinhoRepository.save(itemCarrinhoEntity);
    }


    public ItemCarrinhoEntity salvaEntidadeRepository(ItemCarrinhoEntity itemCarrinhoEntity) {
        return itemCarrinhoRepository.save(itemCarrinhoEntity);
    }



}
