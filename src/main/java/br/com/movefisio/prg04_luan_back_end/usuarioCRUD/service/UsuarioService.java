package br.com.movefisio.prg04_luan_back_end.usuarioCRUD.service;

import br.com.movefisio.prg04_luan_back_end.usuarioCRUD.dto.UsuarioRequest;
import br.com.movefisio.prg04_luan_back_end.usuarioCRUD.dto.UsuarioResponse;
import br.com.movefisio.prg04_luan_back_end.usuarioCRUD.entity.UsuarioEntity;
import br.com.movefisio.prg04_luan_back_end.usuarioCRUD.mapper.ToEntityUsuario;
import br.com.movefisio.prg04_luan_back_end.usuarioCRUD.mapper.ToResponseUsuario;
import br.com.movefisio.prg04_luan_back_end.usuarioCRUD.repository.UsuarioRepository;
import br.com.movefisio.prg04_luan_back_end.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ToEntityUsuario toEntityUsuario;

    @Autowired
    private ToResponseUsuario toResponseUsuario;

    public UsuarioResponse criar(UsuarioRequest request) {
        UsuarioEntity entity = toEntityUsuario.convert(request);
        UsuarioEntity saved = usuarioRepository.save(entity);
        return toResponseUsuario.convert(saved);
    }

    public Page<UsuarioResponse> listarTodos(Pageable pageable) {
        Page<UsuarioEntity> page = usuarioRepository.findAll(pageable);
        List<UsuarioResponse> content = page.getContent()
                .stream()
                .map(toResponseUsuario::convert)
                .collect(Collectors.toList());
        return new PageImpl<>(content, pageable, page.getTotalElements());
    }

    public UsuarioResponse buscarPorId(Long id) {
        UsuarioEntity entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
        return toResponseUsuario.convert(entity);
    }

    public UsuarioResponse atualizar(Long id, UsuarioRequest request) {
        UsuarioEntity entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
        entity.setNomeCompleto(request.getNomeCompleto());
        entity.setEmail(request.getEmail());
        entity.setTelefone(request.getTelefone());
        UsuarioEntity updated = usuarioRepository.save(entity);
        return toResponseUsuario.convert(updated);
    }

    public void deletar(Long id) {
        UsuarioEntity entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
        usuarioRepository.delete(entity);
    }
}
