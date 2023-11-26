package com.example.votingapplication.mapper;

import com.example.votingapplication.dtos.response.RegisterCandidateResponse;
import com.example.votingapplication.models.Candidate;

public class ResponseMapper {


    public static RegisterCandidateResponse mapp(Candidate candidate) {
        RegisterCandidateResponse response = new RegisterCandidateResponse();
        response.setName(candidate.getFirstName());
        response.setRegistrationNumber(candidate.getRegistrationNumber());
        return response;
    }
}
