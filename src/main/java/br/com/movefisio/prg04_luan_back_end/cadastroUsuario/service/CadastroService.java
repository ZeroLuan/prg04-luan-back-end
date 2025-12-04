package br.com.movefisio.prg04_luan_back_end.cadastroUsuario.service;

import br.com.movefisio.prg04_luan_back_end.cadastroUsuario.dto.CadastroRequest;
import br.com.movefisio.prg04_luan_back_end.cadastroUsuario.dto.CadastroResponse;
import br.com.movefisio.prg04_luan_back_end.cadastroUsuario.entity.CadastroEntity;
import br.com.movefisio.prg04_luan_back_end.cadastroUsuario.mapper.ToEntity;
import br.com.movefisio.prg04_luan_back_end.cadastroUsuario.mapper.ToResponse;
import br.com.movefisio.prg04_luan_back_end.cadastroUsuario.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    @Autowired
    CadastroRepository cadastroRepository;

    @Autowired
    ToEntity toEntity;

    @Autowired
    ToResponse toResponse;

    public CadastroResponse cadastrar(CadastroRequest cadastroRequest) {
        CadastroEntity entity = toEntity.convert(cadastroRequest);
        CadastroEntity savedEntity = cadastroRepository.save(entity);
        return toResponse.convert(savedEntity);
    }
}
