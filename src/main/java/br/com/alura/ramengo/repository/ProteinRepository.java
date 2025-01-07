package br.com.alura.ramengo.repository;

import br.com.alura.ramengo.model.Protein;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProteinRepository extends JpaRepository<Protein,Long> {
}
