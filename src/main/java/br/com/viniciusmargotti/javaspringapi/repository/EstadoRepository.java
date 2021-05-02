package br.com.viniciusmargotti.javaspringapi.repository;

import br.com.viniciusmargotti.javaspringapi.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
}
