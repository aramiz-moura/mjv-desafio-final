package com.mjvdesafiofinal.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity,Long>, JpaSpecificationExecutor<ProdutoEntity> {

}
