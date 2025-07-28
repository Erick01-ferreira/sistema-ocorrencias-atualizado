package com.exemplo.ocorrencias.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Entidade JPA que representa um produto.
 */
@Entity(name = "product")
@Table(name = "product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    /**
     * Identificador único do produto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    /**
     * Nome do produto.
     */
    private String name;

    /**
     * Preço do produto (em centavos ou unidade inteira).
     */
    private Integer price;

    /**
     * Construtor que recebe um DTO de requisição para criar a entidade Product.
     *
     * @param data dados do produto recebidos via requisição.
     */
    public Product(ProductRequestDTO data) {
        this.name = data.name();
        this.price = data.price();
    }
}
