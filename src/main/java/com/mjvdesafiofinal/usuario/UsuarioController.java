package com.mjvdesafiofinal.usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<UsuarioResponse> criaUsuario(UsuarioRequest usuarioRequest) {

    }
}
