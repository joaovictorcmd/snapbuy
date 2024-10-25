package com.joaovictorcmd.snapbuy.snapbuy.repositories;

import com.joaovictorcmd.snapbuy.snapbuy.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author joaovictorcmd
 * @date 2024 Oct 24
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
