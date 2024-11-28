package br.fatec.Product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.Product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{    
}
