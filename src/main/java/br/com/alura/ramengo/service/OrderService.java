package br.com.alura.ramengo.service;

import br.com.alura.ramengo.dto.OrderDTO;
import br.com.alura.ramengo.dto.OrderResponseDTO;
import br.com.alura.ramengo.dto.ProteinDTO;
import br.com.alura.ramengo.model.Broth;
import br.com.alura.ramengo.model.Order;
import br.com.alura.ramengo.model.Protein;
import br.com.alura.ramengo.repository.BrothRepository;
import br.com.alura.ramengo.repository.OrderRepository;
import br.com.alura.ramengo.repository.ProteinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    @Autowired
    private BrothRepository brothRepository;
    @Autowired
    private ProteinRepository proteinRepository;
    @Autowired
    private OrderRepository repository;
    Long id;

    public Long getId() {
        return id;
    }

    public OrderResponseDTO createOrder(OrderDTO dto) {
        Broth broth = brothRepository.getReferenceById(dto.brothId());

        Protein protein = proteinRepository.getReferenceById(dto.proteinId());
            Order order = new Order(broth, protein);

        String description = broth.getName() + " and " + protein.getName() + " Ramen";
        this.id = repository.save(order).getId();
        return new OrderResponseDTO(
                this.getId(),
                description,
                broth.getImage()
        );

    }
}
