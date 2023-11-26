package com.example.votingapplication.services;

import com.example.votingapplication.dtos.request.RegisterForElectionRequest;
import com.example.votingapplication.exceptions.IllegalInput;
import com.example.votingapplication.models.ElectionInfo;

public interface ElectionService {

    ElectionInfo registerCandidatesForElection(RegisterForElectionRequest registerForElection) throws IllegalAccessException, IllegalInput;

}
