package br.com.alura.ramengo.dto;

import br.com.alura.ramengo.model.Broth;
import br.com.alura.ramengo.model.Protein;

public record BrothDTO(Long id, String image, String name, String description, Integer price) {
    public BrothDTO(Broth broth) {
        this(broth.getId(), broth.getImage(), broth.getName(), broth.getDescription(), broth.getPrice());
    }
}

