package com.mjvdesafiofinal.carrinho;

import com.mjvdesafiofinal.ItemCarrinho.*;
import com.mjvdesafiofinal.exception.ApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        carrinhoEntity.setValorTotal(carrinhoService.somaValorItens(listaPedido));
        carrinhoService.salvaEntityRepository(carrinhoEntity);


        ItemCarrinhoResponse itemCarrinhoResponse = new ItemCarrinhoResponse(entity);

        return new ResponseEntity<>(itemCarrinhoResponse, HttpStatus.ACCEPTED);

    }

}
