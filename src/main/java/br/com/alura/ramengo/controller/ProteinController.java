package br.com.alura.ramengo.controller;

import br.com.alura.ramengo.dto.ProteinDTO;
import br.com.alura.ramengo.service.ProteinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proteins")
public class ProteinController {

    @Autowired
    private ProteinService proteinService;

    @GetMapping
    public ResponseEntity<List<ProteinDTO>> listarProteinas(){
        List<ProteinDTO> proteinas = proteinService.buscarProteinas();
        return ResponseEntity.ok(proteinas);
    }

}
