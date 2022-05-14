package com.mjvdesafiofinal.ecommerce.repository;

import com.mjvdesafiofinal.ecommerce.model.usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long>, JpaSpecificationExecutor<UsuarioEntity> {
    Boolean existsByCpf(String cpf);
}
