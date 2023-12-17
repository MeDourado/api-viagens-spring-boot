package com.vslviagens.vslviagensapi.dto;

import com.vslviagens.vslviagensapi.model.UsuariosRole;

public record RegistroUsuarioDTO(String nome, String email, String senha, UsuariosRole cargo) {

}
