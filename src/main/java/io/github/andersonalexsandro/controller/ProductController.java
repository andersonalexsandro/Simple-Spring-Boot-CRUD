package io.github.andersonalexsandro.controller;

import io.github.andersonalexsandro.model.entities.Product;
import io.github.andersonalexsandro.model.entities.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    EntityManager entityManager;

    @PostMapping("/create")
    public @ResponseBody Product createProduct(@Valid Product product){
        productRepository.save(product);
        return product;
    }

    @GetMapping("/findAll")
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    @GetMapping(path = "/findAll/{page}")
    public Iterable<Product> findPages(int page){
        Pageable pageable = PageRequest.of(0, page);
        return productRepository.findAll(pageable);
    }

    @GetMapping(path = "/find/containing/{parcialName}")
    public Iterable<Product> findContaining(String parcialName){
        return productRepository.findByNameContainingIgnoreCase(parcialName);
    }

    @GetMapping("/getById")
    public Optional<Product> getById(@RequestParam int id){
        return productRepository.findById(id);
    }

    @PutMapping("/alterProduct")
    public Product alterProduct(@Valid Product product){
        productRepository.save(product);
        return product;
    }

    //study soft delete
    @DeleteMapping(path = "/delete/{id}")
    public void deleteProductById(@PathVariable int id){
        productRepository.deleteById(id);
    }

}
