package com.example.flight.model;

import lombok.*;

@Data
@Getter
@Setter
public class AuthRequest {

    private String username;
    private String password;

}