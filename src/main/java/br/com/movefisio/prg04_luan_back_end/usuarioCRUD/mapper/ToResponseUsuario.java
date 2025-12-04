package br.com.movefisio.prg04_luan_back_end.usuarioCRUD.mapper;

import br.com.movefisio.prg04_luan_back_end.usuarioCRUD.dto.UsuarioResponse;
import br.com.movefisio.prg04_luan_back_end.usuarioCRUD.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class ToResponseUsuario {

    public UsuarioResponse convert(UsuarioEntity entity) {
        UsuarioResponse response = new UsuarioResponse();
        response.setId(entity.getId());
        response.setNomeCompleto(entity.getNomeCompleto());
        response.setEmail(entity.getEmail());
        response.setTelefone(entity.getTelefone());
        return response;
    }
}

