package br.com.alura.ramengo.service;

import br.com.alura.ramengo.dto.BrothDTO;
import br.com.alura.ramengo.dto.ProteinDTO;
import br.com.alura.ramengo.repository.BrothRepository;
import br.com.alura.ramengo.repository.ProteinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrothService {
    @Autowired
    private BrothRepository repository;

    public List<BrothDTO> buscarBroths() {
        return repository
                .findAll()
                .stream()
                .map(BrothDTO::new)
                .toList();
    }
}