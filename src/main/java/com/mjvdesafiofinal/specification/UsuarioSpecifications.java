package com.mjvdesafiofinal.specification;


import com.mjvdesafiofinal.usuario.UsuarioEntity;
import org.springframework.data.jpa.domain.Specification;

public class UsuarioSpecifications {
    public static Specification<UsuarioEntity> nomeContem (String nome) {
        return nome == null ? null: (usuarioEntity, cq,cb) -> cb.like(usuarioEntity.get("nome"), "%" + nome + "%");
    }
}
