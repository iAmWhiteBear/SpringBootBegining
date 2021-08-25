package mvcbasic.springmvcbasic.repository;

import mvcbasic.springmvcbasic.domain.Product;

import java.util.List;
import java.util.Optional;


public interface ProductRepository {

    Optional<Product> getById(Integer id);
    List<Product> getGroup();
    void addProduct(Product prod);
}
