package br.com.alura.ramengo.controller;

import br.com.alura.ramengo.dto.OrderDTO;
import br.com.alura.ramengo.dto.OrderResponseDTO;
import br.com.alura.ramengo.exception.ErrorResponse;
import br.com.alura.ramengo.service.OrderService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> OrderRequest(@RequestBody OrderDTO dto) {
        try {
            // Chama o serviço para criar o pedido e retorna a resposta gerada
            OrderResponseDTO response = this.orderService.createOrder(dto);
            return ResponseEntity.ok(response);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Invalid data: " + e.getMessage()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(new ErrorResponse("An unexpected error occurred" + e.getMessage()));
        }
    }

}