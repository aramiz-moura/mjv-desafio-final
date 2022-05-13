package com.mjvdesafiofinal.carrinho;


import com.mjvdesafiofinal.ItemCarrinho.ItemCarrinhoEntity;
import com.mjvdesafiofinal.exception.ApiRequestException;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


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
        CarrinhoEntity entity = carrinhoRepository.findById(id).orElseThrow(() -> new ApiRequestException("OOps,carrinho não encontrado"));
        return entity;
    }


    public BigDecimal somaValorItens(List<ItemCarrinhoEntity> listaDeItens) {

        BigDecimal sumofItens = listaDeItens.stream().map(item -> BigDecimal.valueOf(item.getQuantidade()).multiply(item.getProduto().getValor()))
                .reduce(BigDecimal.ZERO,BigDecimal::add);

        return sumofItens;
    }
}
