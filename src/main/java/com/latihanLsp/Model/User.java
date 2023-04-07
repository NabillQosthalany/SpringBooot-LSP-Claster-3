package com.latihanLsp.Model;

import io.swagger.annotations.ApiModelProperty;

public class User {
    @ApiModelProperty(position = 1)

    private int id;
    @ApiModelProperty(position = 2)

    private String username;
    @ApiModelProperty(position = 3)

    private String password;
    @ApiModelProperty(position = 4)

    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
