package br.com.oversight.zgProjeto.api.security;

import lombok.Data;

@Data
class JwtLoginInput {
    private String username;
    private String password;
}