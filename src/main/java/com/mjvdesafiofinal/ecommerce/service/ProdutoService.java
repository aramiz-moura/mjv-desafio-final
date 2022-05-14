package com.mjvdesafiofinal.ecommerce.service;

import com.mjvdesafiofinal.ecommerce.exception.ApiRequestException;
import com.mjvdesafiofinal.ecommerce.model.produto.ProdutoEntity;
import com.mjvdesafiofinal.ecommerce.model.produto.ProdutoRequest;
import com.mjvdesafiofinal.ecommerce.repository.ProdutoRepository;
import com.mjvdesafiofinal.ecommerce.exception.NotFoundException;
import com.mjvdesafiofinal.ecommerce.specification.ProdutoSpecifications;
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

    public void salvaProduto(ProdutoEntity produtoEntity) {
        repository.save(produtoEntity);
    }

    public ProdutoEntity buscaProdutoPorId(Long id) throws ApiRequestException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Ooops! Produto não encontrado!"));
    }

    public List<ProdutoEntity> buscarTodos(ProdutoRequest request) {

        return repository.findAll(
                where(ProdutoSpecifications.nomeContem(request.getNome()))
                        .and(ProdutoSpecifications.valorMenorOuIgual(request.getValor()))
                        .and(ProdutoSpecifications.tipoMidia(request.getTipoMidia()))
        );
    }

    public ProdutoEntity atualizaProduto(ProdutoEntity produtoEntity, ProdutoRequest produtoRequest) {
        produtoEntity.setNome(produtoRequest.getNome());
        produtoEntity.setDescricao(produtoRequest.getDescricao());
        produtoEntity.setTipoMidia(produtoRequest.getTipoMidia());
        produtoEntity.setPlataforma(produtoRequest.getPlataforma());
        produtoEntity.setValor(produtoRequest.getValor());
        return produtoEntity;
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
