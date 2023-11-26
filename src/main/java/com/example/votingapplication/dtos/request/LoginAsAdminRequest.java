package com.example.votingapplication.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginAsAdminRequest {
    private String name;
    private String password;
}
