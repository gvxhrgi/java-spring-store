package com.example.demo.models.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequest {
    @NotBlank(message = "Name Cannot Be Blank")
    @Size(min = 2, max = 26, message = "Name Must Be Min. 2 And Max. 26 Characters Long")
    private String name;
    @NotBlank(message = "Username Cannot Be Blank")
    @Size(min = 4, max = 26, message = "Username Must Be Min. 4 And Max. 26 Characters Long")
    private String userName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
