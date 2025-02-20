package br.com.alura.ramengo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderResponseDTO (
    @NotNull
    Long id,
    @NotBlank
    String description,
    String image
) {
    public OrderResponseDTO(Long id, String description, String image) {
        // esse id devolve certo
        this.id = id;
        this.description = description;
        this.image = image;
    }


    public Long getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }


    public String getImage() {
        return image;
    }
}
