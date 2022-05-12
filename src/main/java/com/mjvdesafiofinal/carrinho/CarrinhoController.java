package com.mjvdesafiofinal.carrinho;

import com.mjvdesafiofinal.ItemCarrinho.*;
import com.mjvdesafiofinal.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/carrinho")
public class CarrinhoController {

    @Autowired
    CarrinhoService carrinhoService;

    @Autowired
    ItemCarrinhoRepository itemCarrinhoRepository;

    @Autowired
    ItemService itemService;

    @GetMapping("/{idCarrinho}")
    public List<ItemCarrinhoResponse> itensNoCarrinho(@PathVariable Long idCarrinho) throws ApiRequestException {

        CarrinhoEntity entity = carrinhoService.buscaCarrinhoPorId(idCarrinho);
        List<ItemCarrinhoEntity> entityItemCarrinhoEntity = entity.getItens();

        return entityItemCarrinhoEntity.stream().map(ItemCarrinhoResponse::new).collect(Collectors.toList());

    }

    @PostMapping("/{carrinhoId}")
    public ResponseEntity<ItemCarrinhoResponse> adicionaNovoItemCarrinho(
            @PathVariable Long carrinhoId,
            @RequestBody ItemRequest item) throws ApiRequestException {

        CarrinhoEntity carrinhoEntity = carrinhoService.buscaCarrinhoPorId(carrinhoId);
        List<ItemCarrinhoEntity> listaPedido = carrinhoEntity.getItens();

        ItemCarrinhoEntity entity = itemService.toEntity(item);
        entity.setCarrinho(carrinhoEntity);
        itemService.salvaEntidadeRepository(entity);

        listaPedido.add(entity);
        carrinhoService.salvaEntityRepository(carrinhoEntity);

        ItemCarrinhoResponse itemCarrinhoResponse = new ItemCarrinhoResponse(entity);

        return new ResponseEntity<>(itemCarrinhoResponse, HttpStatus.ACCEPTED);

    }

}
