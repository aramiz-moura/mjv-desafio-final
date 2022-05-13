package com.mjvdesafiofinal.usuario;

import com.mjvdesafiofinal.carrinho.CarrinhoEntity;
import com.mjvdesafiofinal.exception.ApiRequestException;
import com.mjvdesafiofinal.specification.UsuarioSpecifications;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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

    public UsuarioEntity buscaUsuarioPorId(Long id) {
        UsuarioEntity entity = usuarioRepository.getById(id);
        return entity;
    }

    public List<UsuarioEntity> buscaTodos(UsuarioRequest request) {
        return usuarioRepository.findAll(
                Specification.where(UsuarioSpecifications.nomeContem(request.getNome()))
        );
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
