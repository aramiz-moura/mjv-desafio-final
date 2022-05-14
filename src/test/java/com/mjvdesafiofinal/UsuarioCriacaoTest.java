package com.mjvdesafiofinal;



import com.mjvdesafiofinal.ecommerce.model.usuario.UsuarioEntity;
import com.mjvdesafiofinal.ecommerce.repository.UsuarioRepository;
import com.mjvdesafiofinal.ecommerce.model.usuario.UsuarioRequest;
import com.mjvdesafiofinal.ecommerce.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;



@AutoConfigureTestDatabase
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioCriacaoTest {

    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    private void warmUp() {
        usuarioService = new UsuarioService(usuarioRepository);
    }

    @Test
    public void criacaoUsuarioSucesso(){
        UsuarioRequest request = new UsuarioRequest();
        request.setNome("Aramiz");
        request.setCpf("08327171441");
        request.setNomeUsuario("MJV");
        request.setEmail("email@email2.com");

        UsuarioEntity entity = usuarioService.criaNovoUsuario(request);
        Assert.notNull(entity, "Entity Nula");
        Assert.notNull(entity.getId(), "Id Nulo");
        Assert.isTrue(entity.getNome().equals(request.getNome()),"Nome diferente do informado");

    }
}
