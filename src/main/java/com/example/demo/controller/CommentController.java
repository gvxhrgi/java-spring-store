package com.example.demo.controller;

import com.example.demo.models.comment.CommentRequest;
import com.example.demo.models.comment.CommentResponse;
import com.example.demo.services.CommentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentResponse> create(@RequestBody @Valid CommentRequest request) {
        CommentResponse commentResponse = commentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentResponse);
    }

    public ResponseEntity<Page<CommentResponse>> findByProductId(
            @RequestParam("productId") Long productId,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size
    ){
        Page<CommentResponse> commentsForProduct = commentService.getCommentsForProduct(productId, page, size);

        return ResponseEntity.status(HttpStatus.OK).body(commentsForProduct);
    }
}
