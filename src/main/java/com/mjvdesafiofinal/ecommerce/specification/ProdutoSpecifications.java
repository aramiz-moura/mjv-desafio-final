package com.mjvdesafiofinal.ecommerce.specification;

import com.mjvdesafiofinal.ecommerce.model.produto.ProdutoEntity;
import com.mjvdesafiofinal.ecommerce.model.produto.TipoMidia;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProdutoSpecifications {

    public static Specification<ProdutoEntity> nomeContem (String nome) {
        return nome == null ? null: (produtoEntity, cq,cb) -> cb.like(produtoEntity.get("nome"), "%" + nome + "%");
    }


    public static Specification<ProdutoEntity> valorMenorOuIgual(BigDecimal valor) {
        return valor == null ? null: (produtoEntity, cq,cb) -> cb.lessThanOrEqualTo(produtoEntity.get("valor"), valor);
    }

    public static Specification<ProdutoEntity> tipoMidia(TipoMidia tipoMidia) {
        return tipoMidia == null ? null: (produtoEntity, cq,cb) -> cb.equal(produtoEntity.get("tipoMidia"), tipoMidia);
    }
}
