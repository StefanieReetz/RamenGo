package br.com.alura.ramengo.dto;

import br.com.alura.ramengo.model.Protein;

public record OrderResponseDTO (
    String id,
    String description,
    String image
) {
    public OrderResponseDTO(String id, String description, String image) {
        this.id = id;
        this.description = description;
        this.image = image;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public String image() {
        return image;
    }
}
