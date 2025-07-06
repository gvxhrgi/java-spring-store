package com.example.demo.models.products;

import com.example.demo.models.user.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer count;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_user_id")
    private UserEntity ownerUser;

    public ProductEntity(long id, Integer count, String name, String description, UserEntity ownerUser) {
        this.id = id;
        this.count = count;
        this.name = name;
        this.description = description;
        this.ownerUser = ownerUser;
    }

    public ProductEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public UserEntity getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(UserEntity ownerUser) {
        this.ownerUser = ownerUser;
    }
}
