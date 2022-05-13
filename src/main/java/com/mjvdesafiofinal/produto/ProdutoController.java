package com.mjvdesafiofinal.produto;

import org.springframework.beans.factory.annotation.Autowired;
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
                                                     @RequestParam(name = "tipoMidia", required = false)TipoMidia tipoMidia) {
        ProdutoRequest filtros = new ProdutoRequest();
        filtros.setNome(nome);
        filtros.setValor(valor);
        filtros.setTipoMidia(tipoMidia);
        List<ProdutoEntity> produtos = produtoService.buscarTodos(filtros);
        return new ResponseEntity<>(produtos.stream().map(ProdutoResponse::new).collect(Collectors.toList()), HttpStatus.OK);

    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<ProdutoResponse> deletaProdutoPorId(Long id) {
        ProdutoEntity produtoEntity = produtoService.buscaProdutoPorId(id);
        ProdutoResponse produtoResponse = new ProdutoResponse(produtoEntity);

        produtoService.deletaProdutoPorId(id);

        return ResponseEntity.ok(produtoResponse);
    }
}
