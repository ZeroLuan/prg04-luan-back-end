package br.com.movefisio.prg04_luan_back_end.email.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmailContatoDTO {

    private String nome;
    private String email;
    private String mensagem;

}
