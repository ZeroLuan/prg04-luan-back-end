package br.com.movefisio.prg04_luan_back_end.email.controller;

import br.com.movefisio.prg04_luan_back_end.email.dto.EmailContatoDTO;
import br.com.movefisio.prg04_luan_back_end.email.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/contato")
public class EmailContatoController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> enviarMensagem(@RequestBody EmailContatoDTO dto) {
        log.info("Recebendo mensagem de contato:");
        emailService.enviarMensagem(dto.getNome(), dto.getEmail(), dto.getMensagem());
        return ResponseEntity.ok("Mensagem enviada com sucesso!");
    }
}