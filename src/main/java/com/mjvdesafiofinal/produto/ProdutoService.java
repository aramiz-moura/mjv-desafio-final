package com.mjvdesafiofinal.produto;

import com.mjvdesafiofinal.exception.ApiRequestException;
import com.mjvdesafiofinal.specification.ProdutoSpecifications;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class ProdutoService {


    private ProdutoRepository repository;

    public ProdutoEntity criaNovoProduto(ProdutoRequest produtoRequest){
        ProdutoEntity entity = toEntity(produtoRequest);
        return repository.save(entity);
    }

    public ProdutoEntity buscaProdutoPorId(Long id) throws ApiRequestException {
        return repository.findById(id).orElseThrow(() -> new ApiRequestException("Ooops! Produto não encontrado!"));
    }

    public List<ProdutoEntity> buscarTodos(ProdutoRequest request) {

        return repository.findAll(
                where(ProdutoSpecifications.nomeContem(request.getNome()))
                        .and(ProdutoSpecifications.valorMenorOuIgual(request.getValor()))
        );
    }

    public void deletaProdutoPorId(Long id) {
        repository.deleteById(id);
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
