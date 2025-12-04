package br.com.movefisio.prg04_luan_back_end.usuarioCRUD.mapper;

import br.com.movefisio.prg04_luan_back_end.usuarioCRUD.dto.UsuarioRequest;
import br.com.movefisio.prg04_luan_back_end.usuarioCRUD.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class ToEntityUsuario {

    public UsuarioEntity convert(UsuarioRequest request) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setNomeCompleto(request.getNomeCompleto());
        entity.setEmail(request.getEmail());
        entity.setTelefone(request.getTelefone());
        return entity;
    }
}

