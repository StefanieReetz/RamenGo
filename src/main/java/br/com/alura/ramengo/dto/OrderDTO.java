package br.com.alura.ramengo.dto;

import org.antlr.v4.runtime.misc.NotNull;

public record OrderDTO(

                       @NotNull
                       Long brothId,
                       @NotNull
                       Long proteinId) {

}