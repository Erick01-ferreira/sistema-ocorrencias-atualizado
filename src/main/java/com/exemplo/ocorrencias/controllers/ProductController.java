package com.exemplo.ocorrencias.controllers;

import com.exemplo.ocorrencias.domain.product.Product;
import com.exemplo.ocorrencias.domain.product.ProductResponseDTO;
import com.exemplo.ocorrencias.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.exemplo.ocorrencias.domain.product.ProductRequestDTO;

import java.util.List;

/**
 * Controlador REST responsável por gerenciar produtos.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    /**
     * Endpoint para registrar um novo produto.
     *
     * @param body DTO contendo os dados do novo produto.
     * @return HTTP 200 OK em caso de sucesso.
     */
    @PostMapping
    public ResponseEntity<Void> postProduct(@RequestBody @Valid ProductRequestDTO body) {
        Product newProduct = new Product(body);
        repository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint para listar todos os produtos cadastrados.
     *
     * @return Lista de produtos no formato ProductResponseDTO.
     */
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<ProductResponseDTO> productList = repository.findAll()
                .stream()
                .map(ProductResponseDTO::new)
                .toList();

        return ResponseEntity.ok(productList);
    }
}
