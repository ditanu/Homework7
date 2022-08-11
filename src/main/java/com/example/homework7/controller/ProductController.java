package com.example.homework7.controller;

import com.example.homework7.model.Product;
import com.example.homework7.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/allProductsEvenDeleted")
    public List<Product> getAllProductsEvenDeleted() {
        return productService.getAllProductsEvenDeleted();
    }

    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("softDelete/{id}")
    public void softDelete(@PathVariable("id") Integer productId) {
        productService.softDelete(productId);
    }

    @PutMapping("decrement/{id}")
    public void decrementStock(@PathVariable("id") Integer productId) {
        productService.decrementStock(productId);
    }

    @PutMapping("increment/{id}")
    public void incrementStock(@PathVariable("id") Integer productId) {
        productService.incrementStock(productId);
    }

    @PutMapping("changeStock/{id}/{stock}")
    public void updateStock(@PathVariable("id") Integer productId, @PathVariable("stock") Integer stock) {
        productService.updateStock(productId, stock);
    }
}
