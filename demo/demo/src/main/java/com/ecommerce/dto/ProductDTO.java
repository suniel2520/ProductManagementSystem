package com.ecommerce.dto;

import lombok.Data;

/**
 * The type Product dto.
 */
@Data
public class ProductDTO {

    private Long id;

    private String name;

    private String description;

    private Float price;

    private Integer quantityAvailable;

    private float discountPercentage;

    private float taxRate;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantityAvailable=" + quantityAvailable +
                '}';
    }
}
