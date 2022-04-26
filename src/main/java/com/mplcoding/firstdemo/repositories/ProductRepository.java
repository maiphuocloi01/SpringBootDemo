package com.mplcoding.firstdemo.repositories;

import com.mplcoding.firstdemo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
