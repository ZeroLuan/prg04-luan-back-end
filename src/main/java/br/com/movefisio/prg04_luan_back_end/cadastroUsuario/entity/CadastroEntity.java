package br.com.movefisio.prg04_luan_back_end.cadastroUsuario.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "cadastro")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CadastroEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    String nome;

    @Column(name = "email")
    String email;

    @Column(name = "senha")
    String senha;

}
