package br.fatec.product.dto;

public record ProductRequest(
    String name,
    Double price,
    String category
) {
    
}
