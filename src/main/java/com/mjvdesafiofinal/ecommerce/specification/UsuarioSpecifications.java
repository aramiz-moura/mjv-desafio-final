package com.mjvdesafiofinal.ecommerce.specification;


import com.mjvdesafiofinal.ecommerce.model.usuario.UsuarioEntity;
import org.springframework.data.jpa.domain.Specification;

public class UsuarioSpecifications {
    public static Specification<UsuarioEntity> nomeContem (String nome) {
        return nome == null ? null: (usuarioEntity, cq,cb) -> cb.like(usuarioEntity.get("nome"), "%" + nome + "%");
    }

    public static Specification<UsuarioEntity> nomeUsuarioContem(String nomeUsuario) {
        return nomeUsuario == null ? null: (usuarioEntity, cq,cb) -> cb.like(usuarioEntity.get("nomeUsuario"), "%" + nomeUsuario + "%");
    }
}
