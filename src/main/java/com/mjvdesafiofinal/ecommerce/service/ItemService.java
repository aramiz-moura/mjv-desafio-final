package com.mjvdesafiofinal.ecommerce.service;



import com.mjvdesafiofinal.ecommerce.model.ItemCarrinho.ItemRequest;
import com.mjvdesafiofinal.ecommerce.exception.NotFoundException;
import com.mjvdesafiofinal.ecommerce.model.ItemCarrinho.ItemCarrinhoEntity;
import com.mjvdesafiofinal.ecommerce.repository.ItemCarrinhoRepository;
import com.mjvdesafiofinal.ecommerce.repository.CarrinhoRepository;
import com.mjvdesafiofinal.ecommerce.exception.ApiRequestException;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class ItemService {


    ItemCarrinhoRepository itemCarrinhoRepository;
    CarrinhoRepository carrinhoRepository;
    ProdutoService produtoService;
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

    public ItemCarrinhoEntity buscaItemCarrinhoPorId(Long id) {
        return itemCarrinhoRepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido especificado não encontrado!"));
    }

    public void deletaItemCarrinhoPorId(Long id){
        itemCarrinhoRepository.deleteById(id);
    }


    public ItemCarrinhoEntity salvaEntidadeRepository(ItemCarrinhoEntity itemCarrinhoEntity) {
        return itemCarrinhoRepository.save(itemCarrinhoEntity);
    }



}
