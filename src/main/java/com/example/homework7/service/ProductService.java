package com.example.homework7.service;

import com.example.homework7.model.Product;
import com.example.homework7.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProductsEvenDeleted() {
        return productRepository.findAll();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getDeleted() == false)
                .collect(Collectors.toList());
    }

    public void softDelete(Integer productId) {
        productRepository.softDelete(productId);
    }

    public void decrementStock(Integer productId) {
        productRepository.decrementStock(productId);
    }

    public void incrementStock(Integer productId) {
        productRepository.incrementStock(productId);
    }

    public void updateStock(Integer productId, Integer stock) {
        productRepository.updateStock(productId, stock);
    }

}
