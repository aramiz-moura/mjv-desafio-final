package com.mjvdesafiofinal.ecommerce.service;


import com.mjvdesafiofinal.ecommerce.model.carrinho.CarrinhoEntity;
import com.mjvdesafiofinal.ecommerce.exception.NotFoundException;
import com.mjvdesafiofinal.ecommerce.model.ItemCarrinho.ItemCarrinhoEntity;
import com.mjvdesafiofinal.ecommerce.exception.ApiRequestException;
import com.mjvdesafiofinal.ecommerce.repository.CarrinhoRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Data
@Service
public class CarrinhoService {



    CarrinhoRepository carrinhoRepository;

    public CarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }


    public CarrinhoEntity salvaEntityRepository(CarrinhoEntity carrinhoEntity) {
        return carrinhoRepository.save(carrinhoEntity);
    }

    public CarrinhoEntity buscaCarrinhoPorId(Long id) throws ApiRequestException {
        CarrinhoEntity entity = carrinhoRepository.findById(id).orElseThrow(() -> new NotFoundException("OOps,carrinho não encontrado"));
        return entity;
    }





    public BigDecimal somaValorItens(List<ItemCarrinhoEntity> listaDeItens) {

        BigDecimal sumofItens = listaDeItens.stream().map(item -> BigDecimal.valueOf(item.getQuantidade()).multiply(item.getProduto().getValor()))
                .reduce(BigDecimal.ZERO,BigDecimal::add);

        return sumofItens;
    }
}
