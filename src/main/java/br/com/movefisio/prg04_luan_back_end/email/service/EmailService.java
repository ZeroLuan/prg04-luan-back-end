package br.com.movefisio.prg04_luan_back_end.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.mail.destino}")
    private String emailDestino;

    public void enviarMensagem(String nome, String email, String mensagem) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(emailDestino);
        mail.setSubject("Mensagem recebida pelo site - " + nome);

        String conteudo = """
                Nome: %s
                Email: %s
                
                Mensagem:
                %s
                """.formatted(nome, email, mensagem);

        mail.setText(conteudo);

        mailSender.send(mail);
    }
}
