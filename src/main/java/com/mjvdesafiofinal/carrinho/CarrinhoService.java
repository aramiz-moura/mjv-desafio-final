package com.mjvdesafiofinal.carrinho;


import com.mjvdesafiofinal.ItemCarrinho.ItemRequest;
import com.mjvdesafiofinal.exception.ApiRequestException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Data
@Service
public class CarrinhoService {


    @Autowired
    CarrinhoRepository carrinhoRepository;

//    public void adicionaItemCarrinho(ItemRequest item) {
//
//    }

    public CarrinhoEntity salvaEntityRepository(CarrinhoEntity carrinhoEntity) {
        return carrinhoRepository.save(carrinhoEntity);
    }

    public CarrinhoEntity buscaCarrinhoPorId(Long id) throws ApiRequestException {
        CarrinhoEntity entity = carrinhoRepository.findById(id).orElseThrow(() -> new ApiRequestException("OOps,carrinho não encontrado"));
        return entity;
    }
}
