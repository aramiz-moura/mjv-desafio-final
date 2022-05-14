package com.mjvdesafiofinal.ecommerce.repository;

import com.mjvdesafiofinal.ecommerce.model.carrinho.CarrinhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long> {

}
