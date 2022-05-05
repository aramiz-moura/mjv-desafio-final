package com.mjvdesafiofinal.ItemCarrinho;

import com.mjvdesafiofinal.ItemCarrinho.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho,Long> {

}
