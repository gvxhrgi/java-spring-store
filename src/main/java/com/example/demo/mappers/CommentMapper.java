package com.example.demo.mappers;

import com.example.demo.models.comment.CommentEntity;
import com.example.demo.models.comment.CommentRequest;
import com.example.demo.models.comment.CommentResponse;

public class CommentMapper {
    public static CommentEntity mapRequestToEntity(CommentRequest request) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setText(request.getText());
        return commentEntity;
    }

    public static CommentResponse mapEntityToResponse(CommentEntity entity) {
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setId(entity.getId());
        commentResponse.setText(entity.getText());
        commentResponse.setProductName(entity.getProductEntity().getName());
        return commentResponse;
    }
}
