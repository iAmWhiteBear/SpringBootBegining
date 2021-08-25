package mvcbasic.springmvcbasic.service;

import mvcbasic.springmvcbasic.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> productGetById(Integer id);
    List<Product> productGetAll();
    void addProduct(Product prod);
}
