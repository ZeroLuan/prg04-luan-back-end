package br.com.movefisio.prg04_luan_back_end.cadastroUsuario.repository;

import br.com.movefisio.prg04_luan_back_end.cadastroUsuario.entity.CadastroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<CadastroEntity,Long> {


}
