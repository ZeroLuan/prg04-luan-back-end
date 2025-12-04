package br.com.movefisio.prg04_luan_back_end.cadastroUsuario.mapper;

import br.com.movefisio.prg04_luan_back_end.cadastroUsuario.dto.CadastroResponse;
import br.com.movefisio.prg04_luan_back_end.cadastroUsuario.entity.CadastroEntity;
import org.springframework.stereotype.Component;

@Component
public class ToResponse {

    public CadastroResponse convert(CadastroEntity entity) {
        CadastroResponse response = new CadastroResponse();
        response.setId(entity.getId());
        response.setNome(entity.getNome());
        response.setEmail(entity.getEmail());
        return response;
    }

}
