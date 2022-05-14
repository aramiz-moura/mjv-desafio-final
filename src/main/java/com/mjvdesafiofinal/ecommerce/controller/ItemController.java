package com.mjvdesafiofinal.ecommerce.controller;



import com.mjvdesafiofinal.ecommerce.service.CarrinhoService;
import com.mjvdesafiofinal.ecommerce.service.ItemService;

import com.mjvdesafiofinal.ecommerce.service.UsuarioService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/v1/item")
public class ItemController {



    UsuarioService usuarioService;
    CarrinhoService carrinhoService;
    ItemService itemService;

    public ItemController(UsuarioService usuarioService, CarrinhoService carrinhoService, ItemService itemService) {
        this.usuarioService = usuarioService;
        this.carrinhoService = carrinhoService;
        this.itemService = itemService;
    }
}
