package br.fatec.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.product.entities.Product;
import br.fatec.product.services.ProductService;

@RestController
@RequestMapping("products")

public class ProductController {
    
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getProducts(){
        return service.getAllProducts();
    } 

    @GetMapping("{id}")
    public Product getProducts(@PathVariable Long id){
        return service.getProductById(id);
    }


}
