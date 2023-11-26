package com.example.votingapplication.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterVoterRequest {

    private String firstName;

    private String lastName;

    private String email;
    private int age;

    private boolean hasVote;
    private String Password;
    private String phoneNumber;
}
