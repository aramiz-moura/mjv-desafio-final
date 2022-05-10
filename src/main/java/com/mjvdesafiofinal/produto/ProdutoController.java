package com.mjvdesafiofinal.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

//    @GetMapping("/{idProduto}")
//    public ResponseEntity<ProdutoResponse> getProduto(@PathVariable Long idProduto) {
//
//    }
}
