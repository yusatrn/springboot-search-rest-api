package net.white.springbootsearchrestapi.service;

import net.white.springbootsearchrestapi.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
