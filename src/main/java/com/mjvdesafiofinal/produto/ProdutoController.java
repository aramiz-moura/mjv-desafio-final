package com.mjvdesafiofinal.produto;

import com.mjvdesafiofinal.ItemCarrinho.ItemCarrinhoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


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

    @GetMapping("/{idProduto}")
    public ResponseEntity<ProdutoResponse> getProduto(@PathVariable Long idProduto) {
        ProdutoResponse entity = new ProdutoResponse(produtoService.buscaProdutoPorId(idProduto));
        return new ResponseEntity<>(entity, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<ProdutoResponse>> getAll() {
        List<ProdutoEntity> produtos = produtoService.getAll();
        return new ResponseEntity<>(produtos.stream().map(ProdutoResponse::new).collect(Collectors.toList()), HttpStatus.OK);

    }
}
