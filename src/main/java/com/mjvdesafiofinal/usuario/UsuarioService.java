package com.mjvdesafiofinal.usuario;

import com.mjvdesafiofinal.carrinho.CarrinhoEntity;
import com.mjvdesafiofinal.produto.ProdutoEntity;
import com.mjvdesafiofinal.produto.ProdutoRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Data
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    public UsuarioEntity criaNovoUsuario(UsuarioRequest usuarioRequest) {
        UsuarioEntity entity = toEntity(usuarioRequest);
        return usuarioRepository.save(entity);
    }


    public UsuarioEntity toEntity(UsuarioRequest request) {
        return new UsuarioEntity(
                request.getNome(),
                request.getNomeUsuario(),
                request.getEmail(),
                request.getCpf(),
                new CarrinhoEntity()
        );
    }
}
