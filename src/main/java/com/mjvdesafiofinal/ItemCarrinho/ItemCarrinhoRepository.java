package com.mjvdesafiofinal.ItemCarrinho;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinhoEntity,Long> {
    List<ItemCarrinhoEntity> findAllByCarrinho_Id(Long id);

}
