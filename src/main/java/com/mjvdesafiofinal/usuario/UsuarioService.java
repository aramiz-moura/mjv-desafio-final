package com.mjvdesafiofinal.usuario;

import com.mjvdesafiofinal.carrinho.CarrinhoEntity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Data
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    public UsuarioEntity criaNovoUsuario(UsuarioRequest usuarioRequest) {
        UsuarioEntity entity = toEntity(usuarioRequest);
        return usuarioRepository.save(entity);
    }

    public UsuarioEntity buscaUsuarioPorId(Long id) {
        UsuarioEntity entity = usuarioRepository.getById(id);
        return entity;
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
