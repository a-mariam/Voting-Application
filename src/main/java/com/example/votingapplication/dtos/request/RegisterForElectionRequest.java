package com.example.votingapplication.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterForElectionRequest {


    private String candidateRegistrationNumber;
    private String candidateEmail;
    private int age;
    private String party;
    private String position;
    private String electionType;

}
