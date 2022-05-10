package com.mjvdesafiofinal.usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponse> buscaUsuarioPorId(@PathVariable Long idUsuario) {
        UsuarioResponse response = new UsuarioResponse(usuarioService.buscaUsuarioPorId(idUsuario));

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
