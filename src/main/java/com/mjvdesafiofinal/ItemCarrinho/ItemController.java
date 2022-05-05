package com.mjvdesafiofinal.ItemCarrinho;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/item")
public class ItemController {


    @PostMapping()
    public ResponseEntity<ItemCarrinhoResponse> adicionaNovoItemCarrinho(ItemRequest item) {

    }
}
