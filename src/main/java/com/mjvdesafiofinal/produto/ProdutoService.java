package com.mjvdesafiofinal.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public ProdutoEntity criaNovoProduto(ProdutoRequest produtoRequest){
        ProdutoEntity entity = toEntity(produtoRequest);
        return repository.save(entity);
    }

    public ProdutoEntity buscaProdutoPorId(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Produto não encontrado"));
    }


    public ProdutoEntity toEntity(ProdutoRequest request) {
        return new ProdutoEntity(
                request.getNome(),
                request.getDescricao(),
                request.getTipoMidia(),
                request.getPlataforma(),
                request.getValor()
        );
    }

}
