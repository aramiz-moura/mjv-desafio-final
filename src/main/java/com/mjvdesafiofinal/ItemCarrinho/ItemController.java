package com.mjvdesafiofinal.ItemCarrinho;



import com.mjvdesafiofinal.carrinho.CarrinhoService;

import com.mjvdesafiofinal.usuario.UsuarioService;
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
