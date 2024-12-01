package br.fatec.product.dto;

public record ProductResponse(
    Long id,
    String name,
    Double price,
    String category
) {
    
}
