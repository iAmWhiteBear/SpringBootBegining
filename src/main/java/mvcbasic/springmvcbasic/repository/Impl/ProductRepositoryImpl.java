package mvcbasic.springmvcbasic.repository.Impl;

import mvcbasic.springmvcbasic.domain.Product;
import mvcbasic.springmvcbasic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products = Arrays.asList(
            new Product(3,"testProduct",10),
            new Product(4,"prod2",11),
            new Product(5,"prod3",43),
            new Product(6,"testProduct4",65),
            new Product(7,"testProduct5",34),
            new Product(8,"testProduct6",21)
    );

    @Autowired
    public ProductRepositoryImpl() {
    }

    @Override
    public Optional<Product> getById(Integer id) {
        for (Product p: products) {
            if (p.getId().equals(id))
                return Optional.of(p);
        }
        return Optional.empty();
    }

    @Override
    public List<Product> getGroup() {
        return products;
    }

    @Override
    public void addProduct(Product prod) {
        ArrayList<Product> newList = new ArrayList<>();
        newList.addAll(products);
        newList.add(prod);
        products = newList;
    }
}
