package br.com.viniciusmargotti.javaspringapi.repository;

import br.com.viniciusmargotti.javaspringapi.models.Grafico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraficoRepository extends JpaRepository<Grafico, Long>{
}
