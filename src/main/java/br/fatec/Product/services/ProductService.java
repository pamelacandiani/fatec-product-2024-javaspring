package br.fatec.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.product.entities.Product;
import br.fatec.product.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired  
    private ProductRepository repository;

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

}
