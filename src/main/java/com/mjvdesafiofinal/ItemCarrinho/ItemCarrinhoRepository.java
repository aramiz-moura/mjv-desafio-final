package com.mjvdesafiofinal.ItemCarrinho;

import com.mjvdesafiofinal.ItemCarrinho.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho,Long> {
    List<ItemCarrinho> findAllByCarrinho_Id(Long id);

}
