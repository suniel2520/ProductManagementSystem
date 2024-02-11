package com.ecommerce.dto;

import lombok.Data;

/**
 * The type Product response dto.
 */
@Data
public class ProductResponseDTO {

    private ProductDTO productDTO;

    private boolean success;

    private String message;

    @Override
    public String toString() {
        return "ProductResponseDTO{" +
                "productDTO=" + productDTO +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
