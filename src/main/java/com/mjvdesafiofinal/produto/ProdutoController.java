package com.mjvdesafiofinal.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/v1/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;


    @PostMapping()
    public ResponseEntity<ProdutoResponse> criaProduto(@RequestBody ProdutoRequest produtoRequest) {
        ProdutoResponse entity = new ProdutoResponse(produtoService.criaNovoProduto(produtoRequest));
        return new ResponseEntity<>(entity,HttpStatus.CREATED);
    }
}
