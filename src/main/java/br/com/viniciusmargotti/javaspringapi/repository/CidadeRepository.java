package br.com.viniciusmargotti.javaspringapi.repository;

import br.com.viniciusmargotti.javaspringapi.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
    List<Cidade> findByEstadoId(Long estadoId);
}
