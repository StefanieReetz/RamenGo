package br.com.alura.ramengo.service;

import br.com.alura.ramengo.dto.ProteinDTO;
import br.com.alura.ramengo.repository.ProteinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProteinService {
    @Autowired
    private ProteinRepository repository;

    public List<ProteinDTO> buscarProteinas() {
        return repository
                .findAll()
                .stream()
                .map(ProteinDTO::new)
                .toList();
    }
}
