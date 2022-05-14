package com.mjvdesafiofinal.ecommerce.controller;


import com.mjvdesafiofinal.ecommerce.exception.ApiRequestException;
import com.mjvdesafiofinal.ecommerce.model.ItemCarrinho.ItemCarrinhoEntity;
import com.mjvdesafiofinal.ecommerce.model.ItemCarrinho.ItemCarrinhoResponse;
import com.mjvdesafiofinal.ecommerce.model.ItemCarrinho.ItemRequest;
import com.mjvdesafiofinal.ecommerce.model.carrinho.CarrinhoEntity;
import com.mjvdesafiofinal.ecommerce.model.carrinho.CarrinhoResponse;
import com.mjvdesafiofinal.ecommerce.repository.ItemCarrinhoRepository;
import com.mjvdesafiofinal.ecommerce.service.CarrinhoService;
import com.mjvdesafiofinal.ecommerce.service.ItemService;
import com.mjvdesafiofinal.model.ItemCarrinho.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/carrinho")
public class CarrinhoController {

    CarrinhoService carrinhoService;

    ItemCarrinhoRepository itemCarrinhoRepository;

    ItemService itemService;

    public CarrinhoController(CarrinhoService carrinhoService, ItemCarrinhoRepository itemCarrinhoRepository, ItemService itemService) {
        this.carrinhoService = carrinhoService;
        this.itemCarrinhoRepository = itemCarrinhoRepository;
        this.itemService = itemService;
    }

    @GetMapping("/{idCarrinho}")
    public ResponseEntity<CarrinhoResponse> itensNoCarrinho(@PathVariable Long idCarrinho) throws ApiRequestException {

        CarrinhoEntity entity = carrinhoService.buscaCarrinhoPorId(idCarrinho);
        CarrinhoResponse carrinhoResponse = new CarrinhoResponse(entity);

        return ResponseEntity.ok(carrinhoResponse);

    }

    @PostMapping("/{idCarrinho}")
    public ResponseEntity<ItemCarrinhoResponse> adicionaNovoItemCarrinho(
            @PathVariable Long idCarrinho,
            @RequestBody ItemRequest item) throws ApiRequestException {

        CarrinhoEntity carrinhoEntity = carrinhoService.buscaCarrinhoPorId(idCarrinho);
        List<ItemCarrinhoEntity> listaPedido = carrinhoEntity.getItens();

        ItemCarrinhoEntity entity = itemService.toEntity(item);
        entity.setCarrinho(carrinhoEntity);
        itemService.salvaEntidadeRepository(entity);

        listaPedido.add(entity);
        carrinhoEntity.setValorTotal(carrinhoService.somaValorItens(listaPedido));
        carrinhoService.salvaEntityRepository(carrinhoEntity);


        ItemCarrinhoResponse itemCarrinhoResponse = new ItemCarrinhoResponse(entity);

        return new ResponseEntity<>(itemCarrinhoResponse, HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{idCarrinho}/{idItemCarrinho}")
    public ResponseEntity<CarrinhoResponse> deletaCarrinho(@PathVariable Long idCarrinho,
                                                               @PathVariable Long idItemCarrinho) {

        CarrinhoEntity carrinhoEntity = carrinhoService.buscaCarrinhoPorId(idCarrinho);

        ItemCarrinhoEntity itemCarrinho = itemService.buscaItemCarrinhoPorId(idItemCarrinho);
        itemService.deletaItemCarrinhoPorId(idItemCarrinho);
        carrinhoService.salvaEntityRepository(carrinhoEntity);
        CarrinhoResponse response = new CarrinhoResponse(carrinhoEntity);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

}
