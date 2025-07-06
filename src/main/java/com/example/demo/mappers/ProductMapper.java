package com.example.demo.mappers;

import com.example.demo.models.products.ProductEntity;
import com.example.demo.models.products.ProductRequest;
import com.example.demo.models.products.ProductResponse;

public class ProductMapper {
    public static ProductEntity mapRequestToEntity(ProductRequest productRequest) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCount(productRequest.getCount());
        productEntity.setDescription(productRequest.getDescription());
        productEntity.setName(productRequest.getName());
        return productEntity;
    }

    public static ProductResponse mapEntityToResponse(ProductEntity productEntity) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(productEntity.getId());
        productResponse.setCount(productEntity.getCount());
        productResponse.setDescription(productEntity.getDescription());
        productResponse.setName(productEntity.getName());
        return productResponse;
    }
}
