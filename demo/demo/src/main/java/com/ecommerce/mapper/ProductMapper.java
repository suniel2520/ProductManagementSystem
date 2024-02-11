package com.ecommerce.mapper;

import com.ecommerce.domain.Product;
import com.ecommerce.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The type Product mapper.
 */
@Slf4j
@Component
public class ProductMapper {

    /**
     * To entity product.
     *
     * @param productDTO the product dto
     * @return the product
     */
    public Product toEntity(ProductDTO productDTO) {

        log.debug("Attempting to map product dto to product entity with given details : {} ", productDTO);
        Product product = new Product();

        product.setName(productDTO.getName() != null ? productDTO.getName() : "");
        product.setDescription(productDTO.getDescription() != null ? productDTO.getDescription() : "");
        product.setPrice(productDTO.getPrice() != null ? productDTO.getPrice() : 0f);
        product.setQuantityAvailable(productDTO.getQuantityAvailable() != null ? productDTO.getQuantityAvailable() : 0);

        return product;
    }

    /**
     * To dto product dto.
     *
     * @param product the product
     * @return the product dto
     */
    public ProductDTO toDTO(Product product) {

        log.debug("Attempting to map product entity to product dto with given details : {} ", product);
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantityAvailable(product.getQuantityAvailable());

        return productDTO;
    }
}
