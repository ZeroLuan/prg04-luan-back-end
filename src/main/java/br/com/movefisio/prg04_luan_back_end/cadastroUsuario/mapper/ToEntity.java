package br.com.movefisio.prg04_luan_back_end.cadastroUsuario.mapper;

import br.com.movefisio.prg04_luan_back_end.cadastroUsuario.dto.CadastroRequest;
import br.com.movefisio.prg04_luan_back_end.cadastroUsuario.entity.CadastroEntity;
import org.springframework.stereotype.Component;

@Component
public class ToEntity {

    public CadastroEntity convert(CadastroRequest request) {
        CadastroEntity entity = new CadastroEntity();
        entity.setNome(request.getNome());
        entity.setEmail(request.getEmail());
        entity.setSenha(request.getSenha());
        return entity;
    }

}
