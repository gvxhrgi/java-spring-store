package com.example.demo.services;

import com.example.demo.mappers.CommentMapper;
import com.example.demo.models.comment.CommentEntity;
import com.example.demo.models.comment.CommentRequest;
import com.example.demo.models.comment.CommentResponse;
import com.example.demo.models.products.ProductEntity;
import com.example.demo.repositories.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ProductService productService;

    public CommentService(CommentRepository commentRepository, ProductService productService) {
        this.commentRepository = commentRepository;
        this.productService = productService;
    }

    public Page<CommentResponse> getCommentsForProduct(Long productID, Integer size, Integer page) {
        productService.doesProductExists(productID);
        return commentRepository
                .findCommentForProduct(productID,
                        PageRequest.of(page, size, Sort.Direction.DESC, "id"));
    }

    public CommentResponse create(CommentRequest request) {
        ProductEntity productEntity = productService.findById(request.getProductId());
        CommentEntity commentEntity = CommentMapper.mapRequestToEntity(request);
        commentEntity.setProductEntity(productEntity);
        CommentEntity savedComment = commentRepository.save(commentEntity);

        return CommentMapper.mapEntityToResponse(savedComment);
    }
}
