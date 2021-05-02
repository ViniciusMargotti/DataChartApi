package br.com.viniciusmargotti.javaspringapi.repository;

import br.com.viniciusmargotti.javaspringapi.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Usuario findByEmail(String email);
}
