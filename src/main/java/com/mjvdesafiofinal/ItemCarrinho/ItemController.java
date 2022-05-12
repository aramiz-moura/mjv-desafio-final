package com.mjvdesafiofinal.ItemCarrinho;


import com.mjvdesafiofinal.carrinho.CarrinhoEntity;
import com.mjvdesafiofinal.carrinho.CarrinhoService;
import com.mjvdesafiofinal.exception.ApiRequestException;
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


}
