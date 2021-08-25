package mvcbasic.springmvcbasic.service.impl;

import mvcbasic.springmvcbasic.domain.Product;
import mvcbasic.springmvcbasic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mvcbasic.springmvcbasic.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository repo;

    @Autowired
    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Product> productGetById(Integer id) {
        return repo.getById(id);
    }

    @Override
    public List<Product> productGetAll() {
        return repo.getGroup();
    }

    @Override
    public void addProduct(Product prod) {
        repo.addProduct(prod);
    }
}
