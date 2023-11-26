package com.example.votingapplication.services;

import com.example.votingapplication.dtos.request.RegisterCandidateRequest;
import com.example.votingapplication.dtos.request.RegisterForElectionRequest;
import com.example.votingapplication.dtos.response.RegisterCandidateResponse;
import com.example.votingapplication.exceptions.CandidateAlreadyExist;
import com.example.votingapplication.exceptions.IllegalInput;
import com.example.votingapplication.models.Candidate;
import com.example.votingapplication.models.ElectionInfo;
import org.springframework.stereotype.Service;

@Service
public interface CandidateService {

    RegisterCandidateResponse register(RegisterCandidateRequest register) throws CandidateAlreadyExist, IllegalAccessException, IllegalInput;

    ElectionInfo registerForElection(RegisterForElectionRequest registerForElection) throws IllegalAccessException, IllegalInput;
}
