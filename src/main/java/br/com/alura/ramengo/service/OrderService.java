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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class OrderService {
    @Autowired
    private BrothRepository brothRepository;
    @Autowired
    private ProteinRepository proteinRepository;
    @Autowired
    private OrderRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    Long id;


    public OrderResponseDTO createOrder(OrderDTO dto) {

        Broth broth = brothRepository.getReferenceById(dto.brothId());

        Protein protein = proteinRepository.getReferenceById(dto.proteinId());

        Order order = new Order(broth,protein);
        Long externalId = generateExternalOrderId();
        order.setExternalId(externalId);
        this.id = repository.save(order).getId();

        String description = broth.getName() + " and " + protein.getName() + " Ramen";
        return new OrderResponseDTO(
                order.getExternalId(),
                description,
//              mudar?
                "https://tech.redventures.com.br/icons/ramen/ramenChasu.png"
        );

    }

    //gera o ID externo
    public Long generateExternalOrderId() {
        String endpoint = "https://api.tech.redventures.com.br/orders/generate-id";
        String apiKey = "ZtVdh8XQ2U8pWI2gmZ7f796Vh8GllXoN7mr0djNf";

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(endpoint, HttpMethod.POST, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();

            //
            Pattern pattern = Pattern.compile("\"orderId\":\"(\\d+)\"");
            Matcher matcher = pattern.matcher(responseBody);

            if (matcher.find()) {
                // Retorna o número como Long
                return Long.valueOf(matcher.group(1));
            } else {
                throw new RuntimeException("Formato inesperado na resposta: " + responseBody);
            }
        } else {
            throw new RuntimeException("Erro ao gerar ID externo: " + response.getStatusCode());
        }
    }

//    public Long generateExternalOrderId() {
//        String endpoint = "https://api.tech.redventures.com.br/orders/generate-id";
//        String apiKey = "ZtVdh8XQ2U8pWI2gmZ7f796Vh8GllXoN7mr0djNf";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("x-api-key", apiKey);
//
//        HttpEntity<Void> entity = new HttpEntity<>(headers);
//
//        ResponseEntity<Long> response = restTemplate.exchange(endpoint, HttpMethod.POST, entity, String.class);
//
//        if (response.getStatusCode().is2xxSuccessful()) {
//            return response.getBody();
//        } else {
//            throw new RuntimeException("Erro ao gerar ID externo: " + response.getStatusCode());
//        }
//    }
}
