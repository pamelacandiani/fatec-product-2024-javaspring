package br.fatec.product.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.product.dto.ProductRequest;
import br.fatec.product.dto.ProductResponse;
import br.fatec.product.entities.Product;
import br.fatec.product.mappers.ProductMapper;
import br.fatec.product.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
    
    @Autowired  
    private ProductRepository repository;

    public List<ProductResponse> getAllProducts(){
        return repository.findAll().stream().map(p -> ProductMapper.toDTO(p)).collect(Collectors.toList());
    }

    public ProductResponse getProductById(Long id){
        Product product = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Produto não cadastrado")
        );

        return ProductMapper.toDTO(product);
    }

    public void delete(Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Produto não cadastrado");
        }
    }

    public ProductResponse save(ProductRequest product){
        Product newProduct = repository.save(ProductMapper.toEntity(product));
        return ProductMapper.toDTO(newProduct);
    }
    
    public void update(ProductRequest product, long id){
        Product aux = repository.getReferenceById(id);

        aux.setCategory(product.category());
        aux.setName(product.name());
        aux.setPrice(product.price());

        repository.save(aux);
    }

}
