package com.ecommerce.service.impl;

import com.ecommerce.domain.Product;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.dto.ProductResponseDTO;
import com.ecommerce.mapper.ProductMapper;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Product service.
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponseDTO createProduct(ProductDTO productDTO) {

        log.debug("Attempting to create product");
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        Product product = this.productMapper.toEntity(productDTO);
        try {
            product = this.productRepository.save(product);
            responseDTO.setSuccess(true);
            responseDTO.setMessage("Product created successfully");
            responseDTO.setProductDTO(this.productMapper.toDTO(product));
        } catch (Exception e) {
            // error creating product
            responseDTO.setSuccess(false);
            responseDTO.setMessage("Error creating product " + e.getMessage());
            responseDTO.setProductDTO(null);
        }

        return responseDTO;
    }

    @Override
    public ProductResponseDTO readProduct(ProductDTO productDTO) {

        log.debug("Attempting to get product details for id : {} ", productDTO.getId());
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        if(productDTO.getId() != null) {
            Optional<Product> productFromDB = this.productRepository.findById(productDTO.getId());

            if(productFromDB.isPresent()) {
                var product = productFromDB.get();
                responseDTO.setSuccess(true);
                responseDTO.setMessage("Product retrieved successfully");
                responseDTO.setProductDTO(this.productMapper.toDTO(product));
            }
            else {
                // product does not exist with given id
                responseDTO.setSuccess(false);
                responseDTO.setMessage("Product not found with given product id : " + productDTO.getId() + ". Please check the id and try again.");
                responseDTO.setProductDTO(null);
            }
        }
        else {
            // please provide id of the product
            responseDTO.setSuccess(false);
            responseDTO.setMessage("Invalid request. Please provide a valid product ID.");
            responseDTO.setProductDTO(null);
        }

        return responseDTO;
    }

    @Override
    public ProductResponseDTO updateProduct(ProductDTO productDTO) {

        log.debug("Attempting to update product");
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        if(productDTO.getId() != null) {
            Optional<Product> productFromDB = this.productRepository.findById(productDTO.getId());

            if(productFromDB.isPresent()) {
                var product = productFromDB.get();

                product.setName(productDTO.getName() != null ? productDTO.getName() : "");
                product.setDescription(productDTO.getDescription() != null ? productDTO.getDescription() : "");
                product.setPrice(productDTO.getPrice() != null ? productDTO.getPrice() : 0f);
                product.setQuantityAvailable(productDTO.getQuantityAvailable() != null ? productDTO.getQuantityAvailable() : 0);

                try {
                    product = this.productRepository.save(product);
                    responseDTO.setSuccess(true);
                    responseDTO.setMessage("Product updated successfully");
                    responseDTO.setProductDTO(this.productMapper.toDTO(product));
                } catch (Exception e) {
                    // error while updating products with given id
                    responseDTO.setSuccess(false);
                    responseDTO.setMessage("Error updating product with given id : " + productDTO.getId() + " " + e.getMessage());
                    responseDTO.setProductDTO(null);
                }

            }
            else {
                // product does not exist with given id
                responseDTO.setSuccess(false);
                responseDTO.setMessage("Product not found with given product id : " + productDTO.getId() + ". Please check the id and try again.");
                responseDTO.setProductDTO(null);
            }

        }
        else {
            // please provide id to update the product
            responseDTO.setSuccess(false);
            responseDTO.setMessage("Invalid request. Please provide a valid product ID.");
            responseDTO.setProductDTO(null);
        }

        return responseDTO;
    }

    @Override
    public ProductResponseDTO deleteProduct(ProductDTO productDTO) {

        log.debug("Attempting to delete product");
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        if(productDTO.getId() != null) {
            Optional<Product> productFromDB = this.productRepository.findById(productDTO.getId());

            if(productFromDB.isPresent()) {
                var product = productFromDB.get();

                try {
                    this.productRepository.delete(product);
                    responseDTO.setSuccess(true);
                    responseDTO.setMessage("Product deleted successfully");
                    responseDTO.setProductDTO(null);
                } catch (Exception e) {
                    // error while deleting product with given id
                    responseDTO.setSuccess(false);
                    responseDTO.setMessage("Error deleting product with given id : " + productDTO.getId() + " " + e.getMessage());
                    responseDTO.setProductDTO(null);

                }
            }
            else {
                // product does not exist with given id
                responseDTO.setSuccess(false);
                responseDTO.setMessage("Product not found with given product id : " + productDTO.getId() + ". Please check the id and try again.");
                responseDTO.setProductDTO(null);
            }
        }
        else {
            // please provide id to delete the product
            responseDTO.setSuccess(false);
            responseDTO.setMessage("Invalid request. Please provide a valid product ID.");
            responseDTO.setProductDTO(null);
        }

        return responseDTO;
    }

    @Override
    public ProductResponseDTO applyDiscountPercentageOrTaxRate(ProductDTO productDTO) {
        log.debug("Attempting to apply discount or tax based on the fields provided");
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        if(productDTO.getId() != null) {
            Optional<Product> productFromDB = this.productRepository.findById(productDTO.getId());

            if(productFromDB.isPresent()) {
                var product = productFromDB.get();

                float updatedPrice = this.updatePrice(product.getPrice(), productDTO.getDiscountPercentage(), productDTO.getTaxRate());
                product.setPrice(updatedPrice);

                try {
                    product = this.productRepository.save(product);
                    responseDTO.setSuccess(true);
                    responseDTO.setMessage("Product price updated successfully");

                    ProductDTO productDTO1 = this.productMapper.toDTO(product);
                    productDTO1.setDiscountPercentage(productDTO.getDiscountPercentage());
                    productDTO1.setTaxRate(productDTO.getTaxRate());

                    responseDTO.setProductDTO(productDTO1);
                } catch (Exception e) {
                    // error while updating products with given id
                    responseDTO.setSuccess(false);
                    responseDTO.setMessage("Error updating product price with given id : " + productDTO.getId() + " " + e.getMessage());
                    responseDTO.setProductDTO(null);
                }

            }
            else {
                // product does not exist with given id
                responseDTO.setSuccess(false);
                responseDTO.setMessage("Product not found with given product id : " + productDTO.getId() + ". Please check the id and try again.");
                responseDTO.setProductDTO(null);
            }

        }
        else {
            // please provide id to update the product
            responseDTO.setSuccess(false);
            responseDTO.setMessage("Invalid request. Please provide a valid product ID.");
            responseDTO.setProductDTO(null);
        }

        return responseDTO;
    }

    private Float updatePrice(Float oldPrice, Float discountPercentage, Float taxRate) {

        Float newPrice = oldPrice;
        if(discountPercentage != null && discountPercentage > 0f) {
            newPrice = oldPrice * (1 - (discountPercentage / 100));
        }
        else if(taxRate != null && taxRate > 0f) {
            newPrice = oldPrice * (1 + (taxRate / 100));
        }

        return newPrice;
    }

}
