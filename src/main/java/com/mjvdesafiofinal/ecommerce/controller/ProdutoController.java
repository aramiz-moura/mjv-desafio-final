package com.mjvdesafiofinal.ecommerce.controller;

import com.mjvdesafiofinal.ecommerce.model.produto.ProdutoEntity;
import com.mjvdesafiofinal.ecommerce.model.produto.ProdutoRequest;
import com.mjvdesafiofinal.ecommerce.model.produto.ProdutoResponse;
import com.mjvdesafiofinal.ecommerce.model.produto.TipoMidia;
import com.mjvdesafiofinal.model.produto.*;
import com.mjvdesafiofinal.ecommerce.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/v1/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

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
    public ResponseEntity<List<ProdutoResponse>> get(@RequestParam(name = "nome", required = false)String nome,
                                                     @RequestParam(name= "valor", required = false)BigDecimal valor,
                                                     @RequestParam(name = "tipoMidia", required = false) TipoMidia tipoMidia) {
        ProdutoRequest filtros = new ProdutoRequest();
        filtros.setNome(nome);
        filtros.setValor(valor);
        filtros.setTipoMidia(tipoMidia);
        List<ProdutoEntity> produtos = produtoService.buscarTodos(filtros);
        return new ResponseEntity<>(produtos.stream().map(ProdutoResponse::new).collect(Collectors.toList()), HttpStatus.OK);

    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<ProdutoResponse> deletaProdutoPorId(@PathVariable Long idProduto) {
        ProdutoEntity produtoEntity = produtoService.buscaProdutoPorId(idProduto);
        ProdutoResponse produtoResponse = new ProdutoResponse(produtoEntity);

        produtoService.deletaProdutoPorId(idProduto);

        return ResponseEntity.ok(produtoResponse);
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity<ProdutoResponse> atualizaProduto(@PathVariable Long idProduto,
                                                           @RequestBody ProdutoRequest produtoRequest) {
        ProdutoEntity produtoEntity = produtoService.buscaProdutoPorId(idProduto);
        ProdutoEntity produtoEntityAtualizada = produtoService.atualizaProduto(produtoEntity,produtoRequest);
        produtoService.salvaProduto(produtoEntityAtualizada);
        ProdutoResponse response = new ProdutoResponse(produtoEntityAtualizada);

        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
