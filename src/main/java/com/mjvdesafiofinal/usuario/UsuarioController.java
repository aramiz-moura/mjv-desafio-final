package com.mjvdesafiofinal.usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<UsuarioResponse> criaUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        UsuarioResponse entity = new UsuarioResponse(usuarioService.criaNovoUsuario(usuarioRequest));
        return new ResponseEntity<>(entity,HttpStatus.CREATED);
    }
}
