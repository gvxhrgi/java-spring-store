package com.example.demo.repositories;

import com.example.demo.models.comment.CommentEntity;
import com.example.demo.models.comment.CommentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    @Query("""
            select new com.example.demo.models.comment.CommentResponse(c.id, c.text, c.productEntity.name) c from CommentEntity c
            where c.productEntity.id =: productId
    """)
    Page<CommentResponse> findCommentForProduct(Long productId, Pageable pageable);
}
