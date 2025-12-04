package br.com.movefisio.prg04_luan_back_end.cadastroUsuario.controller;


import br.com.movefisio.prg04_luan_back_end.cadastroUsuario.dto.CadastroRequest;
import br.com.movefisio.prg04_luan_back_end.cadastroUsuario.dto.CadastroResponse;
import br.com.movefisio.prg04_luan_back_end.cadastroUsuario.service.CadastroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/cadastro")
public class CadastroController {

    @Autowired
    CadastroService cadastroService;

    @PostMapping(path = "/cadastrar")
    public ResponseEntity<CadastroResponse> cadastrar(@RequestBody CadastroRequest cadastroRequest){
        return ResponseEntity.ok(cadastroService.cadastrar(cadastroRequest));
    }

    // Possui apenas o EndPoint de cadastro
    // Apenas com objetivo de demosntrar a conexao e funcionalidade de uma api rest

}
