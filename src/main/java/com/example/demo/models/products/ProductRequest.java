package com.example.demo.models.products;

import jakarta.validation.constraints.NotNull;

public class ProductRequest {
    private Integer count;

    @NotNull(message = "Name Cannot Be Empty")
    private String name;
    private String description;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
