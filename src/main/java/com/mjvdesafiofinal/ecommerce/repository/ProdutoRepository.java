package com.mjvdesafiofinal.ecommerce.repository;

import com.mjvdesafiofinal.ecommerce.model.produto.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity,Long>, JpaSpecificationExecutor<ProdutoEntity> {

}
