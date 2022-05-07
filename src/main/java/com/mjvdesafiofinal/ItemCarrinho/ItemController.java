package com.mjvdesafiofinal.ItemCarrinho;


import com.mjvdesafiofinal.carrinho.CarrinhoEntity;
import com.mjvdesafiofinal.carrinho.CarrinhoService;
import com.mjvdesafiofinal.usuario.UsuarioEntity;
import com.mjvdesafiofinal.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/item")
public class ItemController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    CarrinhoService carrinhoService;
    @Autowired
    ItemService itemService;

    @PostMapping("/{carrinhoId}")
    public ResponseEntity<ItemCarrinhoResponse> adicionaNovoItemCarrinho(
            @PathVariable Long carrinhoId,
            @RequestBody ItemRequest item) throws Exception {

       CarrinhoEntity carrinhoEntity = carrinhoService.buscaCarrinhoPorId(carrinhoId);
        List<ItemCarrinho> listaPedido = carrinhoEntity.getItens();

        ItemCarrinho entity = itemService.toEntity(item);
        entity.setCarrinho(carrinhoService.buscaCarrinhoPorId(carrinhoId));
        itemService.salvaEntidadeRepository(entity);

       listaPedido.add(entity);
       carrinhoService.salvaEntityRepository(carrinhoEntity);

        ItemCarrinhoResponse itemCarrinhoResponse = new ItemCarrinhoResponse(entity);

        return new ResponseEntity<>(itemCarrinhoResponse, HttpStatus.ACCEPTED);

    }
}
