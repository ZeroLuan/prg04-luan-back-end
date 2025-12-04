package br.com.movefisio.prg04_luan_back_end.usuarioCRUD.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {
    private String nomeCompleto;
    private String email;
    private String telefone;
}

