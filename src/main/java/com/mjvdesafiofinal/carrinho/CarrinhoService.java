package com.mjvdesafiofinal.carrinho;


import com.mjvdesafiofinal.ItemCarrinho.ItemRequest;
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

    public CarrinhoEntity buscaCarrinhoPorId(Long id) throws Exception {
        CarrinhoEntity entity = carrinhoRepository.findById(id).orElseThrow(() -> new Exception("Carrinho não encontrado"));
        return entity;
    }
}
