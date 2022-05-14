package com.mjvdesafiofinal.ecommerce.model.usuario;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    private String nomeUsuario;
    private String nome;
    private String email;
    private String cpf;
}
