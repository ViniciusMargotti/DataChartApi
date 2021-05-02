package br.com.viniciusmargotti.javaspringapi.repository;

import br.com.viniciusmargotti.javaspringapi.models.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BairroRepository extends JpaRepository<Bairro, Long>{
    List<Bairro> findByCidadeId(Long cidadeId);
}
