package com.mjvdesafiofinal;


import com.mjvdesafiofinal.produto.*;
import com.mjvdesafiofinal.usuario.UsuarioRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.math.BigDecimal;

@AutoConfigureTestDatabase
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProdutoCriacaoTest {


    private ProdutoService service;
    @Autowired
    private ProdutoRepository produtoRepository;

    @BeforeEach
    private void warmUp() {
        service = new ProdutoService(produtoRepository);
    }

    @Test
    public void criacaoProdutoSucesso() {
        ProdutoRequest request = new ProdutoRequest();
        request.setNome("Mario");
        request.setTipoMidia(TipoMidia.valueOf("FISICA"));
        request.setValor(BigDecimal.valueOf(150.99));
        request.setDescricao("Jogo Mario nintendo 64");
        request.setPlataforma("nintendo 64");


        ProdutoEntity entity = service.criaNovoProduto(request);

        Assert.notNull(entity,"Entity nula");
        Assert.isTrue(entity.getNome().equals(request.getNome()), "Nome diferente do informado");
    }


}
