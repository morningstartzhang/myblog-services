package com.lovesh.ucweb.entity;

import lombok.Data;

@Data
public class User {

    private Long id;

    private String code;

    private String mobile;

    private String email;

    private String password;
}
