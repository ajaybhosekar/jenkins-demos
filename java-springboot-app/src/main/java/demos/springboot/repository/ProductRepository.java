package demos.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import demos.springboot.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
