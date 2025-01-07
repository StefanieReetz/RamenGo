package br.com.alura.ramengo.repository;

import br.com.alura.ramengo.model.Broth;
import br.com.alura.ramengo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
