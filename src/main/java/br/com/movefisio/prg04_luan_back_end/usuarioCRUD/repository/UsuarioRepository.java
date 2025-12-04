package br.com.movefisio.prg04_luan_back_end.usuarioCRUD.repository;

import br.com.movefisio.prg04_luan_back_end.usuarioCRUD.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}

