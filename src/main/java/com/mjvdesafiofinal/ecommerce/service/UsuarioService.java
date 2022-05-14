package com.mjvdesafiofinal.ecommerce.service;

import com.mjvdesafiofinal.ecommerce.exception.ApiRequestException;
import com.mjvdesafiofinal.ecommerce.model.carrinho.CarrinhoEntity;
import com.mjvdesafiofinal.ecommerce.model.usuario.UsuarioEntity;
import com.mjvdesafiofinal.ecommerce.model.usuario.UsuarioRequest;
import com.mjvdesafiofinal.ecommerce.repository.UsuarioRepository;
import com.mjvdesafiofinal.ecommerce.exception.NotFoundException;
import com.mjvdesafiofinal.ecommerce.specification.UsuarioSpecifications;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;


@Service
@Data
public class UsuarioService {

    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }



    public UsuarioEntity criaNovoUsuario(UsuarioRequest usuarioRequest) {
        UsuarioEntity entity = toEntity(usuarioRequest);
        return usuarioRepository.save(entity);
    }

    public void salvaUsuarioEntity(UsuarioEntity usuarioEntity) {
        usuarioRepository.save(usuarioEntity);
    }

    public UsuarioEntity buscaUsuarioPorId(Long id) {
        //UsuarioEntity entity = usuarioRepository.getById(id);
        return usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
    }

    public List<UsuarioEntity> buscaTodos(UsuarioRequest request) {
        return usuarioRepository.findAll(
                Specification.where(UsuarioSpecifications.nomeContem(request.getNome()))
                        .and(UsuarioSpecifications.nomeUsuarioContem(request.getNomeUsuario()))
        );
    }

    public UsuarioEntity atualizaUsuario(UsuarioEntity usuarioEntity, UsuarioRequest request) {
        usuarioEntity.setNome(request.getNome());
        usuarioEntity.setNomeUsuario(request.getNomeUsuario());
        usuarioEntity.setEmail(request.getEmail());
        usuarioEntity.setCpf(request.getCpf());
        usuarioEntity.setDataAtualizacao(ZonedDateTime.now());
        return usuarioEntity;
    }

    public void deletaUsuarioPorId(Long id) {
        usuarioRepository.deleteById(id);
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

    public  Boolean checaCpfCadastrado(String cpf) {
        if(usuarioRepository.existsByCpf(cpf)){
            throw new ApiRequestException("Oooops! CPF já cadastrado! Por favor, informe outro CPF");
        }
        return false;
    }

    public Boolean checaTamanhoCpf(Integer cpfLength) {
        if(cpfLength != 11) {
            throw new ApiRequestException("Oooops! CPF PRECISA ter 11 dígitos. Por favor, informe novo CPF com apenas dígitos");
        }
        return false;
    }


}
