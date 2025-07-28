package com.exemplo.ocorrencias.repositories;

import com.exemplo.ocorrencias.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
