package com.ecommerce.service;


import com.ecommerce.dto.ProductDTO;
import com.ecommerce.dto.ProductResponseDTO;

/**
 * The interface Product service.
 */
public interface ProductService {

    /**
     * Create product product response dto.
     *
     * @param productDTO the product dto
     * @return the product response dto
     */
    ProductResponseDTO createProduct(ProductDTO productDTO);

    /**
     * Read product product response dto.
     *
     * @param productDTO the product dto
     * @return the product response dto
     */
    ProductResponseDTO readProduct(ProductDTO productDTO);

    /**
     * Update product product response dto.
     *
     * @param productDTO the product dto
     * @return the product response dto
     */
    ProductResponseDTO updateProduct(ProductDTO productDTO);

    /**
     * Delete product product response dto.
     *
     * @param productDTO the product dto
     * @return the product response dto
     */
    ProductResponseDTO deleteProduct(ProductDTO productDTO);

    /**
     * Apply discount percentage or tax rate product response dto.
     *
     * @param productDTO the product dto
     * @return the product response dto
     */
    ProductResponseDTO applyDiscountPercentageOrTaxRate(ProductDTO productDTO);
}
