package com.example.votingapplication.services;

import com.example.votingapplication.dtos.request.RegisterForElectionRequest;
import com.example.votingapplication.exceptions.IllegalInput;
import com.example.votingapplication.models.ElectionInfo;
import org.springframework.stereotype.Service;

@Service
public class EVoteElectionService implements  ElectionService{

    private final EvoteAdminService eVoteAdminService;

    public EVoteElectionService(EvoteAdminService adminService) {
        this.eVoteAdminService = adminService;
    }

    @Override
    public ElectionInfo registerCandidatesForElection(RegisterForElectionRequest registerForElection) throws  IllegalInput {
        return eVoteAdminService.registerCandidateForElection(registerForElection);
    }
}
