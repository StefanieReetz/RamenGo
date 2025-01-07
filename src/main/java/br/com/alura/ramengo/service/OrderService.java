package br.com.alura.ramengo.service;

import br.com.alura.ramengo.dto.OrderDTO;
import br.com.alura.ramengo.dto.OrderResponseDTO;
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


    public OrderResponseDTO createOrder(OrderDTO dto) {
        Broth broth = brothRepository.findById(dto.getBrothId())
                .orElseThrow(() -> new RuntimeException("Broth not found"));

        Protein protein = proteinRepository.findById(dto.getProteinId())
                .orElseThrow(() -> new RuntimeException("Protein not found"));

        String description = broth.getName() + " and " + protein.getName() + " Ramen";

        return new OrderResponseDTO(
                "1234",
                description,
                broth.getImage()
        );
    }
}
