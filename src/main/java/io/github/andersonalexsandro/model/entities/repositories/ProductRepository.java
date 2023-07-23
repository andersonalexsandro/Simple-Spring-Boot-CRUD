package io.github.andersonalexsandro.model.entities.repositories;

//import org.springframework.data.repository.CrudRepository;
//extends CrudRepository<Product, Integer>

import io.github.andersonalexsandro.model.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    public Iterable<Product> findByNameContainingIgnoreCase(String partNumber);

//    findByNameContaining
//    findByNameIsContaining
//    findByNameContains
//    findByNameStarsWith
//    findByNameEndsWith

//    @Query("Select p from Product p where p.name Like %:name%")
//    public Iterable<Product> searchByNameLike(@Param("name") String name);
}
