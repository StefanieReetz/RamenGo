package br.com.alura.ramengo.controller;

import br.com.alura.ramengo.dto.BrothDTO;
import br.com.alura.ramengo.dto.ProteinDTO;
import br.com.alura.ramengo.exception.ResourceNotFoundException;
import br.com.alura.ramengo.service.BrothService;
import br.com.alura.ramengo.service.ProteinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/broth")
public class BrothController {

    @Autowired
    private BrothService brothService;

    @GetMapping
    public ResponseEntity<List<BrothDTO>> listarBroths(){
        List<BrothDTO> broths = brothService.buscarBroths();
        if (broths.isEmpty()) {
            throw new ResourceNotFoundException("No broths found in the database.");
        }
        return ResponseEntity.ok(broths);
    }
}