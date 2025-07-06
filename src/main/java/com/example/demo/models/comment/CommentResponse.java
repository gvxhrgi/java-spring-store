package com.example.demo.models.comment;

public class CommentResponse {
    private Long id;
    private String text;
    private String productName;

    public CommentResponse(Long id, String text, String productName) {
        this.id = id;
        this.text = text;
        this.productName = productName;
    }

    public CommentResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
