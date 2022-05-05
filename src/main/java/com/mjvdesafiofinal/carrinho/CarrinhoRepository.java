package com.mjvdesafiofinal.carrinho;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long> {

    Optional<CarrinhoEntity> findById(Long id);
}
