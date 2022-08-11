package com.example.homework7.repository;

import com.example.homework7.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.deleted = true WHERE p.id= :productId")
    void softDelete(Integer productId);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.stock = p.stock - 1 WHERE p.id = :productId")
    void decrementStock(Integer productId);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.stock = p.stock + 1 WHERE p.id = :productId")
    void incrementStock(Integer productId);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.stock = :newStock WHERE p.id = :productId")
    void updateStock(Integer productId, Integer newStock);

}
