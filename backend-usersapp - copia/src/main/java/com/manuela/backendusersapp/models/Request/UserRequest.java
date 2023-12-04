package com.manuela.backendusersapp.models.Request;

import javax.validation.constraints.*;

public class UserRequest {
    @NotBlank
    @Size(min = 4, max = 8)
    private String username;
    @NotEmpty
    @Email
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
