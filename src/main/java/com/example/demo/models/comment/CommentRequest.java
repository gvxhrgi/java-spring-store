package com.example.demo.models.comment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CommentRequest {
    @NotNull(message = "Text Can't Be Blank!")
    @Size(min = 1, message = "Comment Cant Be Empty!")
    private String text;
    @Positive(message = "Product ID Can't Be Negative!")
    @NotNull(message = "Product ID Can't Be Null")
    private long productId;

    public CommentRequest() {
    }

    public CommentRequest(String text, long productId) {
        this.text = text;
        this.productId = productId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
