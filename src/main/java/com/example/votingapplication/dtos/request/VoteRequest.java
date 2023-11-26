package com.example.votingapplication.dtos.request;

import com.example.votingapplication.models.Voter;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class VoteRequest {
    private String candidateName;
    private String candidateParty;
    private String votingNumber;
    private String electionName;
    private Voter voter;

}
