package com.mjvdesafiofinal.ecommerce.controller;


import com.mjvdesafiofinal.ecommerce.model.usuario.UsuarioResponse;
import com.mjvdesafiofinal.ecommerce.model.usuario.UsuarioEntity;
import com.mjvdesafiofinal.ecommerce.model.usuario.UsuarioRequest;
import com.mjvdesafiofinal.ecommerce.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }



    @PostMapping()
    public ResponseEntity<UsuarioResponse> criaUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        usuarioService.checaTamanhoCpf(usuarioRequest.getCpf().trim().length());
        usuarioService.checaCpfCadastrado(usuarioRequest.getCpf());
        UsuarioResponse entity = new UsuarioResponse(usuarioService.criaNovoUsuario(usuarioRequest));
        return new ResponseEntity<>(entity,HttpStatus.CREATED);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponse> buscaUsuarioPorId(@PathVariable Long idUsuario) {
        UsuarioResponse response = new UsuarioResponse(usuarioService.buscaUsuarioPorId(idUsuario));

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> get(@RequestParam (name = "nome", required = false) String nome,
                                                     @RequestParam (name = "nomeUsuario", required = false)String nomeUsuario){
        UsuarioRequest filtros = new UsuarioRequest();
        filtros.setNome(nome);
        filtros.setNomeUsuario(nomeUsuario);
        List<UsuarioEntity> usuarios =usuarioService.buscaTodos(filtros);
        return new ResponseEntity<>(usuarios.stream().map(UsuarioResponse::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponse> deletaUsuario(@PathVariable Long idUsuario) {
        UsuarioEntity usuarioEntity = usuarioService.buscaUsuarioPorId(idUsuario);
        UsuarioResponse usuarioResponse = new UsuarioResponse(usuarioEntity);

        usuarioService.deletaUsuarioPorId(idUsuario);

        return ResponseEntity.ok(usuarioResponse);
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponse> atualizaUsuario(@PathVariable Long idUsuario,
                                                           @RequestBody UsuarioRequest usuarioRequest) {
        UsuarioEntity usuarioEntity = usuarioService.buscaUsuarioPorId(idUsuario);
        UsuarioEntity entityAtualizada = usuarioService.atualizaUsuario(usuarioEntity,usuarioRequest);
        usuarioService.salvaUsuarioEntity(entityAtualizada);
        UsuarioResponse response = new UsuarioResponse(entityAtualizada);

        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

}
