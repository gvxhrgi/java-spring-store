package com.example.demo.services;

import com.example.demo.mappers.ProductMapper;
import com.example.demo.models.products.ProductEntity;
import com.example.demo.models.products.ProductRequest;
import com.example.demo.models.products.ProductResponse;
import com.example.demo.repositories.CommentRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final UserService userService;

    public ProductService(ProductRepository productRepository, UserService userService) {
        this.productRepository = productRepository;
        this.userService = userService;
    }

    public ProductResponse create(Long userId, ProductRequest request) {
        ProductEntity productEntity = ProductMapper.mapRequestToEntity(request);
        productEntity.setOwnerUser(userService.findById(userId));
        ProductEntity save = productRepository.save(productEntity);
        return ProductMapper.mapEntityToResponse(save);
    }

    public ProductResponse view(Long productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found!"));
        return ProductMapper.mapEntityToResponse(productEntity);
    }

    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    public void doesProductExists(Long productId) {
        boolean exists = productRepository.existsById(productId);

        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Doesn't Exists");
        }
    }

    public ProductEntity findById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found!"));
    }
}
