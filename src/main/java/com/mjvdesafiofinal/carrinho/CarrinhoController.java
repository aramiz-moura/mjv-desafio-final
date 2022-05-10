package com.mjvdesafiofinal.carrinho;

import com.mjvdesafiofinal.ItemCarrinho.ItemCarrinho;
import com.mjvdesafiofinal.ItemCarrinho.ItemCarrinhoRepository;
import com.mjvdesafiofinal.ItemCarrinho.ItemCarrinhoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/carrinho")
public class CarrinhoController {

    @Autowired
    CarrinhoService carrinhoService;

    @Autowired
    ItemCarrinhoRepository itemCarrinhoRepository;

    @GetMapping("/{idCarrinho}")
    public List<ItemCarrinhoResponse> itensNoCarrinho(@PathVariable Long idCarrinho) throws Exception {

        List<ItemCarrinho> entityItemCarrinho = itemCarrinhoRepository.findAllByCarrinho_Id(idCarrinho);

        return entityItemCarrinho.stream().map(ItemCarrinhoResponse::new).collect(Collectors.toList());

    }

}
