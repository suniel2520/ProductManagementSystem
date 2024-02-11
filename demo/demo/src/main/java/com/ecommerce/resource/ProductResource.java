package com.ecommerce.resource;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.dto.ProductResponseDTO;
import com.ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Product resource.
 */
@RestController
@RequestMapping("/api/ecommerce")
@Slf4j
public class ProductResource {

    @Autowired
    private ProductService productService;

    /**
     * Create product response entity.
     *
     * @param productDTO the product dto
     * @return the response entity
     */
    @PostMapping("/create-product")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDTO) {

        log.debug("Rest request to create product with product details : {} ", productDTO);
        return ResponseEntity.ok().body(this.productService.createProduct(productDTO));

    }

    /**
     * Read product response entity.
     *
     * @param productDTO the product dto
     * @return the response entity
     */
    @GetMapping("/get-product")
    public ResponseEntity<ProductResponseDTO> readProduct(@RequestBody ProductDTO productDTO) {

        log.debug("Rest request to read product for product id : {} ", productDTO.getId());
        return ResponseEntity.ok().body(this.productService.readProduct(productDTO));
    }

    /**
     * Update product response entity.
     *
     * @param productDTO the product dto
     * @return the response entity
     */
    @PutMapping("/update-product")
    public ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody ProductDTO productDTO) {

        log.debug("Rest request to update product with product details : {} ", productDTO);
        return ResponseEntity.ok().body(this.productService.updateProduct(productDTO));
    }

    /**
     * Delete product response entity.
     *
     * @param productDTO the product dto
     * @return the response entity
     */
    @DeleteMapping("/delete-product")
    public ResponseEntity<ProductResponseDTO> deleteProduct(@RequestBody ProductDTO productDTO) {

        log.debug("Rest request to delete product for product id : {} ", productDTO.getId());
        return ResponseEntity.ok().body(this.productService.deleteProduct(productDTO));
    }

    /**
     * Apply discount percentage or tax rate response entity.
     *
     * @param productDTO the product dto
     * @return the response entity
     */

    @PutMapping("/product/apply-tax-or-discount")
    public ResponseEntity<ProductResponseDTO> applyDiscountPercentageOrTaxRate(@RequestBody ProductDTO productDTO) {

        log.debug("Rest request to apply discount or tax on product with details : {} ", productDTO);
        return ResponseEntity.ok().body(this.productService.applyDiscountPercentageOrTaxRate(productDTO));
    }
}
