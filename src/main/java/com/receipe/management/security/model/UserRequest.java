package com.receipe.management.security.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRequest implements Serializable {
    private static final long serialVersionUID = 626354526838394L;
    private String username;
    private String password;
}