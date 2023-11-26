package com.example.votingapplication.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class  RegisterCandidateRequest {

    private String firstName;
    private String lastName;
    private String partyName;

    private Long electionId;
    private String email;
    private int age;
    private String phoneNumber;
}
