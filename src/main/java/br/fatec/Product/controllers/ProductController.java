package br.fatec.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.product.dto.ProductRequest;
import br.fatec.product.dto.ProductResponse;
import br.fatec.product.services.ProductService;

@RestController
@RequestMapping("products")

public class ProductController {
    
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity <List<ProductResponse>> getProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    } 

    @GetMapping("{id}")
    public ResponseEntity <ProductResponse> getProducts(@PathVariable Long id){
        return ResponseEntity.ok(service.getProductById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductRequest product){
        ProductResponse newProduct = service.save(product);
        return ResponseEntity.created(null).body(newProduct);
    }
     
    @PutMapping("{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable long id, @RequestBody ProductRequest product){
        service.update(product, id);
        return ResponseEntity.ok().build();
    }

   
}
