package com.latihanLsp.Model;

import io.swagger.annotations.ApiModelProperty;

public class UserLogin {

    @ApiModelProperty(position = 1)
    private String username;
    @ApiModelProperty(position = 2)
    private String password;

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
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
}
