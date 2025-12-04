package br.com.movefisio.prg04_luan_back_end.usuarioCRUD.controller;

import br.com.movefisio.prg04_luan_back_end.usuarioCRUD.dto.UsuarioRequest;
import br.com.movefisio.prg04_luan_back_end.usuarioCRUD.dto.UsuarioResponse;
import br.com.movefisio.prg04_luan_back_end.usuarioCRUD.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/criar")
    public ResponseEntity<UsuarioResponse> criar(@RequestBody UsuarioRequest request) {
        UsuarioResponse response = usuarioService.criar(request);
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/listar")
    public ResponseEntity<Page<UsuarioResponse>> listarTodos(Pageable pageable) {
        Page<UsuarioResponse> result = usuarioService.listarTodos(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UsuarioResponse> atualizar(@PathVariable Long id, @RequestBody UsuarioRequest request) {
        return ResponseEntity.ok(usuarioService.atualizar(id, request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
